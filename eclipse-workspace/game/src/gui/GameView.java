package gui;

import javax.swing.JPanel;

public class GameView {
	private GameFrame gameFrame;
	
	public GameView() {
		gameFrame = new GameFrame();
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
	
	public GameFrame getGameFrame() {
		return gameFrame;
	}
}
