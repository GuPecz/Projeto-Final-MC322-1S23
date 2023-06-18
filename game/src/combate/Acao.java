package combate;

import entidades.Personagem;

public abstract class Acao {
    private String nome;
    private boolean habilitado;
    private String msgUso;

    // Construtor
    public Acao(String nome, boolean habilitado, String msgUso) {
        this.nome = nome;
        this.habilitado = habilitado;
        this.msgUso = msgUso;
    }

    public abstract void usar(Personagem usuario, Personagem recebedor);

    public void habilitar() {
        habilitado = true;
    }

    public void desabilitar() {
        habilitado = false;
    }

    // toString()
    public String toString() {
        String str = "Acao:\n\tnome: " + nome + "\n\thabilitado: " + habilitado +
                     "\n\tmsgUso: " + msgUso;
        return str;
    }

    // Getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public boolean getHabilitado() {
        return habilitado;
    }

}
