package itens;

import entidades.Protagonista;

public abstract class Pocao {
    int qtdUsos;

    public Pocao(int qtdUsos) {
        this.qtdUsos = qtdUsos;
    }

    public boolean consumir(Protagonista protagonista) {
        qtdUsos--;
        return true;
    }

    public boolean pocaoVazia() {
        return qtdUsos <= 0;
    }

}
