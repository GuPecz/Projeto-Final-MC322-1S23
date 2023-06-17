package itens;

public abstract class Item {
    private int qtdUsos; // quantidade de usos do item (esgotado se <= 0)
    
    /* Construtor */
    public Item (int qtdUsos) {
        this.qtdUsos = qtdUsos;
    }

    /*
     * Construtor
     * Cria item com 0 usos
     */
    public Item() {
        this(0);
    }

    /*
     * Reduz a quantidade de usos do item
     * PARAMETROS:
     * qtdReduzida -- quantidade a ser reduzida
     */
    public void reduzirUsos(int qtdReduzida) {
        qtdUsos -= qtdReduzida;
    }

    /*
     * Aumenta a quantidade de usos do item
     * PARAMETROS:
     * qtdAumentada -- quantidade a ser reduzida
     */
    public void aumentarUsos(int qtdAumentada) {
        qtdUsos += qtdAumentada;
    }

    /*
     * Retorna boolean indicando se o item nao tem mais usos
     */
    public boolean itemEsgotado() {
        return qtdUsos <= 0;
    }

    /* 
     * toString()
     * Item:
     *     qtdUsos: <qtdUsos>
     */
    public String toString() {
        String str = "Item:\n\tqtdUsos: " + String.valueOf(qtdUsos);
        return str;
    }

    // Getters e setters
    public int getQtdUsos() {
        return qtdUsos;
    }

    public void setQtdUsos(int qtdUsos) {
        this.qtdUsos = qtdUsos;
    }
}
