package engine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.FloatControl;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import combate.AcaoIndisponivelException;
import entidades.Inimigo;
import gui.MenuInicialPanel;
import gui.PedirNomePanel;

public class GameController {
    // atributos
    private GameModel model;
    private GameView view;
    private Thread threadMusica;
    private Clip clipMusica;
   
    // construtor
    public GameController() {
        model = new GameModel();
        view = new GameView();
        addListenersPaineis();
        view.showFrame();
        criarThreadMusica();
    }

    // adiciona listeners a todos os panels do GameView
    private void addListenersPaineis() {
        addListenersMenuInicial();
        addListenersMenuNome();
        addListenersConfigPanel();
        addListenersSala();
        addListenersMenuLore();
        addListenersMenuFinal();
    }

    // listener que retorna ao menu inicial
    private class ListenerVoltarMenuInicial implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev) {
            view.mostrarPanel("menuInicial");
        }
    }

    // listener que fecha o jogo
    private class ListenerFechar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev) {
            fecharJogo();
        }
    }

    // toca a musica
    private void tocarMusica() {
        try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(
                new File("game/assets/outro/background_music.wav"
            ));
			clipMusica = AudioSystem.getClip();
			clipMusica.open(audioStream);
			clipMusica.loop(Clip.LOOP_CONTINUOUSLY);
			clipMusica.start();
        } catch (Exception e) {
			e.printStackTrace();
		}
    }

    // cria a thread de musica e toca a musica
    private void criarThreadMusica() {
        threadMusica = new Thread(() -> {
            try {
                tocarMusica();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        threadMusica.start();
    }

    // fecha o jogo e a thread de musica
    private void fecharJogo() {
        // fecha a thread de musica
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            threadMusica.interrupt();
        }));
        System.exit(0);
    }
    
    // adiciona listeners aos botoes do menu de insercao de nome
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

    // adiciona listeners aos botoes do menu inicial
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
        menuInicialPanel.getBotaoSair().addActionListener(new ListenerFechar());
    }

    // muda o volume da musica baseado no valor
    private void mudarVolume(int valor) {
        float volume = (float) valor / 100.0f;
        if (clipMusica != null) {
            FloatControl gainControl = (FloatControl) clipMusica.getControl(FloatControl.Type.MASTER_GAIN);
            float dB = (float) (Math.log(volume) / Math.log(10.0) * 20.0);
            gainControl.setValue(dB);
        }
    }

    // adiciona listeners aos botoes e ao slider do panel de configuracoes
    private void addListenersConfigPanel() {
        JSlider sliderVolume = view.getConfigPanel().getSliderVolume();
        sliderVolume.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                mudarVolume(sliderVolume.getValue());
            }
        });
        view.getConfigPanel().getBotaoVoltar().addActionListener(new ListenerVoltarMenuInicial());
    }
    
    // adiciona um listener aos botoes do panel da sala
    private void addListenersSala() {
        ActionListener listenerBotoes = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                botaoSalaPressionado(((JButton) e.getSource()).getText());
            }
        };
        for (JButton botao: view.getSalaPanel().getListaBotoes())
            botao.addActionListener(listenerBotoes);
    }

    // adiciona listeners ao menu da historia
    private void addListenersMenuLore() {
        view.getLorePanel().getBotaoContinuar().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                gerarSala();
                view.mostrarPanel("sala");
            }
        });
    }

    // adiciona listeners ao menu final
    private void addListenersMenuFinal() {
        view.getTelaFinalPanelGameOver().getbotaoSair().addActionListener(new ListenerFechar());
        view.getTelaFinalPanel().getBotaoSair().addActionListener(new ListenerFechar());
    }

    // mostra o conteudo da sala
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

    // player foge do combate
    private void fugir() {
        view.mostrarDirecoesPossiveis(model.getDirecoesPossiveis());
        view.removerInimigo();
        view.resetarImagem();
    }

    // mostra o item na sala atual
    private void mostrarItem() {
        String item = model.getSalaAtual().getItem();
        view.mostrarItem(item);
    }

    // casos para quando os botoes do panel da sala sao pressionados
    private void botaoSalaPressionado(String botaoPressionado) {
        switch (botaoPressionado) {
            case "Ataque":
            case "Magia":
            case "Pocao":
            case "Voltar":
                view.mudarDisplayBotoesSala(botaoPressionado);
                break;
            case "Pegar":
                pegarItem();
                break;
            case "Descartar":
                descartarItem();
                break;
            case "Frente":
            case "Tras":
            case "Cima":
            case "Baixo":
                movimentarProtagonista(botaoPressionado);
                break;
            case "Fugir":
                fugir();
                break;
            default:
                executarAcao(botaoPressionado); // ataques/pocoes
                break;
        }
    }

    // playere pega o item
    private void pegarItem() {
        model.pegarItem();
        view.mostrarDirecoesPossiveis(model.getDirecoesPossiveis());
        view.resetarImagem();
    }

    // player descarta o item
    private void descartarItem() {
        model.descartarItem();
        view.mostrarDirecoesPossiveis(model.getDirecoesPossiveis());
        view.resetarImagem();
    }

    // mostra o inimigo da sala atual
    private void mostrarInimigo() {
        Inimigo inimigo = model.getSalaAtual().getInimigo();
        view.mostrarInimigo(inimigo.getNome(), inimigo.getElemento(), 
                            inimigo.getHp(), inimigo.getHpMax());
    }

    // movimenta o protagonista na direcao
    private void movimentarProtagonista(String direcao) {
        model.movimentacao(direcao);
        view.habilitarBotoesSala();
        gerarSala();
    }

    // remove o inimigo da sala e encerra o jogo se for o Anciao (boss final)
    private void inimigoDerrotado() {
        String nomeInimigo = model.getSalaAtual().getInimigo().getNome();
        view.mostrarInimigoDerrotado(nomeInimigo,
                                     model.inimigoMorreu());
        if (nomeInimigo.equals("Anciao")) {
            view.mostrarPanel("telaFinal");
            Score.escreverScore();
        }
    }

    // executa a acao de combate
    private void executarAcao(String acao) {
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
            view.atualizarTextoSala(e.getMessage());
        }
    }

}