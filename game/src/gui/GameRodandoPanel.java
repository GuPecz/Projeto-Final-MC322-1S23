package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JProgressBar;

public class GameRodandoPanel extends JPanel {
	private static final long serialVersionUID = -5030442052142425577L;

    /**
     * Create the panel.
     */
    public GameRodandoPanel() {
        super();
        initialize();
    }

    private void initialize() {
        int buttonWidth = 500;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel lblNewLabel = new JLabel("TITULO DO JOGO");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblNewLabel.setFont(new Font("Monotype Corsiva", Font.BOLD, 49));
        lblNewLabel.setMaximumSize(new Dimension(buttonWidth, Integer.MAX_VALUE));
        add(lblNewLabel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 2, 10, 10));

        JButton botaoAtacar = new JButton("Atacar");
        botaoAtacar.setFont(new Font("Tahoma", Font.PLAIN, 33));
        botaoAtacar.setMaximumSize(new Dimension(buttonWidth, Integer.MAX_VALUE));
        buttonPanel.add(botaoAtacar);

        JButton botaoMagia = new JButton("Magia");
        botaoMagia.setFont(new Font("Tahoma", Font.PLAIN, 33));
        botaoMagia.setMaximumSize(new Dimension(buttonWidth, Integer.MAX_VALUE));
        buttonPanel.add(botaoMagia);

        JButton botaoUsarItem = new JButton("Usar Item");
        botaoUsarItem.setMaximumSize(new Dimension(buttonWidth, Integer.MAX_VALUE));
        botaoUsarItem.setFont(new Font("Tahoma", Font.PLAIN, 33));
        buttonPanel.add(botaoUsarItem);
        botaoUsarItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Close the game
            }
        });

        JButton botaoFugir = new JButton("Fugir");
        botaoFugir.setMaximumSize(new Dimension(buttonWidth, Integer.MAX_VALUE));
        botaoFugir.setFont(new Font("Tahoma", Font.PLAIN, 33));
        buttonPanel.add(botaoFugir);
        botaoFugir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Close the game
            }
        });

        add(Box.createVerticalStrut(20));
        add(buttonPanel);
        
        Component verticalStrut_1 = Box.createVerticalStrut(20);
        add(verticalStrut_1);
//        add(Box.createVerticalStrut(40));
        
        JLabel lblNewLabel_1 = new JLabel("HP");
        lblNewLabel_1.setMaximumSize(new Dimension(500, 2147483647));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 10));
        lblNewLabel_1.setAlignmentX(0.5f);
        add(lblNewLabel_1);
        
        JProgressBar progressBar = new JProgressBar();
        progressBar.setForeground(new Color(153, 0, 0));
        progressBar.setStringPainted(true);
        progressBar.setValue(50);
        add(progressBar);
        
        JLabel lblNewLabel_1_1 = new JLabel("MP");
        lblNewLabel_1_1.setMaximumSize(new Dimension(500, 2147483647));
        lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 10));
        lblNewLabel_1_1.setAlignmentX(0.5f);
        add(lblNewLabel_1_1);
        
        JProgressBar progressBar_1 = new JProgressBar();
        progressBar_1.setStringPainted(true);
        progressBar_1.setValue(70);
        add(progressBar_1);
        
        Component verticalStrut = Box.createVerticalStrut(20);
        add(verticalStrut);
    }
}
