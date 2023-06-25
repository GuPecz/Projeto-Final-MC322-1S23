package combate;

public abstract class EfeitoStatus extends Acao {
    /* Atributos */
    private int alteracaoStatus;

    /* Construtor */
    public EfeitoStatus(String nome, boolean habilitado, String msgUso, int alteracaoStatus) {
        super(nome, habilitado, msgUso);
        this.alteracaoStatus = alteracaoStatus;
    }

    /* Getters e setters */
    public int getAlteracaoStatus() {
        return alteracaoStatus;
    }

    public void setAlteracaoStatus(int alteracaoStatus) {
        this.alteracaoStatus = alteracaoStatus;
    }

}
