package engine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ListenerBotaoSala implements ActionListener {
    GameController controller;
    JButton[] botoes;
    private String[] acoesBatalha = {"Ataque", "Magia", "Pocao", "Fugir"};
    private String[] ataques = {"Soco", "Espada", "Arco", "Voltar"};
    private String[] magias = {"Magia de Fogo", "Magia de Agua", "Magia de Vento", "Voltar"};
    private String[] pocoes = {"Pocao de Vida", "Pocao de Mana", "Pocao de Forca", "Voltar"};

    public ListenerBotaoSala(GameController controller, JButton[] botoes) {
        this.controller = controller;
        this.botoes = botoes;
    }

    public void actionPerformed(ActionEvent e) {
        String opcao = ((JButton) e.getSource()).getText();
        String[] novoTexto = {};
        switch (opcao) {
            case "Ataque":
                novoTexto = ataques;
                break;
            case "Magia":
                novoTexto = magias;
                break;
            case "Pocao":
                novoTexto = pocoes;
                break;
            case "Fugir":
                controller.fugir();
                break;
            case "Pegar":
                controller.pegarItem();
                break;
            case "Descartar":
                controller.descartarItem();
                break;
            case "Frente":
            case "Tras":
            case "Cima":
            case "Baixo":
                controller.movimentarProtagonista(opcao);
                break;
            case "Voltar":
                novoTexto = acoesBatalha;
                break;
            default:
                controller.executarAcao(opcao);
        }

        for (int i = 0; i < novoTexto.length; i++)
            botoes[i].setText(novoTexto[i]);
    }

}
