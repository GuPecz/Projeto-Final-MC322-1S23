package engine;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import entidades.Protagonista;
import gui.GameRodandoPanel;
import gui.GameView;
import gui.LorePanel;
import gui.MenuInicialPanel;
import gui.PedirNomePanel;
import gui.TelaFinalPanel;

public class GameController {
    //private GameModel model;
    private GameView view;
    private MenuInicialPanel menuInicialPanel;
    private LorePanel lorePanel;
    private PedirNomePanel pedirNomePanel;
    private GameRodandoPanel gameRodandoPanel;
    private TelaFinalPanel telaFinalPanel;
    private Protagonista protagonista;
   
    public GameController(GameView view) {
        this.view = view;
        inicializarProtagonista();
        inicializarPaineis();
    }
    
    private void inicializarProtagonista() {
        protagonista = new Protagonista(0, 0, 0, 0);
    }

    private void inicializarPaineis() {
        menuInicialPanel = new MenuInicialPanel();
        view.addPainelPrincipal(menuInicialPanel, "menuinicial");
        addListenersMenuInicial();

        pedirNomePanel = new PedirNomePanel();
        view.addPainelPrincipal(pedirNomePanel, "pedirnome");
        addListenersMenuNome();

        lorePanel = new LorePanel();
        view.addPainelPrincipal(lorePanel, "lorepanel");
        
        gameRodandoPanel = new GameRodandoPanel();
        view.addPainelPrincipal(gameRodandoPanel, "gamerodando");
        
        telaFinalPanel = new TelaFinalPanel();
        view.addPainelPrincipal(telaFinalPanel, "telafinal");
    }
    
    private void addListenersMenuNome() {
    	pedirNomePanel.getBotaoVoltar().addActionListener(new ActionListener ( ) {
            public void actionPerformed(ActionEvent ev) {
                view.showPanel("menuinicial");
            }
        });
    	pedirNomePanel.getBotaoConfirmar().addActionListener(new ActionListener ( ) {
            public void actionPerformed(ActionEvent ev) {
                System.out.println(protagonista.getNome());
                protagonista.setNome(pedirNomePanel.getTextFieldNome().getText());
                System.out.println(protagonista.getNome());
                view.showPanel("lore");
            }
        });
    }

    private void addListenersMenuInicial() {
        menuInicialPanel.getBotaoJogar().addActionListener(new ActionListener ( ) {
            public void actionPerformed(ActionEvent ev) {
                view.showPanel("pedirnome");
            }
        });
        /* TODO - painel de config*/
        menuInicialPanel.getBotaoConfig().addActionListener(new ActionListener ( ) {
            public void actionPerformed(ActionEvent ev) {
                view.showPanel(null);
            }
        });
        menuInicialPanel.getBotaoSair().addActionListener(new ActionListener ( ) {
            public void actionPerformed(ActionEvent ev) {
                System.exit(0);
            }
        });
    }
 
    public void comecarJogo() {
    	view.showFrame();
        view.showPanel("menuinicial");
    }
    
}