package itens;

public enum ValoresPocoes {
    POCAO_HP(0.2),
    POCAO_MP(0.3),
    POCAO_BUFF(0.25);
    
    private double valor;

    private ValoresPocoes(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

}
