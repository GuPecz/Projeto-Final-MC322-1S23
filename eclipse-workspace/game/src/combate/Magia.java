package combate;

import dados.CsvHandler;
import entidades.Inimigo;
import entidades.Personagem;

public class Magia extends Ataque {
    /* Atributos */
    private int danoBase;
    private String elemento;
    private int custoMp;

    /* Construtor */
    public Magia(String nome, String msgUso, String elemento, int custoMp) {
        super(nome, false, msgUso, 0.); // inicia desabilitada (ate achar scroll)
        this.elemento = elemento;
        this.custoMp = custoMp;
    }

    /* 
     * Retorna quanto de dano a magia deve causar
     * PARAMETROS:
     * - alvo: personagem que receberá o dano
     */
    private int danoCausado(Personagem alvo) {
        // obtém o multiplicador de dano sobre o elemento do inimigo
        // TODO - multiplicador pode acabar sendo zero se elemento nao estiver no arquivo, tomar cuidado
        if (getMultiplicador() == 0.)
            setMultiplicador(CsvHandler.getMultiplicador(elemento, ((Inimigo)alvo).getElemento()));
        // calculo do dano causado: (dano * multiplicador) * (100 / (100 + def))
        int danoCausado = (int) ((danoBase * getMultiplicador()) * (100 / (100 + alvo.getDefAtual())));;
        return danoCausado;
    }

    /*
     * Executa a magia (causa dano ao inimigo)
     * PARAMETROS:
     * - usuario: personagem que usou a magia (Protagonista)
     * - recebedor: personagem que receberá o dano
     */
    @Override
    public int executar(Personagem usuario, Personagem oponente) throws AcaoIndisponivelException{
        if (! getHabilitado())
            throw new AcaoIndisponivelException("Você ainda não desbloqueou esse pergaminho!");
        int dano = danoCausado(oponente);
        oponente.reduzirVida(dano);
        return dano;
    }

    /* Getters e setters */
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
