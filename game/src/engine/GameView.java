package engine;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import dados.LeituraImagem;
import gui.*;

public class GameView {
	// atributos (panels e frames)
	private GameFrame gameFrame;
	private MenuInicialPanel menuInicialPanel;
	private ConfigPanel configPanel;
	private LorePanel lorePanel;
	private PedirNomePanel pedirNomePanel;
	private SalaPanel salaPanel;
	private SelecaoSalaPanel selecaoSalaPanel;
	private TelaFinalPanel telaFinalPanel;
	private TelaFinalPanelGameOver telaFinalPanelGameOver;

	// construtor
	public GameView() {
		gameFrame = new GameFrame();
		menuInicialPanel = new MenuInicialPanel();
		addPainelPrincipal(menuInicialPanel, "menuInicial");
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

	// mostra a imagem do item (SalaPanel)
	public void mostrarItem(String item) {
        if (item != null) {
            salaPanel.getLabelTexto().setText("Voce encontrou um(a) " + item + "! Deseja pegar?");
			JLabel imagemItem = salaPanel.getLabelImagem();
			imagemItem.setIcon(LeituraImagem.imagemItem(item));
			imagemItem.setVisible(true);
            salaPanel.getBotao1().setVisible(false);
            salaPanel.getBotao2().setVisible(false);
            salaPanel.getBotao3().setText("Pegar");
            salaPanel.getBotao4().setText("Descartar");

        }
	}

	// mostra as mensagens de uso das acoes do player e do inimigo (SalaPanel)
	public void displayMensagemUso(String msgPlayer, String msgInimigo) {
		int indiceQuebra;
		if (msgInimigo.length() > 50) {
			// formatacao p/ quebrar linha no primeiro espaco entre indice 50 e msgInimigo.length()
			indiceQuebra = msgInimigo.substring(51, msgInimigo.length()).indexOf(" ") + 51;
			msgInimigo = msgInimigo.substring(0, indiceQuebra).concat("<br>").concat(msgInimigo.substring(indiceQuebra).replaceFirst(" ", ""));
		}
		salaPanel.getLabelTexto().setText("<html>" + (msgPlayer + "<br>" +
										  msgInimigo).replaceAll(" ", "&nbsp;") + "</html>");
	}

	// seta os botoes para mostrar as direcoes disponiveis para andar (SalaPanel)
	public void mostrarDirecoesPossiveis(boolean[] direcoesDisponiveis) {
		JButton[] botoes = {salaPanel.getBotao1(), salaPanel.getBotao2(), salaPanel.getBotao3(), salaPanel.getBotao4()};
        String[] direcoes = {"Frente", "Tras", "Cima", "Baixo"};
		JLabel labelTexto = salaPanel.getLabelTexto();
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

	// mostra os comandos de batalha (SalaPanel)
	private void mostrarBotoesBatalha() {
		salaPanel.getBotao1().setText("Ataque");
		salaPanel.getBotao2().setText("Magia");
		salaPanel.getBotao3().setText("Pocao");
		salaPanel.getBotao4().setText("Fugir");
	}

	// deixa a primeira letra da string maiuscula
	private void capitalizar(String s) {
		Character.toUpperCase(s.charAt(0));
	}

	// coloca o texto no labelTexto (SalaPanel)
	public void atualizarTextoSala(String texto) {
		salaPanel.getLabelTexto().setText(texto);
	}

	// mostra informacoes do inimigo (SalaPanel)
	public void mostrarInimigo(String nome, String elemento, int hpInimigo, int hpMaxInimigo) {
		capitalizar(elemento);
		JLabel labelHpInimigo = salaPanel.getLabelHpInimigo();
    	JProgressBar barraHpInimigo = salaPanel.getBarraHpInimigo();
		JLabel imagemInimigo = salaPanel.getLabelImagem();
    	salaPanel.getLabelTexto().setText("Oh nao, eh o/a " + nome + " do Reino de " + elemento + "!!");
		imagemInimigo.setIcon(LeituraImagem.imagemInimigo(nome));
    	labelHpInimigo.setText(nome + " do Reino de " + elemento);
		imagemInimigo.setVisible(true);
    	labelHpInimigo.setVisible(true);
    	barraHpInimigo.setVisible(true);
		atualizarBarraInimigo(hpInimigo, hpMaxInimigo);
		mostrarBotoesBatalha();
	}

	// mostra andar e sala onde o player esta (SalaPanel)
	public void atualizarDisplaySala(int andar, int sala) {
		salaPanel.getLabelPosicao().setText(String.format("Andar %d, Sala %d", andar, sala));
	}

	// remove o inimigo (SalaPanel)
	public void removerInimigo() {
        salaPanel.getLabelHpInimigo().setVisible(false);
        salaPanel.getBarraHpInimigo().setVisible(false);
	}

	// mostra o loot do inimigo e mensagem de inimigo derrotado (SalaPanel)
	public void mostrarInimigoDerrotado(String nome, String item) {
		mostrarItem(item);
		salaPanel.getLabelTexto().setText(nome + " derrotado!" + " Ele estava carregando um/a " + 
										  item + ". Deseja pegar?");
        removerInimigo();
	}

	// atualiza a barra de vida do inimigo (SalaPanel)
	private void atualizarBarraInimigo(int vidaInimigo, int vidaMaxInimigo) {
		int porcentagem = Math.max(1, (int) (((double) vidaInimigo) / vidaMaxInimigo * 100));
		salaPanel.getBarraHpInimigo().setValue(porcentagem);
	}
	
	// atualiza as barras de vida e mana do player (SalaPanel)
	private void atualizarBarrasProtagonista(int vidaProtag, int vidaMaxProtag,
											 int manaProtag, int manaMaxProtag) {
		salaPanel.getBarraHp().setValue((int) (((double) vidaProtag) / vidaMaxProtag * 100));
		salaPanel.getBarraMp().setValue((int) (((double) manaProtag) / manaMaxProtag * 100));
	}

	// atualiza barras do player e inimigo
	public void atualizarBarras(int vidaProtag, int vidaMaxProtag, int vidaInimigo, int vidaMaxInimigo,
								int manaProtag, int manaMaxProtag) {
		atualizarBarrasProtagonista(vidaProtag, vidaMaxProtag, manaProtag, manaMaxProtag);
		atualizarBarraInimigo(vidaInimigo, vidaMaxInimigo);
	}

	// mostra as direcoes possiveis e mensagem de sala vazia (SalaPanel)
	public void mostrarSalaVazia(boolean[] direcoesDisponiveis) {
		mostrarDirecoesPossiveis(direcoesDisponiveis);
		salaPanel.getLabelTexto().setText("Essa sala esta vazia." + salaPanel.getLabelTexto().getText());
	}

	// remove a imagem no labelImagem (SalaPanel)
	public void resetarImagem() {
		salaPanel.getLabelImagem().setVisible(false);
	}

	// muda o conteudo dos botoes dependendo do parametro (SalaPanel)
	public void mudarDisplayBotoesSala(String display) {
		String novoTexto[] = null;
		JButton[] botoes = salaPanel.getListaBotoes();
		switch (display) {
			case "Ataque":
				novoTexto = new String[] {"Soco", "Espada", "Arco", "Voltar"};
				break;
			case "Magia":
				novoTexto = new String[] {"Magia de Fogo", "Magia de Agua", "Magia de Vento", "Voltar"};
				break;
			case "Pocao":
				novoTexto = new String[] {"Pocao de Vida", "Pocao de Mana", "Pocao de Forca", "Voltar"};
				break;
			case "Voltar":
				novoTexto = new String[] {"Ataque", "Magia", "Pocao", "Fugir"};
				break;
		}
		for (int i = 0; i < botoes.length; i++)
			botoes[i].setText(novoTexto[i]);
	}

	// habilita todos os botoes (SalaPanel)
	public void habilitarBotoesSala() {
		JButton[] botoes = {salaPanel.getBotao1(), salaPanel.getBotao2(), salaPanel.getBotao3(), salaPanel.getBotao4()};
		for (JButton botao: botoes)
			botao.setEnabled(true);
	}
	
	// inicializa o frame e mostra a tela inicial
	public void showFrame() {
		mostrarPanel("telaInicial");
        gameFrame.setVisible(true);
	}
	
	// adiciona o painel e seta seu nome no cardPanel do gameFrame
	public void addPainelPrincipal(JPanel painel, String nome) {
		gameFrame.getCardPanel().add(painel, nome);
	}
	
	// mostra o panel com o nome especificado
	public void mostrarPanel(String nome) {
		gameFrame.getCardLayout().show(gameFrame.getCardPanel(), nome);
	}
	
	// getters
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
