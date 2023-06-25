package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;

public class GameFrame extends JFrame {
	private static final long serialVersionUID = 303308866722346454L;
	private JPanel cardPanel;
	private CardLayout cardLayout;

	/**
	 * Create the frame.
	 * @wbp.parser.entryPoint
	 */
	public GameFrame() {
		super();
		initialize();
	}

    /**
     * @wbp.parser.entryPoint
     */
    private void initialize() {
		setTitle("TODO - titulo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
    	setBounds(0, 0, 1280, 720);
    	setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        cardPanel = new JPanel();
        cardPanel.setLayout(cardLayout);

        MenuInicialPanel menuInicialPanel = new MenuInicialPanel();
        cardPanel.add(menuInicialPanel, "menuinicial");
        
        LorePanel lorePanel = new LorePanel();
        cardPanel.add(lorePanel, "lore");
        
        PedirNomePanel pedirNomePanel = new PedirNomePanel();
        cardPanel.add(pedirNomePanel, "pedirnome");
        
        GameRodandoPanel gameRodandoPanel = new GameRodandoPanel();
        cardPanel.add(gameRodandoPanel, "gamerodando");
        
        SelecaoSalaPanel selecaoSalaPanel = new SelecaoSalaPanel();
        cardPanel.add(selecaoSalaPanel, "selecaosalapanel");

        // TODO: Considerar tratar esses submenus da gameplay como painel secundário ou algo do tipo
        CombatePanel combatePanel = new CombatePanel();
        cardPanel.add(combatePanel, "combatePanel");

        TelaFinalPanel telaFinalPanel = new TelaFinalPanel();
        cardPanel.add(telaFinalPanel, "telafinal");

        getContentPane().setLayout(new CardLayout(0, 0));
        getContentPane().add(cardPanel);

        cardLayout.show(cardPanel, "menuinicial");
        
    	// cardLayout.show(cardPanel, "screen");
    }
    
    public JPanel getCardPanel() {
    	return cardPanel;
    }
    
    public CardLayout getCardLayout() {
    	return cardLayout;
    }

}
