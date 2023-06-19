package mundo;

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
    
    /*
    * Inicializa o número identificador de cada sala,
    * conforme o índice da mesma na matriz linearizada
    * e com indexação a partir do 1
    *
    * TODO: Inicializar o conteúdo de cada sala
    */
    private void inicializaSalas() {
        for (int i = 0; i < ordem; i++)
        for (int j = 0; j < ordem; j++)
        salas[i][j] = new Sala((ordem * i + j) + 1);
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
    * Retorna as conexões de uma sala
    * PARAMETROS:
    * id = id da sala
    */
    public int[] getConexoes(int id)
    {
        /*
        * Toda sala tem no máximo 4 conexões, neste
        * vetor são representadas os (índices + 1)
        * de suas conexões na forma [NORTE, LESTE, SUL, OESTE]
        * 
        * -1 = não existe conexão
        */
        int[] conexoes = new int[]{-1, -1, -1, -1};
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
    public static void main(String[] args)
    {
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
