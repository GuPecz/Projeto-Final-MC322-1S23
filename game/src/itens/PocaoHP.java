package itens;

import entidades.Protagonista;

public class PocaoHP extends Pocao {

    public PocaoHP(int qtdUsos) {
        super(qtdUsos);
    }

    public boolean consumir(Protagonista protagonista) {
        if (! pocaoVazia()) {
            protagonista.regenerarVida((int) ValoresPocoes.POCAO_HP.getValor() * protagonista.getHpMax());
            return true;
        }
        return super.consumir(protagonista);
    }
}
