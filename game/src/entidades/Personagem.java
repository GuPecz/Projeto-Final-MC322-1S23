package entidades;

import combate.Acao;
import combate.Ataque;
import combate.EfeitoStatus;
import dados.CsvHandler;

import java.util.ArrayList;
import java.util.List;

public abstract class Personagem {
    /* Atributos */
    private String nome;
    private int hp; // vida - health points
    private int hpMax; // vida maxima
    private int def; // defesa
    private int defAtual;
    private int atq; // ataque
    private int atqAtual;
    private final List<Acao> listaAcoes;

    /* Construtor sem ataques */
    public Personagem(String nome, int hpMax, int def, int atq) {
        this.nome = nome;
        this.hp = this.hpMax = hpMax;
        this.def = this.defAtual = def;
        this.defAtual = def;
        this.atq = this.atqAtual = atq;
        listaAcoes = new ArrayList<Acao>();
        importarAcoes();
    }

    /* Adicionas as acoes a listaAcoes do personagem */
    private void importarAcoes() {
        for (Ataque atq: CsvHandler.getAtaques(nome))
            listaAcoes.add(atq);
        for (EfeitoStatus es: CsvHandler.getEfeitosStatus(nome))
            listaAcoes.add(es);
    }

    /* Volta atq e def ao normal (deve ser chamado ao final de uma luta) */
    public void resetarStatus() {
        atqAtual = atq;
        defAtual = def;
    }

    /*
     * Reduz a vida do personagem
     * PARAMETROS:
     * vida -- quantidade a ser reduzida
     */
    public void reduzirVida(int vida) {
        hp -= vida;
        if (hp < 0)
            hp = 0;
    }

    /*
     * Aumenta a vida do personagem
     * PARAMETROS:
     * vida -- quantidade a ser aumentada
     */
    public void regenerarVida(int vida) {
        hp += vida;
        if (hp > hpMax)
            hp = hpMax;
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
        if (this.def <= 0)
            this.def = 1;
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
    public void reduzirAtq(int atq) {
        this.atq -= atq;
        if (this.atq <= 0)
            this.atq = 1;
    }

    /* Retorna boolean indicando se o personagem esta vivo */
    public boolean vivo() {
        return hp > 0;
    }

    /* toString() */
    public String toString() {
        String str = String.format("Personagem:\n\tnome: %s\n\thp: %d\n\thpMax: %d\n\tdef: %d\n\t" +
            "defAtual: %d\n\tatq: %d\n\tatqAtual: %d\n\tlistaAcoes:", nome, hp, hpMax, def,
            defAtual, atq, atqAtual);
        for (Acao acao: listaAcoes)
            str += " " + acao.getNome();
        return str;
    }


    /* Getters e setters */
    public int getAtq() {
        return atq;
    }

    public void setAtq(int atq) {
        this.atq = atq;
    }

    public List<Acao> getListaAcoes() {
        return listaAcoes;
    }

    public int getDef() {
        return def;
    }
    
    public void setDef(int def) {
        this.def = def;
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

    public void setAtqAtual(int atqAtual) {
        this.atqAtual = atqAtual;
    }

    public int getAtqAtual() {
        return atqAtual;
    }

    public void setDefAtual(int defAtual) {
        this.defAtual = defAtual;
    }

    public int getDefAtual() {
        return defAtual;
    }

    public void setHp(int vida) {
        this.hp = vida;
    }

    public int getHpMax() {
        return hpMax;
    }

    public void setHpMax(int hpMax) {
        this.hpMax = hpMax;
    }

}
