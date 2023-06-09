package gui;

import java.awt.Component;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

// gerado com Window Builder
public class TelaFinalPanelGameOver extends JPanel {
	private static final long serialVersionUID = 301608804770619286L;

	private JButton botaoSair;
	
	public TelaFinalPanelGameOver() {
		super();
		botaoSair = new JButton("Sair");
		inicializar();
	}
	
	private void inicializar() {
		int buttonWidth = 500;
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JLabel lblNewLabel = new JLabel("GAME OVER");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 49));
        lblNewLabel.setMaximumSize(new Dimension(buttonWidth, Integer.MAX_VALUE));
        add(lblNewLabel);
        
        JPanel panel = new JPanel();
        add(panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        panel.add(botaoSair);
        botaoSair.setFont(new Font("Tahoma", Font.PLAIN, 33));
        botaoSair.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoSair.setMaximumSize(new Dimension(250, 50));
        Component verticalStrut_1 = Box.createVerticalStrut(200);
        panel.add(verticalStrut_1);
	
	}

	public JButton getbotaoSair() {
		return botaoSair;
	}
}
