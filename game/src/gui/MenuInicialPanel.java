package gui;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

public class MenuInicialPanel extends JPanel {

	/**
	 * Create the application.
	 */
	public MenuInicialPanel() {
		super();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
    private void initialize() {
        int buttonWidth = 500;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel lblNewLabel = new JLabel("TITULO DO JOGO");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblNewLabel.setFont(new Font("Monotype Corsiva", Font.BOLD, 49));
        lblNewLabel.setMaximumSize(new Dimension(buttonWidth, Integer.MAX_VALUE));
        add(lblNewLabel);
        
        JPanel panel = new JPanel();
        add(panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        JButton botaoJogar = new JButton("Jogar");
        panel.add(botaoJogar);
        botaoJogar.setFont(new Font("Tahoma", Font.PLAIN, 33));
        botaoJogar.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoJogar.setMaximumSize(new Dimension(buttonWidth, Integer.MAX_VALUE));
        Component verticalStrut_1 = Box.createVerticalStrut(40);
        panel.add(verticalStrut_1);

        JButton botaoConfig = new JButton("Configurações");
        panel.add(botaoConfig);
        botaoConfig.setFont(new Font("Tahoma", Font.PLAIN, 33));
        botaoConfig.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoConfig.setMaximumSize(new Dimension(500, 2147483647));
        Component verticalStrut_2 = Box.createVerticalStrut(40);
        panel.add(verticalStrut_2);
    
        JButton botaoSair = new JButton("Sair");
        panel.add(botaoSair);
        botaoSair.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoSair.setMaximumSize(new Dimension(500, 2147483647));
        botaoSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Close the game
            }
        });
        botaoSair.setFont(new Font("Tahoma", Font.PLAIN, 33));
        
        Component verticalStrut_2_1 = Box.createVerticalStrut(100);
        panel.add(verticalStrut_2_1);

        add(Box.createVerticalGlue());
    }
}
