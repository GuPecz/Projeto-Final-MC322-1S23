package entidades;

import combate.Ataque;
import java.util.ArrayList;

public abstract class Personagem {
    private String nome;
    private int hp;
    private int def;
    private int atq;
    private final ArrayList<Ataque> listaAtaques;

    /* Construtor sem ataques */
    public Personagem(String nome, int hp, int def, int atq) {
        this.nome = nome;
        this.hp = hp;
        this.def = def;
        this.atq = atq;
        listaAtaques = new ArrayList<Ataque>();
    }

    /* Construtor com ataques */
    public Personagem(String nome, int hp, int def, int atq, Ataque... ataques) {
        this(nome, hp, def, atq);
        for (Ataque ataque: ataques)
            listaAtaques.add(ataque);
    }

    /*
     * Reduz a vida do personagem
     * PARAMETROS:
     * vida -- quantidade a ser reduzida
     */
    public void reduzirVida(int vida) {
        hp -= vida;
    }

    /*
     * Aumenta a vida do personagem
     * PARAMETROS:
     * vida -- quantidade a ser aumentada
     */
    public void aumentarVida(int vida) {
        hp += vida;
    }

    /*
     * Reduz a defesa do personagem
     * PARAMETROS:
     * defesa -- quantidade a ser aumentada
     */
    public void aumentarDefesa(int defesa) {
        def += defesa;
    }

    /*
     * Reduz a defesa do personagem
     * PARAMETROS:
     * defesa -- quantidade a ser reduzida
     */
    public void reduzirDefesa(int defesa) {
        def -= defesa;
    }

    /*
     * Aumenta o ataque do personagem
     * PARAMETROS:
     * atq -- quantidade a ser reduzida
     */
    public void aumentarAtq(int atq) {
        this.atq += atq;
    }

    /*
     * Reduz o ataque do personagem
     * PARAMETROS:
     * atq -- quantidade a ser reduzida
     */
    public void reduzitAtq(int atq) {
        this.atq -= atq;
    }

    /* Retorna boolean indicando se o personagem esta vivo */
    // TODO - mudar nome?
    public boolean vivo() {
        return hp > 0;
    }

    /*
     * toString()
     * Personagem:
     *     nome: <nome>
     *     hp: <hp>
     *     def: <def>
     *     atq: <atq>
     *     listaAtaques: <ataque1.nome>, <ataque2.nome>, ...
     */
    public String toString() {
        String str = String.format("Personagem:\n\tnome: %s\n\thp: %d\n\tdef: %d\n\t" +
            "atq: %d\n\tlistaAtaques:", nome, hp, def, atq);
        for (Ataque ataque: listaAtaques)
            str += " " + ataque.getNome();
        return str;
    }


    // Getters e setters
    public int getAtq() {
        return atq;
    }

    public void setAtq(int ataque) {
        this.atq = ataque;
    }

    public ArrayList<Ataque> getListaAtaques() {
        return listaAtaques;
    }

    public int getDef() {
        return def;
    }
    
    public void setDef(int defesa) {
        this.def = defesa;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int vida) {
        this.hp = vida;
    }

}
