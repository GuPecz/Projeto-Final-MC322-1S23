package combate;

import dados.LeituraCsv;
import entidades.Inimigo;
import entidades.Personagem;
import entidades.Protagonista;

public class Magia extends Ataque {
    /* Atributos */
    private int danoBase;
    private String elemento;
    private int custoMp;

    /* Construtor */
    public Magia(String nome, String msgUso, int danoBase, String elemento, int custoMp) {
        super(nome, false, msgUso, 0.); // inicia desabilitada (ate achar scroll)
        this.danoBase = danoBase;
        this.elemento = elemento;
        this.custoMp = custoMp;
    }

    /* 
     * Retorna quanto de dano a magia deve causar
     * PARAMETROS:
     * - alvo: personagem que receberá o dano
     */
    private int danoCausado(Personagem alvo) {
        // obtém o multiplicador de dano sobre o elemento do inimigo
        if (super.getMultiplicador() == 0.)
            super.setMultiplicador(LeituraCsv.getMultiplicador(elemento, ((Inimigo) alvo).getElemento()));
        // calculo do dano causado: (dano * multiplicador) * (100 / (100 + def))
        int danoCausado = (int) ((danoBase * getMultiplicador()) * (100. / (100 + alvo.getDefAtual())));;
        return danoCausado;
    }

    /*
     * Executa a magia (causa dano ao inimigo)
     * PARAMETROS:
     * - usuario: personagem que usou a magia (Protagonista)
     * - recebedor: personagem que receberá o dano
     */
    public String executar(Protagonista usuario, Personagem oponente) {
        String msgUso;
        int dano = danoCausado(oponente);
        oponente.reduzirVida(dano);
        usuario.reduzirMana(custoMp);
        msgUso = super.getMsgUso();
        msgUso = String.format(msgUso, oponente.getNome(), dano);
        if (super.getMultiplicador() == 1.25) {
            msgUso += " Super efetivo!";
        } else {
            msgUso += " Pouco efetivo...";
        }
        return msgUso;
    }

    /* Getters e setters */
    public String getElemento() {
        return elemento;
    }

    public void setElemento(String elemento) {
        this.elemento = elemento;
    }

    public int getCustoMp() {
        return custoMp;
    }

    public void setCustoMp(int custoMp) {
        this.custoMp = custoMp;
    }

}
