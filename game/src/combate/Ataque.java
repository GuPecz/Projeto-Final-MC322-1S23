package combate;

import java.util.Random;

import engine.Score;
import entidades.Inimigo;
import entidades.Personagem;
import entidades.Protagonista;

public class Ataque extends Acao implements AtaqueInterface {
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
        if (oponente instanceof Inimigo)
            Score.incrementarDanoCausado(dano);
        else if (oponente instanceof Protagonista)
            Score.incrementarDanoRecebido(dano);
        return String.format(getMsgUso(), dano);
    }

    public double calcularMultiplicadorAleatorio() {
        Random num = new Random();
        this.multiplicador = 0.5 + num.nextDouble();
        return this.multiplicador;
    }

    public boolean podeExecutar(Personagem usuario) {
        // Verifica se o usuário possui o ataque na lista de ações disponíveis
        return usuario.getListaAcoes().contains(this);
    }

    /* toString() */
    @Override
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
