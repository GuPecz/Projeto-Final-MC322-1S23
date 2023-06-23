package gui;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;

public class GameFrame extends JFrame {

	private JPanel cardPanel;
	private CardLayout cardLayout;
	
	/**
	 * Launch the application.
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameFrame window = new GameFrame();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		setTitle("TODO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
    	setLocationRelativeTo(null);
    	setBounds(0, 0, 1280, 720);

        cardLayout = new CardLayout();
        cardPanel = new JPanel();
        cardPanel.setLayout(cardLayout);

        MenuInicialPanel menuInicialPanel = new MenuInicialPanel();
        cardPanel.add(menuInicialPanel, "screen1");

        getContentPane().setLayout(new CardLayout(0, 0));
        getContentPane().add(cardPanel);

        cardLayout.show(cardPanel, "screen1");
    	
    	
    }
}
