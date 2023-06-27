package engine;

import combate.AcaoIndisponivelException;
import entidades.Protagonista;
import mundo.Mapa;
import mundo.Sala;

public class GameModel {
    // atributos
    private Mapa mapa;
    private Protagonista protagonista;
    private Sala salaAtual;
    
    // construtor
    public GameModel() {
        inicializarProtagonista();
        mapa = new Mapa();
        // inicializa na sala [0][0]
        salaAtual = mapa.getSalas()[mapa.getLocalizacaoProtagonista()[0]][mapa.getLocalizacaoProtagonista()[1]];
    }
    
    // cria o protagonista
    private void inicializarProtagonista() {
        protagonista = new Protagonista(200, 100, 100, 100);
    }

    /* Retorna o loot do inimigo e remove ele da sala */
    public String inimigoMorreu() {
        String item = salaAtual.getInimigo().getLoot();
        pegarItem();
        salaAtual.setInimigo(null);
        Score.incrementarInimigosEliminados();
        protagonista.resetarStatus();
        return item;
    }
    
    // protagonista executa a acao
    public String executarAcaoProtagonista(String strAcao) throws AcaoIndisponivelException {
        if (salaAtual.getInimigo() == null)
            throw new AcaoIndisponivelException("sem inimigos");
        return protagonista.executarAcao(strAcao, salaAtual.getInimigo());
    }
    
    // inimigo executa acao (aleatoria)
    public String executarAcaoInimigo() {
        return getSalaAtual().getInimigo().executarAcaoAleatoria(protagonista);
    }

    /*
     * RECEBE - cima/baixo/...
     * mapa.moverPersonagem(mapa.getpos[0] + ., ...) - RETORNA sala
     * checar o que tem - adaptar view de acordo
     */
    public void movimentacao(String direcao) {
        if (!salaAtual.getJaVisitada())
            Score.incrementarSalasVisitadas();
        if (direcao.equals("Cima")) {
            mapa.moverPersonagem(1, 0);
        } else if (direcao.equals("Baixo")) {
            mapa.moverPersonagem(-1, 0);
        } else if (direcao.equals("Frente")) {
            mapa.moverPersonagem(0, 1);
        } else if (direcao.equals("Tras")) {
            mapa.moverPersonagem(0, -1);
        }
        salaAtual = mapa.getSalas()[mapa.getLocalizacaoProtagonista()[0]][mapa.getLocalizacaoProtagonista()[1]];
    }

    // retorna as direcoes possiveis para as quais o protagonista pode mover
    public boolean[] getDirecoesPossiveis() {
        return mapa.getConexoes();
    }

    // retorna vetor com [0] = linha, [1] = coluna do protagonista na matriz de salas
    public int[] getPosicaoProtagonista() {
        int[] pos = new int[2];
        pos[0] = mapa.getLocalizacaoProtagonista()[0] + 1;
        pos[1] = mapa.getLocalizacaoProtagonista()[1] + 1;
        return pos;
    }

    // descarta o item (remove da sala)
    public void descartarItem() {
        salaAtual.setItem(null);
    }

    // pega o item na sala atual
    public void pegarItem() {
        if (salaAtual.getItem() != null)
            protagonista.coletarItem(salaAtual.getItem());
        else if (salaAtual.getInimigo() != null) {
            protagonista.coletarItem(salaAtual.getInimigo().getLoot());
            salaAtual.setInimigo(null);
        }
        Score.incrementarQtdItensColetado();
        descartarItem();
    }

    // retorna vetor com:
    // [0]/[1] = hp/hpMax do protagonista
    // [1]/[2] = hp/hpMax do inimigo
    // [3]/[4] = mp/mpMax do protagonista
    public int[] getVidaMana() {
        int[] valores = new int[6];
        valores[0] = protagonista.getHp();
        valores[1] = protagonista.getHpMax();
        valores[2] = salaAtual.getInimigo().getHp();
        valores[3] = salaAtual.getInimigo().getHpMax();
        valores[4] = protagonista.getMp();
        valores[5] = protagonista.getMpMax();
        return valores;
    }

    // getters
    public Sala getSalaAtual() {
        return salaAtual;
    }

    public Protagonista getProtagonista() {
        return protagonista;
    }

    public Mapa getMapa() {
        return mapa;
    }

}
