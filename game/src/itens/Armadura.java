package itens;

public class Armadura extends Item implements Equipavel {
    /*
     * Atributos herdados:
     * qtdUsos - quanto de dano a armadura ainda pode receber ate quebrar
     */
    private int armaduraAdicional; // armadura que deve ser adicionada a armadura do personagem

    /* Construtor */
    public Armadura(int qtdUsos, int armaduraAdicional) {
        super(qtdUsos);
        this.armaduraAdicional = armaduraAdicional;
    }

    /* toString()
     * Armadura:
     *     qtdUsos: <qtdUsos>
     *     armaduraAdicional: <armaduraAdicional>
     */
    public String toString() {
        String str = super.toString().replaceFirst("Item", "Armadura") +
            "\n\tarmaduraAdicional: " + String.valueOf(armaduraAdicional);
        return str;
    }
}
