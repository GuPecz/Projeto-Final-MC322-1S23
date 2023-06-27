package entidades;

import java.util.ArrayList;
import java.util.List;
import combate.AcaoIndisponivelException;
import combate.Magia;

public class Protagonista extends Personagem {
    /* Atributos */
    // listaAcoes - [0] Espada, [1] Arco, [2] Soco
    private int mp; // mana points
    private int mpMax; // mp maximo
    private final Inventario inventario;
    private final List<Magia> listaMagias;

    public String executarAcao(String strAcao, Inimigo inimigo) throws AcaoIndisponivelException {
        String msgUso = "";
        switch (strAcao) {
            case "Espada":
                if (! getListaAcoes().get(0).getHabilitado())
                    throw new AcaoIndisponivelException("Voce ainda nao desbloqueou a espada!");
                msgUso = getListaAcoes().get(0).executar(this, inimigo);
                break;
            case "Arco":
                if (inventario.getNumFlechas() <= 0)
                    throw new AcaoIndisponivelException("Voce nao tem flechas");
                msgUso = getListaAcoes().get(1).executar(this, inimigo);
                inventario.reduzirFlechas();
                break;
            case "Pocao de Vida":
                if (inventario.getNumPocoesHp() <= 0)
                    throw new AcaoIndisponivelException("Voce nao tem pocoes de vida");
                msgUso = "Voce recuperou vida!";
                inventario.usarPocaoHp(this);
                break;
            case "Pocao de Mana":
                if (inventario.getNumPocoesMp() <= 0)
                    throw new AcaoIndisponivelException("Voce nao tem pocoes de mana");
                msgUso = "Voce recuperou mana!";
                inventario.usarPocaoMp(this);
                break;
            case "Pocao de Forca":
                if (inventario.getNumPocoesForca() <= 0)
                    throw new AcaoIndisponivelException("Voce nao tem pocoes de forca");
                msgUso = "Voce se sente mais forte!";
                inventario.usarPocaoForca(this);
                break;
            case "Magia de Fogo":
                if (! getListaMagias().get(0).getHabilitado())
                    throw new AcaoIndisponivelException("Voce ainda nao encontrou o Pergaminho de Fogo");
                msgUso = listaMagias.get(0).executar(this, inimigo);
                break;
            case "Magia de Agua":
                if (! getListaMagias().get(1).getHabilitado())
                    throw new AcaoIndisponivelException("Voce ainda nao encontrou o Pergaminho de Agua");
                msgUso = listaMagias.get(1).getMsgUso();
                break;
            case "Magia de Vento":
                if (! getListaMagias().get(2).getHabilitado())
                    throw new AcaoIndisponivelException("Voce ainda nao encontrou o Pergaminho de Vento");
                msgUso = listaMagias.get(2).getMsgUso();
                break;
            case "Soco":
                msgUso = getListaAcoes().get(2).executar(this, inimigo);
                break;
        }
        return msgUso;
    }

    public void coletarItem(String itemColetado) {
        switch (itemColetado) {
            case "Espada":
                getListaAcoes().get(0).habilitar();
                break;
            case "Flecha":
                inventario.aumentarFlechas(1);
                break;
            case "Pergaminho de Fogo":
                listaMagias.get(0).habilitar();
                break;
            case "Pergaminho de Agua":
                listaMagias.get(1).habilitar();
                break;
            case "Pergaminho de Vento":
                listaMagias.get(2).habilitar();
                break;
            case "Pocao de Vida":
                inventario.aumentarPocoesHp(1);
                break;
            case "Pocao de Mana":
                inventario.aumentarPocoesMp(1);
                break;
            case "Pocao de Forca":
                inventario.aumentarPocoesForca(1);
                break;
        }
    }

    /* Construtor */
    public Protagonista(int hpMax, int def, int atq, int mpMax) {
        super("Protagonista", hpMax, def, atq);
        this.mp = this.mpMax = mpMax;
        inventario = new Inventario();
        listaMagias = new ArrayList<Magia>();
        listaMagias.add(new Magia("Magia de Fogo", "Voce queima o/a %s, causando %d de dano!", "fogo", 20));
        listaMagias.add(new Magia("Magia de Agua", "Voce cria uma bolha ao redor do/da %s, causando %d de dano!", "agua", 20));
        listaMagias.add(new Magia("Magia de Vento", "Voce lança uma rajada de vento no/na %s, causando %d de dano!", "vento", 20));
    }

    /* toString() */
    @Override
    public String toString() {
        String str = super.toString().replaceFirst("Personagem", "Protagonista") +
            "\n\tmp: " + mp + "\n\tmpMax: " + mpMax + "\n\tlistaMagias:";
        for (Magia m: listaMagias)
            str += " " + m.getNome();
        return str;
    }

    /*
     * Aumenta a mana do protagonista
     * PARAMETROS:
     * mana -- quantidade a ser aumentada
     */
    public void regenerarMana(int mana) {
        mp += mana;
    }

    /* Volta atq, def e multiplicadores ao normal (deve ser chamado ao final de uma luta) */
    @Override
    public void resetarStatus() {
        super.resetarStatus();
        for (Magia m: listaMagias)
            m.setMultiplicador(0.);
    }

    /* Getters e setters */
    public List<Magia> getListaMagias() {
        return listaMagias;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getMp() {
        return mp;
    }

    public void setMpMax(int mpMax) {
        this.mpMax = mpMax;
    }

    public int getMpMax() {
        return mpMax;
    }

}
