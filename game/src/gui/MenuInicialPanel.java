package gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.Box;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
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

        JButton botaoJogar = new JButton("Jogar");
        botaoJogar.setFont(new Font("Tahoma", Font.PLAIN, 33));
        botaoJogar.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoJogar.setMaximumSize(new Dimension(buttonWidth, Integer.MAX_VALUE));
        add(Box.createVerticalStrut(20));
        add(botaoJogar);

        JButton botaoConfig = new JButton("Configurações");
        botaoConfig.setFont(new Font("Tahoma", Font.PLAIN, 33));
        botaoConfig.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoConfig.setMaximumSize(new Dimension(buttonWidth, Integer.MAX_VALUE));
        add(Box.createVerticalStrut(20));
        add(botaoConfig);

        JButton botaoSair = new JButton("Sair");
        botaoSair.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoSair.setMaximumSize(new Dimension(buttonWidth, Integer.MAX_VALUE));
        botaoSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Close the game
            }
        });
        botaoSair.setFont(new Font("Tahoma", Font.PLAIN, 33));
        add(Box.createVerticalStrut(20));
        add(botaoSair);

        add(Box.createVerticalGlue());
    }
}
