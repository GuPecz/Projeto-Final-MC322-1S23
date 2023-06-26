package engine;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

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

	public void mostrarItem(String item) {
        if (item != null) {
            salaPanel.getLabelTexto().setText("Voce encontrou um(a) " + item + "! Deseja pegar?");
            salaPanel.getBotao1().setVisible(false);
            salaPanel.getBotao2().setVisible(false);
            salaPanel.getBotao3().setText("Pegar");
            salaPanel.getBotao4().setText("Descartar");
        }
	}

	public void displayMensagemUso(String msgPlayer, String msgInimigo) {
		salaPanel.getLabelTexto().setText("<html>" + (msgPlayer + "<br>" +
										  msgInimigo).replaceAll(" ", "&nbsp;") + "</html>");
	}

	public void mostrarDirecoesPossiveis(boolean[] direcoesDisponiveis) {
		JButton[] botoes = {salaPanel.getBotao1(), salaPanel.getBotao2(), salaPanel.getBotao3(), salaPanel.getBotao4()};
        String[] direcoes = {"Frente", "Tras", "Cima", "Baixo"};
		JLabel labelTexto = salaPanel.getLabelTexto();
        // frente, tras, cima, baixo
        for (int i = 0; i  < direcoes.length; i++) {
            botoes[i].setVisible(true);
            botoes[i].setText(direcoes[i]);
            if (! direcoesDisponiveis[i])
                botoes[i].setEnabled(false);
        }
		labelTexto.setText("");
		if (direcoesDisponiveis[2])
			labelTexto.setText(" Voce ve uma escada para subir.");
		else if (direcoesDisponiveis[3])
		 	labelTexto.setText(" Voce ve uma escada para descer.");
		labelTexto.setText(labelTexto.getText() + " Para onde deseja ir?");
	}

	private void mostrarBotoesBatalha() {
		salaPanel.getBotao1().setText("Ataque");
		salaPanel.getBotao2().setText("Magia");
		salaPanel.getBotao3().setText("Pocao");
		salaPanel.getBotao4().setText("Fugir");
	}

	public void mostrarInimigo(String nome, String elemento, int hpInimigo, int hpMaxInimigo) {
		JLabel labelHpInimigo = salaPanel.getLabelHpInimigo();
    	JProgressBar barraHpInimigo = salaPanel.getBarraHpInimigo();
    	salaPanel.getLabelTexto().setText("Oh não, é o " + nome + " do Reino de " + elemento + "!!");
    	labelHpInimigo.setText(nome);
    	labelHpInimigo.setVisible(true);
    	barraHpInimigo.setVisible(true);
		atualizarBarraInimigo(hpInimigo, hpMaxInimigo);
		mostrarBotoesBatalha();
	}

	public void atualizarDisplaySala(int andar, int sala) {
		salaPanel.getLabelPosicao().setText(String.format("Andar %d, Sala %d", andar, sala));
	}

	public void removerInimigo() {
        salaPanel.getLabelHpInimigo().setVisible(false);
        salaPanel.getBarraHpInimigo().setVisible(false);
	}

	public void mostrarInimigoDerrotado(String nome, String item) {
		mostrarItem(item);
		salaPanel.getLabelTexto().setText(nome + " derrotado!" + " Ele estava carregando um/a " + 
										  item + ". Deseja pegar?");
        removerInimigo();
	}

	private void atualizarBarraInimigo(int vidaInimigo, int vidaMaxInimigo) {
		salaPanel.getBarraHpInimigo().setValue((int) (((double) vidaInimigo) / vidaMaxInimigo * 100));
	}

	private void atualizarBarrasProtagonista(int vidaProtag, int vidaMaxProtag,
											 int manaProtag, int manaMaxProtag) {
		salaPanel.getBarraHp().setValue((int) (((double) vidaProtag) / vidaMaxProtag * 100));
		salaPanel.getBarraMp().setValue((int) (((double) manaProtag) / manaMaxProtag * 100));
	}

	public void atualizarBarras(int vidaProtag, int vidaMaxProtag, int vidaInimigo, int vidaMaxInimigo,
								int manaProtag, int manaMaxProtag) {
		atualizarBarrasProtagonista(vidaProtag, vidaMaxProtag, manaProtag, manaMaxProtag);
		atualizarBarraInimigo(vidaInimigo, vidaMaxInimigo);
	}

	public void mostrarSalaVazia(boolean[] direcoesDisponiveis) {
		mostrarDirecoesPossiveis(direcoesDisponiveis);
		salaPanel.getLabelTexto().setText("Essa sala esta vazia." + salaPanel.getLabelTexto().getText());
	}

	public void habilitarBotoesSala() {
		JButton[] botoes = {salaPanel.getBotao1(), salaPanel.getBotao2(), salaPanel.getBotao3(), salaPanel.getBotao4()};
		for (JButton botao: botoes)
			botao.setEnabled(true);
	}
	
	public void showFrame() {
		mostrarPanel("telaInicial");
        gameFrame.setVisible(true);
	}
	
	public void addPainelPrincipal(JPanel painel, String nome) {
		gameFrame.getCardPanel().add(painel, nome);
	}
	
	public void mostrarPanel(String nome) {
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
