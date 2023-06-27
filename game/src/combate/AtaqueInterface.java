package combate;

import entidades.Personagem;

public interface AtaqueInterface {
    String executar(Personagem usuario, Personagem oponente);
    boolean podeExecutar(Personagem usuario);
    double calcularMultiplicadorAleatorio();
}
