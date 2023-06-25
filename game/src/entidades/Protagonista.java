package entidades;

import java.util.ArrayList;
import java.util.List;
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
    public Protagonista(int hpMax, int def, int atq, int mpMax) {
        super("Protagonista", hpMax, def, atq);
        this.mp = this.mpMax = mpMax;
        inventario = new Inventario();
        listaMagias = new ArrayList<Magia>();
        listaMagias.add(new Magia("Magia de Fogo", "Voce queima o/a %s, causando %d de dano!", "fogo", 20));
        listaMagias.add(new Magia("Magia de Agua", "Voce cria uma bolha ao redor do/da %s, causando %d de dano!", "agua", 20));
        listaMagias.add(new Magia("Magia de Vento", "Voce lança uma rajada de vento no/na %s, causando %d de dano!", "vento", 20));
    }

    /* toString() */
    public String toString() {
        String str = super.toString().replaceFirst("Personagem", "Protagonista") +
            "\n\tmp: " + mp + "\n\tmpMax: " + mpMax + "\n\tlistaMagias:";
        for (Magia m: listaMagias)
            str += " " + m.getNome();
        return str;
    }

    /* Volta atq, def e multiplicadores ao normal (deve ser chamado ao final de uma luta) */
    @Override
    public void resetarStatus() {
        super.resetarStatus();
        for (Magia m: listaMagias)
            m.setMultiplicador(0.);
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
