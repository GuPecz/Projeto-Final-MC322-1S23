package mundo;

import dados.LeituraCsv;
import entidades.Inimigo;

public class Mapa {
    private int ordem; // Ordem da matriz quadrada de salas
    private Sala[][] salas;
    private int[] localizacaoProtagonista; // Coordenada da localização do protagonista no mapa    
    
    /* Construtor */
    public Mapa() {
        ordem = 7;
        this.salas = new Sala[ordem][ordem];
        // Protagonista começa na sala [0][0]
        localizacaoProtagonista = new int[2];
        this.localizacaoProtagonista[0] = 0;
        this.localizacaoProtagonista[1] = 0;
        inicializaSalas();
        // A sala [0][0] acaba de ser visitada
        salas[0][0].setJaVisitada(true);
    }
    
    /*
     * Inicializa as salas com seus conteúdos
     */
    private void inicializaSalas() {
        String[][] dados = LeituraCsv.getDadosSalas(ordem);
        String[] conteudo;
        /*
        * dados[i][j] = "", se a sala ij for vazia
        *               "classe do conteúdo-nome do conteúdo", se a sala ij possuir um item ou inimigo
        * assim para cada sala ij, conteudo = [classe do conteúdo, nome do conteúdo]
        */
        for (int i = 0; i < ordem; i++)
            for (int j = 0; j < ordem; j++) {
                conteudo = dados[i][j].split("-");
                switch (conteudo[0]) {
                    // Sala com item
                    case "item":
                    salas[i][j] = new Sala(false, conteudo[1], null);
                    break;

                    // Sala com inimigo
                    case "inimigo":
                    String[] dadosInimigo = LeituraCsv.getDadosInimigo(conteudo[1]);
                    /*
                     * dadosinimigo[i] = 
                     * nome,     i = 0
                     * hpMax,    i = 1 
                     * def,      i = 2
                     * atq,      i = 3
                     * loot,     i = 4
                     * elemento, i = 5
                     */
                    salas[i][j] = new Sala(false, null, new Inimigo(dadosInimigo[0], Integer.parseInt(dadosInimigo[1]), Integer.parseInt(dadosInimigo[2]), Integer.parseInt(dadosInimigo[3]), dadosInimigo[4], dadosInimigo[5]));
                    break;

                    // Sala com escada
                    case "escada":
                    salas[i][j] = new Sala(true, null, null);
                    break;

                    // Sala vazia
                    default:
                    salas[i][j] = new Sala(false, null, null);
                    break;
                }
            }
    }

    

    /*
     * Retorna as conexões de uma sala
     * PARAMETROS:
     * linha, coluna sao as coordenadas da sala na matriz
     */
    public boolean[] getConexoes() {
        /*
         * Toda sala tem no máximo 4 conexões,
         * representadas no vetor
         * conexoes = [FRENTE, TRÁS, CIMA, BAIXO]
         * true = tem conexão
         * false = não existe conexão
         */
        int linha = localizacaoProtagonista[0];
        int coluna = localizacaoProtagonista[1];
        boolean[] conexoes = new boolean[] {false, false, false, false};

        // Checando frente
        if (coluna < ordem - 1)
            conexoes[0] = true;

        // Checando trás
        if (coluna > 0)
            conexoes[1] = true;

        // Checando cima
        if ((linha < ordem - 1) // Checando se não é o último andar
            && (salas[linha][coluna].getTemEscada() && salas[linha + 1][coluna].getTemEscada())) // Checando se a sala atual tem escada e a de cima também
                conexoes[2] = true;

        // Checando baixo
        if ((linha > 0) // Checando se não é o primeiro andar
            && (salas[linha][coluna].getTemEscada() && salas[linha - 1][coluna].getTemEscada())) // Checando se a sala atual tem escada e a de baixo também
                conexoes[3] = true;

        return conexoes;
    }

    /*
     * Move o personagem de uma sala para outra
     * PARAMETROS
     * destino = id da sala de destino
     */
    public void moverPersonagem(int movLinha, int movColuna) {
        Sala salaAtual = salas[localizacaoProtagonista[0]][localizacaoProtagonista[1]];
        if (!salaAtual.getJaVisitada())
            salaAtual.setJaVisitada(true);
        localizacaoProtagonista[0] += movLinha;
        localizacaoProtagonista[1] += movColuna;
    }

    /* Getters e setters */
    public int getOrdem() {
        return ordem;
    }
    
    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    public Sala[][] getSalas() {
        return salas;
    }
    
    public int[] getLocalizacaoProtagonista() {
        return localizacaoProtagonista;
    }

    public void setLocalizacaoProtagonista(int[] localizacaoProtagonista) {
        this.localizacaoProtagonista = localizacaoProtagonista;
    }
}
