package combate;

import entidades.Personagem;

public class Ataque extends Acao {
    private int danoBase;

    public Ataque(String nome, boolean habilitado, String msgUso, int danoBase) {
        super(nome, habilitado, msgUso);
        this.danoBase = danoBase;
    }

    /* Retorna quanto de dano o alvo deve receber do ataque */
    public int danoCausado(Personagem alvo) {
        return (int) (danoBase * (100. / (100 + alvo.getDef())));
    }

    @Override
    public void usar(Personagem usuario, Personagem recebedor) {
                
    }

    // toString()
    public String toString() {
        String str = super.toString().replaceFirst("Acao", "Ataque");
        str += "\n\tdanoBase: " + danoBase;
        return str;
    }

    // Getters e setters
    public int getDanoBase() {
        return danoBase;
    }

    public void setDanoBase(int danoBase) {
        this.danoBase = danoBase;
    }



}
