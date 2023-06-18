package combate;

import entidades.Inimigo;

public abstract class Ataque {
    private String nome;
    private int danoBase;
    private int multiplicador;

    public Ataque(String nome, int danoBase, int multiplicador) {
        this.nome = nome;
        this.danoBase = danoBase;
        this.multiplicador = multiplicador;
    }

    /* Retorna quanto de dano o inimigo deve receber do ataque */
    public abstract int danoCausado(Inimigo inimigo);

    // Getters e setters
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDanoBase() {
        return danoBase;
    }

    public void setDanoBase(int danoBase) {
        this.danoBase = danoBase;
    }

    public int getMultiplicador() {
        return multiplicador;
    }

    public void setMultiplicador(int multiplicador) {
        this.multiplicador = multiplicador;
    }

}
