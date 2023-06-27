package combate;

import dados.LeituraCsv;
import engine.Score;
import entidades.Inimigo;
import entidades.Personagem;
import entidades.Protagonista;

public class Magia extends Acao implements AtaqueInterface {
    /* Atributos */
    private double multiplicador;
    private int danoBase;
    private String elemento;
    private int custoMp;

    /* Construtor */
    public Magia(String nome, String msgUso, int danoBase, String elemento, int custoMp) {
        super(nome, false, msgUso); // inicia desabilitada (ate achar scroll)
        this.danoBase = danoBase;
        this.elemento = elemento;
        this.custoMp = custoMp;
        multiplicador = 0.;
    }

    /*
     * Executa a magia (causa dano ao oponente)
     * PARAMETROS:
     * - usuario: personagem que usou a magia (Protagonista)
     * - oponente: personagem que receberá o dano
     */
    @Override
    public String executar(Personagem usuario, Personagem oponente) {
        String msgUso;
        int dano = danoCausado(oponente);
        oponente.reduzirVida(dano);
       ((Protagonista) usuario).reduzirMana(custoMp);
        msgUso = super.getMsgUso();
        msgUso = String.format(msgUso, oponente.getNome(), dano);
        Score.incrementarDanoCausado(dano);
        if (multiplicador == 1.25) {
            msgUso += " Super efetivo!";
        } else {
            msgUso += " Pouco efetivo...";
        }
        return msgUso;
    }

    /* Retorna boolean indicando se a magia pode ser executada */
    @Override
    public boolean podeExecutar(Personagem usuario) {
        return getHabilitado() && ((Protagonista) usuario).getListaMagias().contains(this);
    }

    /* Calcula o multiplicador da magia durante a batalha */
    @Override
    public double calcularMultiplicador() {
        return multiplicador;
    }

    /* 
     * Retorna quanto de dano a magia deve causar
     * PARAMETROS:
     * - alvo: personagem que receberá o dano
     */
    private int danoCausado(Personagem alvo) {
        // obtém o multiplicador de dano sobre o elemento do inimigo
        if (multiplicador == 0.)
            multiplicador = LeituraCsv.getMultiplicador(elemento, ((Inimigo) alvo).getElemento());
        // calculo do dano causado: (dano * multiplicador) * (100 / (100 + def))
        int danoCausado = (int) ((danoBase * multiplicador) * (100. / (100 + alvo.getDefAtual())));;
        return danoCausado;
    }

    /* Reseta o multiplicador para 0*/
    public void resetarMultiplicador() {
        multiplicador = 0.;
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

    public double getMultiplicador() {
        return multiplicador;
    }

    public void setMultiplicador(double multiplicador) {
        this.multiplicador = multiplicador;
    }

}
