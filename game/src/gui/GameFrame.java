package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.ImageIcon;
import java.io.File;
import javax.sound.sampled.*;

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

        getContentPane().setLayout(new CardLayout(0, 0));
        getContentPane().add(cardPanel);
        musicThread.start();
        
        setIconImage(new ImageIcon("game/assets/outros/icon.png").getImage());
    	// cardLayout.show(cardPanel, "screen");
    }
    
    public JPanel getCardPanel() {
    	return cardPanel;
    }
    
    public CardLayout getCardLayout() {
    	return cardLayout;
    }

	private static void playMusic(File musicFile) {
		try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(musicFile);
			Clip clip = AudioSystem.getClip();
			clip.open(audioStream);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
			clip.start();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	Thread musicThread = new Thread(() -> {
		try {
			File backgroundMusic = new File("game/assets/outro/background_music.wav");
			playMusic(backgroundMusic);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	});
}
