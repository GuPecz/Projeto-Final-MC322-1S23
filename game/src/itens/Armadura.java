package itens;

public class Armadura extends Item implements Equipavel {
    /*
     * Atributos herdados:
     * qtdUsos - quanto de dano a armadura ainda pode receber ate quebrar
     */
    private int defesaAdicional; // defesa que deve ser adicionada ao atributo do personagem

    /* Construtor */
    public Armadura(int qtdUsos, int defesaAdicional) {
        super(qtdUsos);
        this.defesaAdicional = defesaAdicional;
    }

    /* toString()
     * Armadura:
     *     qtdUsos: <qtdUsos>
     *     defesaAdicional: <defesaAdicional>
     */
    public String toString() {
        String str = super.toString().replaceFirst("Item", "Armadura") +
            "\n\tdefesaAdicional: " + String.valueOf(defesaAdicional);
        return str;
    }
}
