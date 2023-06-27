package engine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import combate.AcaoIndisponivelException;
import entidades.Inimigo;
import gui.MenuInicialPanel;
import gui.PedirNomePanel;
import gui.SalaPanel;

public class GameController {
    private GameModel model;
    private GameView view;
   
    public GameController() {
        model = new GameModel();
        view = new GameView();
        addListenersPaineis();
        view.showFrame();
    }

    private void addListenersPaineis() {
        addListenersMenuInicial();
        addListenersMenuNome();
        addListenersSala();
        addListenersMenuLore();
        addListenersMenuFinal();
        view.getConfigPanel().getBotaoTriste().addActionListener(new ListenerVoltarMenuInicial());
    }

    private class ListenerVoltarMenuInicial implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev) {
            view.mostrarPanel("menuInicial");
        }
    }
    
    private void addListenersMenuNome() {
        PedirNomePanel pedirNomePanel = view.getPedirNomePanel();
        pedirNomePanel.getBotaoVoltar().addActionListener(new ListenerVoltarMenuInicial());
        pedirNomePanel.getBotaoConfirmar().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                // pega o label com o texto da lore
                JLabel labelLore = view.getLorePanel().getLabelLore();
                // pega o nome do protagonista
                String nome = pedirNomePanel.getTextFieldNome().getText();
                // seta o nome. se n tiver nome, seta pra "Heroi"
                model.getProtagonista().setNome(nome.equals("") ? "Herói": nome);
                // substitui o %s pelo nome do protagonista
                labelLore.setText(String.format(labelLore.getText(), model.getProtagonista().getNome()));
                view.mostrarPanel("lore");
            }
        });
    }

    private void addListenersMenuInicial() {
        MenuInicialPanel menuInicialPanel = view.getMenuInicialPanel();
        menuInicialPanel.getBotaoJogar().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                view.mostrarPanel("pedirNome");
            }
        });
        menuInicialPanel.getBotaoConfig().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                view.mostrarPanel("config");
            }
        });
        menuInicialPanel.getBotaoSair().addActionListener(new ActionListener() {
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

    private void addListenersMenuLore() {
        view.getLorePanel().getBotaoContinuar().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                gerarSala();
                view.mostrarPanel("sala");
            }
        });
    }

    private void addListenersMenuFinal() {
        view.getTelaFinalPanelGameOver().getbotaoSair().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                System.exit(0);
            }
        });
        view.getTelaFinalPanel().getBotaoSair().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                System.exit(0);
            }
        });
    }

    private void gerarSala() {
        int[] pos = model.getPosicaoProtagonista();
        view.atualizarDisplaySala(pos[0], pos[1]);
        if (model.getSalaAtual().getInimigo() != null)
            mostrarInimigo();
        else if (model.getSalaAtual().getItem() != null)
            mostrarItem();
        else
            view.mostrarSalaVazia(model.getDirecoesPossiveis());
    }

    public void fugir() {
        view.mostrarDirecoesPossiveis(model.getDirecoesPossiveis());
        view.removerInimigo();
        view.resetarImagem();
    }

    private void mostrarItem() {
        String item = model.getSalaAtual().getItem();
        view.mostrarItem(item);
    }

    public void pegarItem() {
        model.pegarItem();
        view.mostrarDirecoesPossiveis(model.getDirecoesPossiveis());
        view.resetarImagem();
    }

    public void descartarItem() {
        model.descartarItem();
        view.mostrarDirecoesPossiveis(model.getDirecoesPossiveis());
        view.resetarImagem();
    }

    private void mostrarInimigo() {
        Inimigo inimigo = model.getSalaAtual().getInimigo();
        view.mostrarInimigo(inimigo.getNome(), inimigo.getElemento(), 
                            inimigo.getHp(), inimigo.getHpMax());
    }

    public void movimentarProtagonista(String direcao) {
        model.movimentacao(direcao);
        view.habilitarBotoesSala();
        gerarSala();
    }

    private void inimigoDerrotado() {
        String nomeInimigo = model.getSalaAtual().getInimigo().getNome();
        view.mostrarInimigoDerrotado(nomeInimigo,
                                     model.inimigoMorreu());
        if (nomeInimigo.equals("Anciao")) {
            view.mostrarPanel("telaFinal");
            Score.escreverScore();
        }
    }

    public void executarAcao(String acao) {
        int[] valoresBarra;
        String msgUsoProtag, msgUsoInimigo;
        try {
            msgUsoProtag = model.executarAcaoProtagonista(acao);
            valoresBarra = model.getVidaMana();
            view.atualizarBarras(valoresBarra[0], valoresBarra[1], valoresBarra[2],
                                 valoresBarra[3], valoresBarra[4], valoresBarra[5]);
            if (! model.getSalaAtual().getInimigo().vivo()) {
                inimigoDerrotado();
                return;
            }
            msgUsoInimigo = model.executarAcaoInimigo();
            if (! model.getProtagonista().vivo()) {
                view.mostrarPanel("gameOver");
                return;
            }
            valoresBarra = model.getVidaMana();
            view.atualizarBarras(valoresBarra[0], valoresBarra[1], valoresBarra[2],
                                 valoresBarra[3], valoresBarra[4], valoresBarra[5]);
            view.displayMensagemUso(msgUsoProtag, msgUsoInimigo);
        } catch (AcaoIndisponivelException e) {
            view.getSalaPanel().getLabelTexto().setText(e.getMessage());
        }
    }

}