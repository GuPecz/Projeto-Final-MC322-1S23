package engine;

import javax.swing.JPanel;

import gui.*;

public class GameView {
	private GameFrame gameFrame;
	private MenuInicialPanel menuInicialPanel;
	private CombatePanel combatePanel;
	private ConfigPanel configPanel;
	private LorePanel lorePanel;
	private PedirNomePanel pedirNomePanel;
	private SalaPanel salaPanel;
	private SelecaoSalaPanel selecaoSalaPanel;
	private TelaFinalPanel telaFinalPanel;
	private TelaFinalPanelGameOver telaFinalPanelGameOver;
	

	public GameView() {
		gameFrame = new GameFrame();
		menuInicialPanel = new MenuInicialPanel();
		addPainelPrincipal(menuInicialPanel, "menuInicial");
		combatePanel = new CombatePanel();
		addPainelPrincipal(combatePanel, "combate");
		configPanel = new ConfigPanel();
		addPainelPrincipal(configPanel, "config");
		lorePanel = new LorePanel();
		addPainelPrincipal(lorePanel, "lore");
		pedirNomePanel = new PedirNomePanel();
		addPainelPrincipal(pedirNomePanel, "pedirNome");
		salaPanel = new SalaPanel();
		addPainelPrincipal(salaPanel, "sala");
		selecaoSalaPanel = new SelecaoSalaPanel();
		addPainelPrincipal(selecaoSalaPanel, "selecaoSala");
		telaFinalPanel = new TelaFinalPanel();
		addPainelPrincipal(telaFinalPanel, "telaFinal");
		telaFinalPanelGameOver = new TelaFinalPanelGameOver();
		addPainelPrincipal(telaFinalPanelGameOver, "gameOver");
	}
	
	public void showFrame() {
        gameFrame.setVisible(true);
	}
	
	public void addPainelPrincipal(JPanel painel, String nome) {
		gameFrame.getCardPanel().add(painel, nome);
	}
	
	public void showPanel(String nome) {
		gameFrame.getCardLayout().show(gameFrame.getCardPanel(), nome);
	}
	
	// getters

	public CombatePanel getCombatePanel() {
		return combatePanel;
	}

	public ConfigPanel getConfigPanel() {
		return configPanel;
	}

	public LorePanel getLorePanel() {
		return lorePanel;
	}
	
	public PedirNomePanel getPedirNomePanel() {
		return pedirNomePanel;
	}

	public SalaPanel getSalaPanel() {
		return salaPanel;
	}

	public GameFrame getGameFrame() {
		return gameFrame;
	}

	public SelecaoSalaPanel getSelecaoSalaPanel() {
		return selecaoSalaPanel;
	}

	public TelaFinalPanel getTelaFinalPanel() {
		return telaFinalPanel;
	}

	public TelaFinalPanelGameOver getTelaFinalPanelGameOver() {
		return telaFinalPanelGameOver;
	}

	public MenuInicialPanel getMenuInicialPanel() {
		return menuInicialPanel;
	}
}
