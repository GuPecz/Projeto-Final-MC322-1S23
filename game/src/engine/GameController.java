package engine;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import gui.MenuInicialPanel;
import gui.PedirNomePanel;
import gui.SalaPanel;

public class GameController {
    private GameModel model;
    private GameView view;
   
    public GameController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
        addListenersPaineis();
    }

    private void addListenersPaineis() {
        addListenersMenuInicial();
        addListenersMenuNome();
        addListenersSala();
        addListenersMenuLore();
        addListenersMenuFinal();
    }

    private class ListenerVoltarMenuInicial implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev) {
            view.showPanel("menuInicial");
        }
    }
    
    private void addListenersMenuNome() {
        PedirNomePanel pedirNomePanel = view.getPedirNomePanel();
    	pedirNomePanel.getBotaoVoltar().addActionListener(new ListenerVoltarMenuInicial());
    	pedirNomePanel.getBotaoConfirmar().addActionListener(new ActionListener () {
            public void actionPerformed(ActionEvent ev) {
                // pega o label com o texto da lore
                JLabel labelLore = view.getLorePanel().getLabelLore();
                // pega o nome do protagonista
                String nome = pedirNomePanel.getTextFieldNome().getText();
                // seta o nome. se n tiver nome, seta pra "Heroi"
                model.getProtagonista().setNome(nome.equals("") ? "Herói": nome);
                // substitui o %s pelo nome do protagonista
                labelLore.setText(String.format(labelLore.getText(), model.getProtagonista().getNome()));
                view.showPanel("lore");
            }
        });
    }

    private void addListenersMenuInicial() {
        MenuInicialPanel menuInicialPanel = view.getMenuInicialPanel();
        menuInicialPanel.getBotaoJogar().addActionListener(new ActionListener () {
            public void actionPerformed(ActionEvent ev) {
                view.showPanel("pedirNome");
            }
        });
        /* TODO - painel de config*/
        menuInicialPanel.getBotaoConfig().addActionListener(new ActionListener () {
            public void actionPerformed(ActionEvent ev) {
                view.showPanel(null);
            }
        });
        menuInicialPanel.getBotaoSair().addActionListener(new ActionListener () {
            public void actionPerformed(ActionEvent ev) {
                System.exit(0);
            }
        });
    }
    
    private void addListenersSala() {
        SalaPanel salaPanel = view.getSalaPanel();
        JButton[] botoes = {salaPanel.getBotao1(), salaPanel.getBotao2(), salaPanel.getBotao3(), salaPanel.getBotao4()};
        ListenerBotaoSala listenerBotoes = new ListenerBotaoSala(this, botoes);
        for (JButton botao: botoes)
            botao.addActionListener(listenerBotoes);
    }

    // TODO: Implementar método
    private void addListenersMenuLore() {
        view.getLorePanel().getBotaoContinuar().addActionListener(new ActionListener () {
            public void actionPerformed(ActionEvent ev) {
                view.showPanel("sala");
            }
        });
    }
 
    // TODO: Implementar método
    private void addListenersMenuFinal() {
        view.getTelaFinalPanelGameOver().getBotaoVoltarMenu().addActionListener(new ListenerVoltarMenuInicial());
    }

    public void comecarJogo() {
    	view.showFrame();
        view.showPanel("telaInicial");
    }

}