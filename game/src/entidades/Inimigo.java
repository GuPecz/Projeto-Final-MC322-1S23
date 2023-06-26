package entidades;

import java.util.Random;

public class Inimigo extends Personagem {
    /* Atributos */
    private String loot;
    private final String elemento;
    // TODO - guardar imagem do inimigo como atributo
    // private final Imagem? imagem;

    /* Construtor */
    public Inimigo(String nome, int hpMax, int def, int atq, String loot, String elemento) {
        super(nome, hpMax, def, atq);
        this.loot = loot;
        this.elemento = elemento;
        //this.imagem = caminho + getNome() + ".png";
    }

    /* toString() */
    public String toString() {
        return super.toString().replaceFirst("Personagem", "Inimigo") +
            "\n\tloot: " + loot.getClass() + "\n\telemento: " + elemento;
    }

    public String executarAcaoAleatoria(Protagonista protagonista) {
        return getListaAcoes().get(Math.abs((new Random()).nextInt()) % getListaAcoes().size()).executar(this, protagonista);
    }

    /* Getters e setters */
    public String getLoot() {
        return loot;
    }

    public void setLoot(String loot) {
        this.loot = loot;
    }

    public String getElemento() {
        return elemento;
    }

}
