package entidades;

import java.util.ArrayList;
import java.util.List;
//import itens.Inventario;
import combate.Acao;
import combate.Magia;

public class Protagonista extends Personagem {
    /* Atributos */
    private int mp; // mana points
    private int mpMax; // mp maximo
    private final Inventario inventario;
    private final List<Magia> listaMagias;

    /* Classe Inventario aninhada (guarda numero de itens) */
    public class Inventario {
        private int numPocoesHp;
        private int numPocoesMp;
        private int numFlechas;
    }

    /* Construtor */
    public Protagonista(String nome, int hpMax, int def, int atq, int mpMax,
            List<Acao> listaAcoes) {
        super(nome, hpMax, def, atq, listaAcoes);
        this.mp = this.mpMax = mpMax;
        inventario = new Inventario();
        listaMagias = new ArrayList<Magia>();
    }

    /* toString() */
    public String toString() {
        String str = super.toString().replaceFirst("Personagem", "Protagonista") +
            "\n\tmp: " + mp + "mpMax: " + mpMax + "\n\tlistaMagias:";
        for (Magia m: listaMagias)
            str += " " + m.getNome();
        return str;
    }

    /* Getters e setters */
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
