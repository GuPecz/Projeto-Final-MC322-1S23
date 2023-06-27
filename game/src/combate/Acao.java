package combate;

import entidades.Personagem;

public abstract class Acao {
    /* Atributos */
    private String nome;
    private boolean habilitado;
    private String msgUso;

    /* Construtor */
    protected Acao(String nome, boolean habilitado, String msgUso) {
        this.nome = nome;
        this.habilitado = habilitado;
        this.msgUso = msgUso;
    }

    /*
     * Executa a acao e retorna inteiro com informacao especifica para cada acao
     * PARAMETROS:
     * - usuario: personagem que realizou a acao
     * - oponente: oponente do usuario
     * THROWS:
     * - AcaoIndisponivelException: quando a acao nao pode ser executada
     */
    public abstract String executar(Personagem usuario, Personagem oponente);

    /* Habilita o ataque */
    public void habilitar() {
        habilitado = true;
    }

    /* Desabilita o ataque */
    // TODO - remover se n estiver sendo usado
    public void desabilitar() {
        habilitado = false;
    }

    /* toString() */
    public String toString() {
        return "Acao:\n\tnome: " + nome
                + "\n\thabilitado: " + habilitado
                + "\n\tmsgUso: " + msgUso;
    }

    /* Getters e setters */
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean getHabilitado() {
        return habilitado;
    }

    public String getMsgUso() {
        return msgUso;
    }

}
