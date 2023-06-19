package entidades;

import java.util.List;
import combate.Acao;
import dados.CsvHandler;

public class Inimigo extends Personagem {
    /* Atributos */
    private String loot;
    private final String elemento;
    // TODO - guardar imagem do inimigo como atributo
    // private final Imagem? imagem;

    /* Construtor */
    public Inimigo(String nome, int hpMax, int def, int atq, String loot, String elemento,
            List<Acao> listaAcoes) {
        super(nome, hpMax, def, atq, listaAcoes);
        this.loot = loot;
        this.elemento = elemento;
        getListaAcoes().addAll(CsvHandler.getAtaques(nome));
        //this.imagem = caminho + getNome() + ".png";
    }

    /* toString() */
    public String toString() {
        String str = super.toString().replaceFirst("Personagem", "Inimigo") +
            "\n\tloot: " + loot.getClass() + "\n\telemento: " + elemento;
        return str;
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
