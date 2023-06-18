package entidades;

import java.util.ArrayList;
import java.util.List;
import itens.Inventario;
import combate.Ataque;
import combate.Magia;

public class Protagonista extends Personagem {
    private final Inventario inventario;
    private final List<Magia> listaMagias;

    /* Construtor */
    public Protagonista(String nome, int hp, int def, int atq) {
        super(nome, hp, def, atq);
        inventario = new Inventario();
        listaMagias = new ArrayList<Magia>();
    }

    /*
     * toString()
     * Personagem:
     *     nome: <nome>
     *     hp: <hp>
     *     def: <def>
     *     atq: <atq>
     *     listaAtaques: <ataque1.nome>, <ataque2.nome>, ...
     *     listaMagias: <magia1.nome>, <magia2.nome>, ...
     */
    public String toString() {
        String str = super.toString().replaceFirst("Personagem", "Protagonista") +
            "\n\tlistaMagias:";
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

}
