package entidades;

import combate.Ataque;
import itens.Item;

public class Inimigo extends Personagem {
    private Item loot;
    private final String elemento;
    // TODO - guardar imagem do inimigo como atributo
    // private final Imagem? imagem;



    /* Construtor com ataques */
    public Inimigo(String nome, int hp, int def, int atq, Item loot, String elemento, Ataque... ataques) {
        super(nome, hp, def, atq, ataques);
        this.loot = loot;
        this.elemento = elemento;
        //this.imagem = caminho + getNome() + ".png";
    }

    /* Construtor sem ataques */
    public Inimigo(String nome, int hp, int def, int atq, Item loot, String elemento) {
        super(nome, hp, def, atq);
        this.loot = loot;
        this.elemento = elemento;
        //this.imagem = caminho + getNome() + ".png";
    }

    /*
     * toString()
     * Inimigo:
     *     nome: <nome>
     *     hp: <hp>
     *     def: <def>
     *     atq: <atq>
     *     listaAtaques: <ataque1.nome>, <ataque2.nome>, ...
     *     loot: <loot.getClass()>
     *     elemento: <elemento>
     */
    public String toString() {
        String str = super.toString().replaceFirst("Personagem", "Inimigo") +
            "\n\tloot: " + loot.getClass() + "\n\telemento: " + elemento;
        return str;
    }

    // Getters e setters
    public Item getLoot() {
        return loot;
    }

    public void setLoot(Item loot) {
        this.loot = loot;
    }

    public String getElemento() {
        return elemento;
    }

}
