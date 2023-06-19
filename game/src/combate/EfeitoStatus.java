package combate;

public abstract class EfeitoStatus extends Acao {
    private int alteracaoAtq;
    private int alteracaoDef;

    public EfeitoStatus(String nome, boolean habilitado, String msgUso, int alteracaoAtq, int alteracaoDef) {
        super(nome, habilitado, msgUso);
        this.alteracaoAtq = alteracaoAtq;
        this.alteracaoDef = alteracaoDef;
    }

    // Getters e setters
    public int getAlteracaoAtq() {
        return alteracaoAtq;
    }

    public void setAlteracaoAtq(int alteracaoAtq) {
        this.alteracaoAtq = alteracaoAtq;
    }

    public int getAlteracaoDef() {
        return alteracaoDef;
    }

    public void setAlteracaoDef(int alteracaoDef) {
        this.alteracaoDef = alteracaoDef;
    }

}
