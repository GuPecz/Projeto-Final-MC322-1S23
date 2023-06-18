package entidades;

import java.util.ArrayList;
import java.util.List;
import itens.Inventario;
import combate.Ataque;
import combate.Magia;

public class Protagonista extends Personagem {
    private int mp; // mana points
    private int mpMax; // mp maximo
    private final Inventario inventario;
    private final List<Magia> listaMagias;

    /* Construtor */
    public Protagonista(String nome, int hp, int hpMax, int def, int atq, int mp, int mpMax) {
        super(nome, hp, hpMax, def, atq);
        this.mp = mp;
        this.mpMax = mpMax;
        inventario = new Inventario();
        listaMagias = new ArrayList<Magia>();
    }

    // toString()
    public String toString() {
        String str = super.toString().replaceFirst("Personagem", "Protagonista") +
            "\n\tmp: " + mp + "mpMax: " + mpMax + "\n\tlistaMagias:";
        for (Magia m: listaMagias)
            str += " " + m.getNome();
        return str;
    }

    // Getters e setters
    public Inventario getInventario() {
        return inventario;
    }

    public List<Magia> getListaMagias() {
        return listaMagias;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }
    
    public int getMp() {
        return mp;
    }

}
