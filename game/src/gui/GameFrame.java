package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;

import javax.swing.ImageIcon;

// gerado com Window Builder
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
		setTitle("Torre dos pesadelos: o legado de sarah");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
    	setBounds(0, 0, 1280, 720);
    	setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        cardPanel = new JPanel();
        cardPanel.setLayout(cardLayout);

        getContentPane().setLayout(new CardLayout(0, 0));
        getContentPane().add(cardPanel);
        
        setIconImage(new ImageIcon("game/assets/outros/icon.png").getImage());
    }
    
    public JPanel getCardPanel() {
    	return cardPanel;
    }
    
    public CardLayout getCardLayout() {
    	return cardLayout;
    }
}
