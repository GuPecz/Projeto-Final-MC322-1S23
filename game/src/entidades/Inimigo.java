package entidades;

import java.util.List;
import combate.Acao;
import dados.CsvHandler;
import itens.Item;

public class Inimigo extends Personagem {
    private Item loot;
    private final String elemento;
    // TODO - guardar imagem do inimigo como atributo
    // private final Imagem? imagem;

    /* Construtor com ataques */
    public Inimigo(String nome, int hp, int hpMax, int def, int atq, Item loot, String elemento,
            List<Acao> listaAcoes) {
        super(nome, hp, hpMax, def, atq, listaAcoes);
        this.loot = loot;
        this.elemento = elemento;
        getListaAcoes().addAll(CsvHandler.getAtaques(this));
        //this.imagem = caminho + getNome() + ".png";
    }

    // toString()
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
