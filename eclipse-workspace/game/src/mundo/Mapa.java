package mundo;

import java.util.ArrayList;
import java.util.List;

import combate.Acao;
import combate.Ataque;
import combate.EfeitoStatus;
import dados.CsvHandler;
import entidades.Inimigo;

public class Mapa {
    private int ordem; // Ordem da matriz quadrada de salas
    private Sala[][] salas;
    private int[] localizacaoProtagonista; // Coordenada da localização do protagonista no mapa    
    
    /* Construtor */
    public Mapa(int ordem) {
        this.ordem = ordem;
        this.salas = new Sala[ordem][ordem];
        // Protagonista começa na sala [0][0]
        this.localizacaoProtagonista[0] = 0;
        this.localizacaoProtagonista[1] = 0;
        inicializaSalas();
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

    /*
     * Inicializa as salas com seus conteúdos
     */
    private void inicializaSalas() {
        String[][] dados = CsvHandler.getDadosSalas(ordem);
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
                    String[] dadosInimigo = CsvHandler.getDadosInimigo(conteudo[1]);
                    /*
                     * dadosinimigo[i] = 
                     * nome,     i = 0
                     * hpMax,    i = 1 
                     * def,      i = 2
                     * atq,      i = 3
                     * loot,     i = 4
                     * elemento, i = 5
                     */
                    salas[i][j] = new Sala(false, "", new Inimigo(dadosInimigo[0], Integer.parseInt(dadosInimigo[1]), Integer.parseInt(dadosInimigo[2]), Integer.parseInt(dadosInimigo[3]), dadosInimigo[4], dadosInimigo[5]));
                    break;

                    // Sala com escada
                    case "escada":
                    salas[i][j] = new Sala(true, null, null);
                    break;

                    // Sala vazia
                    default:
                    salas[i][j] = new Sala(false, "", null);
                    break;
                }
            }
    }

    

    /*
     * Retorna as conexões de uma sala
     * PARAMETROS:
     * linha, coluna sao as coordenadas da sala na matriz
     */
    public boolean[] getConexoes(int linha, int coluna) {
        /*
         * Toda sala tem no máximo 4 conexões,
         * representadas no vetor
         * conexoes = [FRENTE, TRÁS, CIMA, BAIXO]
         * 1 = tem conexão
         * 0 = não existe conexão
         */
        boolean[] conexoes = new boolean[] {false, false, false, false};

        // Checando frente
        if (coluna < ordem - 1)
            conexoes[0] = true;

        // Checando trás
        if (coluna < ordem - 1)
            conexoes[1] = true;

        // Checando cima
        if (linha < ordem - 1) // Checando se não é o último andar
            if (salas[linha][coluna].getTemEscada() && salas[linha + 1][coluna].getTemEscada()) // Checando se a sala atual tem escada e a de cima também
                conexoes[2] = true;

        // Checando baixo
        if (linha < ordem - 1) // Checando se não é o primeiro andar
            if (salas[linha][coluna].getTemEscada() && salas[linha - 1][coluna].getTemEscada()) // Checando se a sala atual tem escada e a de baixo também
                conexoes[3] = true;

        return conexoes;
    }

    /*
     * Move o personagem de uma sala para outra
     * PARAMETROS
     * destino = id da sala de destino
     */
    public void moverPersonagem(int movHorizontal, int movVertical) {
        localizacaoProtagonista[0] += movHorizontal;
        localizacaoProtagonista[1] += movVertical;
    }
}
