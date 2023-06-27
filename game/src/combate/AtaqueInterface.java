package combate;

import entidades.Personagem;

public interface AtaqueInterface {
    /* Executa o ataque */
    public String executar(Personagem usuario, Personagem oponente);

    /* Retorna boolean indicando se ataque pode ser executado */
    public boolean podeExecutar(Personagem usuario);

    /* Calcula o multiplicador do ataque */
    public double calcularMultiplicador();
}
