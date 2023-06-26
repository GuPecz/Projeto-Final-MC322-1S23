package entidades;

public class Inventario {
    /* Atributos */
    private int numPocoesHp;
    private int numPocoesMp;
    private int numPocoesForca;
    private int numFlechas;

    /* Construtor */
    public Inventario() {
        numPocoesHp = numPocoesMp = numFlechas = numPocoesForca = 0;
    }

    /* Aumenta o numero de pocoes de vida
     * PARAMETROS:
     * qtd -- quantidade de pocoes aumentada
     */
    public void aumentarPocoesHp(int qtd) {
        numPocoesHp += qtd;
    }

    /* Aumenta o numero de pocoes de mana
     * PARAMETROS:
     * qtd -- quantidade de pocoes aumentada
     */
    public void aumentarPocoesMp(int qtd) {
        numPocoesMp += qtd;
    }

    /* Aumenta o numero de pocoes de forca
     * PARAMETROS:
     * qtd -- quantidade de pocoes aumentada
     */
    public void aumentarPocoesForca(int qtd) {
        numPocoesForca += qtd;
    }

    /* Aumenta o numero de flechas
     * PARAMETROS:
     * qtd -- quantidade de flechas aumentada
     */
    public void aumentarFlechas(int qtd) {
        numFlechas += qtd;
    }

    /* Usa e reduz em 1 o numero de pocoes de vida */
    public void usarPocaoHp(Personagem personagem) {
        personagem.regenerarVida((int) (personagem.getHpMax() * 0.5));
        numPocoesHp--;
    }

    /* Usa e reduz em 1 o numero de pocoes de mana */
    public void usarPocaoMp(Protagonista protagonista) {
        protagonista.regenerarMana((int) (protagonista.getMpMax() * 0.5));
        numPocoesMp--;
    }

    /* Usa e reduz em 1 o numero de pocoes de forca */
    public void usarPocaoForca(Protagonista protagonista) {
        protagonista.aumentarAtq(30);
        protagonista.aumentarDefesa(30);
        numPocoesForca--;
    }

    /* Reduz em 1 o numero de flechas */
    public void reduzirFlechas() {
        numFlechas--;
    }

    /* Getters e setters */
    public int getNumFlechas() {
        return numFlechas;
    }

    public int getNumPocoesForca() {
        return numPocoesForca;
    }

    public int getNumPocoesHp() {
        return numPocoesHp;
    }

    public int getNumPocoesMp() {
        return numPocoesMp;
    }

    public void setNumFlechas(int numFlechas) {
        this.numFlechas = numFlechas;
    }

    public void setNumPocoesForca(int numPocoesForca) {
        this.numPocoesForca = numPocoesForca;
    }

    public void setNumPocoesHp(int numPocoesHp) {
        this.numPocoesHp = numPocoesHp;
    }

    public void setNumPocoesMp(int numPocoesMp) {
        this.numPocoesMp = numPocoesMp;
    }

}