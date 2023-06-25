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
    private int danoCausado(Personagem alvo) {
        return (int) (multiplicador * (100. / (100 + alvo.getDef())));
    }

    /*
     * Executa o ataque (causa dano ao oponente) e retorna o dano causado
     * PARAMETROS:
     * - usuario: quem usou o ataque
     * - oponente: oponente do usuario
     */
    @Override
    public int executar(Personagem usuario, Personagem oponente) throws AcaoIndisponivelException{
        if (! getHabilitado())
            throw new AcaoIndisponivelException("O ataque ainda não foi desbloqueado!");
        int dano = danoCausado(oponente);
        oponente.reduzirVida(dano);
        return dano;
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
