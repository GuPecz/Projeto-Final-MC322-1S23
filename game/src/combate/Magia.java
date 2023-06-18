package combate;

import dados.CsvHandler;
import entidades.Inimigo;

public class Magia extends Ataque {
    private String elemento;
    private int custoMp;

    public Magia(String nome, int danoBase, String elemento, int custoMp) {
        super(nome, danoBase);
        this.elemento = elemento;
        this.custoMp = custoMp;
    }

    public int danoCausado(Inimigo inimigo) {
        double multiplicador = CsvHandler.getMultiplicador(elemento, inimigo.getElemento());
        if (multiplicador != 0.) { // retorno padrao da funcao quando nao encontra o elemento
            // roubei do lol -- https://leagueoflegends.fandom.com/wiki/Magic_resistance?so=search
            return (int) ((getDanoBase() * multiplicador) * (100. / (100 + inimigo.getDef())));
        }
        return 0;
    }



    // Getters e setters
    public String getElemento() {
        return elemento;
    }

    public void setElemento(String elemento) {
        this.elemento = elemento;
    }

    public int getCustoMp() {
        return custoMp;
    }

    public void setCustoMp(int custoMp) {
        this.custoMp = custoMp;
    }

}
