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
    private int localizacaoProtagonista;
    private Sala[][] salas;

    /* Construtor */
    public Mapa(int ordem) {
        this.ordem = ordem;
        this.salas = new Sala[ordem][ordem];
        this.localizacaoProtagonista = 1; // Protagonista começa na sala 1
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

    public int getLocalizacaoProtagonista() {
        return localizacaoProtagonista;
    }

    public void setLocalizacaoProtagonista(int localizacaoProtagonista) {
        this.localizacaoProtagonista = localizacaoProtagonista;
    }

    /*
     * Inicializa as salas com seu id na matriz linearizada
     * indexado a partir de 1 e com seu conteúdo, caso tenha
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
                    salas[i][j] = new Sala((ordem * i + j) + 1, conteudo[1], null);
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
                     * item,     i = 4
                     * elemento, i = 5
                     */
                    List<Acao> listaAcoes = new ArrayList<Acao>(); // ações são os ataques e efeito status do inimigo
                    List<Ataque> listaAtaques = CsvHandler.getAtaques(conteudo[1]);
                    listaAcoes.addAll(listaAtaques);
                    List<EfeitoStatus> listaEfeitoStatus = CsvHandler.getEfeitosStatus(conteudo[1]);
                    listaAcoes.addAll(listaEfeitoStatus);
                    salas[i][j] = new Sala((ordem * i + j) + 1, "", new Inimigo(dadosInimigo[0], Integer.parseInt(dadosInimigo[1]), Integer.parseInt(dadosInimigo[2]), Integer.parseInt(dadosInimigo[3]), dadosInimigo[4], dadosInimigo[5], listaAcoes));
                    break;

                    // Sala vazia
                    default:
                    salas[i][j] = new Sala((ordem * i + j) + 1, "", null);
                    break;
                }
            }
    }

    /*
     * Retorna as conexões de uma sala
     * PARAMETROS:
     * id = id da sala
     */
    public int[] getConexoes(int id) {
        /*
         * Toda sala tem no máximo 4 conexões, neste
         * vetor são representadas os (índices + 1)
         * de suas conexões na forma [NORTE, LESTE, SUL, OESTE]
         * 
         * -1 = não existe conexão
         */
        int[] conexoes = new int[] { -1, -1, -1, -1 };
        /*
         * Ex.: Matriz de ordem 3
         * 0 1 2 | [2,1] = 7
         * 3 4 5 | 2 = 7 / 3
         * 6 7 8 | 1 = 7 % 3
         */
        int linha = (id - 1) / ordem;
        int coluna = (id - 1) % ordem;

        // Checando norte
        if (linha > 0)
            conexoes[0] = salas[linha - 1][coluna].getId();

        // Checando leste
        if (coluna < ordem - 1)
            conexoes[1] = salas[linha][coluna + 1].getId();

        // Checando sul
        if (linha < ordem - 1)
            conexoes[2] = salas[linha + 1][coluna].getId();

        // Checando oeste
        if (coluna > 0)
            conexoes[3] = salas[linha][coluna - 1].getId();

        return conexoes;
    }

    /*
     * Move o personagem de uma sala para outra
     * PARAMETROS
     * destino = id da sala de destino
     */
    public void moverPersonagem(int destino) {
        localizacaoProtagonista = destino;
    }

    // Testes
    public static void main(String[] args) {
        Mapa mapa = new Mapa(7);

        // Testando os índices das salas
        for (int i = 0; i < mapa.getOrdem(); i++) {
            for (int j = 0; j < mapa.getOrdem(); j++) {
                if ((mapa.ordem * i + j) + 1 < 10)
                    System.out.print(mapa.getSalas()[i][j].getId() + "  ");
                else
                    System.out.print(mapa.getSalas()[i][j].getId() + " ");
            }
            System.out.print("\n");
        }

        // Testando conexões
        System.out.print("Conexões sala 29: ");
        int[] conexoes = mapa.getConexoes(29);
        for (int i = 0; i < 4; i++)
            System.out.print(conexoes[i] + " ");
    }
}
