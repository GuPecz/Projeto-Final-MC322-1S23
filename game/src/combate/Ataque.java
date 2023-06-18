package combate;

import entidades.Inimigo;

public abstract class Ataque {
    private String nome;
    private int danoBase;

    public Ataque(String nome, int danoBase) {
        this.nome = nome;
        this.danoBase = danoBase;
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

}
