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
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

public class MenuInicial {

	private JFrame frmJogo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuInicial window = new MenuInicial();
					window.frmJogo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuInicial() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
    private void initialize() {
        int buttonWidth = 500, buttonHeight = 100;
        int clientWidth = 1280, clientHeight = 720;
        frmJogo = new JFrame();
        frmJogo.getContentPane().setForeground(new Color(204, 255, 255));
        frmJogo.setTitle("TODO - titulo do jogo");
        frmJogo.setResizable(false);
        frmJogo.setBounds(0, 0, clientWidth, clientHeight);
        frmJogo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmJogo.getContentPane().setLayout(null);

        JPanel botoesPanel = new JPanel();
        botoesPanel.setBounds(324, 176, 615, 476);
        frmJogo.getContentPane().add(botoesPanel);
        botoesPanel.setLayout(new BoxLayout(botoesPanel, BoxLayout.Y_AXIS));

        JButton botaoJogar = new JButton("Jogar");
        botaoJogar.setFont(new Font("Tahoma", Font.PLAIN, 33));
        botaoJogar.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoJogar.setMaximumSize(new Dimension(buttonWidth, Integer.MAX_VALUE)); // Set maximum width and height for all buttons
        botoesPanel.add(Box.createVerticalStrut(20)); // Add vertical spacing
        botoesPanel.add(botaoJogar);
        botaoJogar.setToolTipText("");

        JButton botaoConfig = new JButton("Configurações");
        botaoConfig.setFont(new Font("Tahoma", Font.PLAIN, 33));
        botaoConfig.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoConfig.setMaximumSize(new Dimension(buttonWidth, Integer.MAX_VALUE)); // Set maximum width and height for all buttons
        botoesPanel.add(Box.createVerticalStrut(20)); // Add vertical spacing
        botoesPanel.add(botaoConfig);

        JButton botaoSair = new JButton("Sair");
        botaoSair.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoSair.setMaximumSize(new Dimension(buttonWidth, Integer.MAX_VALUE)); // Set maximum width and height for all buttons
        botaoSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Close the game
            }
        });
        botaoSair.setFont(new Font("Tahoma", Font.PLAIN, 33));
        botoesPanel.add(Box.createVerticalStrut(20)); // Add vertical spacing
        botoesPanel.add(botaoSair);

        botoesPanel.add(Box.createVerticalGlue()); // Add vertical glue at the bottom to push buttons to the top
        
        JPanel panel = new JPanel();
        panel.setBounds(324, 11, 615, 164);
        frmJogo.getContentPane().add(panel);
        panel.setLayout(new BorderLayout(0, 0));
        
        JLabel lblNewLabel = new JLabel("TITULO DO JOGO");
        lblNewLabel.setFont(new Font("Monotype Corsiva", Font.BOLD, 49));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblNewLabel, BorderLayout.CENTER);

        frmJogo.setLocationRelativeTo(null); // Set frame location to center of the screen
        frmJogo.setVisible(true);
    }
}
