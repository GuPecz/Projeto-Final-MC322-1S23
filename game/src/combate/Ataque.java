package combate;

import entidades.Personagem;

public class Ataque extends Acao {
    /* Atributos */
    private double multiplicador;

    /* Construtor */
    public Ataque(String nome, boolean habilitado, String msgUso, double multiplicador) {
        super(nome, habilitado, msgUso);
        this.multiplicador = multiplicador;
    }

    /* 
     * Retorna quanto de dano o ataque deve causar
     * PARAMETROS:
     * - alvo: personagem que receberá o dano
     */
    private int danoCausado(Personagem usuario, Personagem alvo) {
        return (int) ((multiplicador * usuario.getAtqAtual()) * (100. / (100 + alvo.getDefAtual())));
    }

    /*
     * Executa o ataque (causa dano ao oponente) e retorna o dano causado
     * PARAMETROS:
     * - usuario: quem usou o ataque
     * - oponente: oponente do usuario
     */
    @Override
    public String executar(Personagem usuario, Personagem oponente) {
        int dano = danoCausado(usuario, oponente);
        oponente.reduzirVida(dano);
        return String.format(getMsgUso(), dano);
    }

    /* toString() */
    public String toString() {
        String str = super.toString().replaceFirst("Acao", "Ataque");
        str += "\n\tmultiplicador: " + multiplicador;
        return str;
    }

    /* Getters e setters */
    public double getMultiplicador() {
        return multiplicador;
    }

    public void setMultiplicador(double multiplicador) {
        this.multiplicador = multiplicador;
    }

}
