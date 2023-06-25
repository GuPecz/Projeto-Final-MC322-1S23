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

public class LorePanel extends JPanel {
	private static final long serialVersionUID = 2120893491843979877L;
	
	/**
	 * Create the panel.
	 */
	private JButton botaoContinuar;
	
	public LorePanel() {
		super();
		botaoContinuar = new JButton("Continuar");
		inicializar();
	}

	private void inicializar() {
		int buttonWidth = 500;
		 
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

	    JLabel lblNewLabel = new JLabel("(nome), o reino precisa de você!\n"
	    		+ "  Terríveis vilões e seus lacaios estão aterrorizando a população.\n"
	    		+ "  \r\n"
	    		+ "  Em tempos dificuldade, um homem ganancioso extorque os necessitados dizendo ter a salvação. \r\n"
	    		+ "  Pobres almas manipuladas pelo sua suposta habilidade de juntar riquezas o seguem agora.\r\n"
	    		+ "  \r\n"
	    		+ "  Um aterrador ancião leva a mente de quem o ouve a mais insana confusão.\r\n"
	    		+ "  Tolamente alguns o seguem como discípulos na falsa esperança de entender seus discursos incompreensíveis...\r\n"
	    		+ "  \r\n"
	    		+ "  Dizem ainda que, nos momentos mais desafortunados, conseguem ouvir uma melodia assustadora e se sentem um arrepio na espinha,\r\n"
	    		+ "  como se a própria morte estivesse a seu lado quando então avistam uma figura ao longe produzindo tais sons.\r\n"
	    		+ "  Mesmo esta criatura conseguiu reunir lacaios que tentam imitá-la.\r\n"
	    		+ "  \r\n"
	    		+ "  Por favor, eles usam uma torre como covil, invada-a e nos salve!");
	    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
	    lblNewLabel.setFont(new Font("Monotype Corsiva", Font.BOLD, 30));
	    lblNewLabel.setMaximumSize(new Dimension(buttonWidth, Integer.MAX_VALUE));
	    add(lblNewLabel);
	    
	    JPanel panel = new JPanel();
	    add(panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
	    panel.add(botaoContinuar);	
	    botaoContinuar.setFont(new Font("Tahoma", Font.PLAIN, 33));
        botaoContinuar.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoContinuar.setMaximumSize(new Dimension(buttonWidth, Integer.MAX_VALUE));
        Component verticalStrut_1 = Box.createVerticalStrut(40);
        panel.add(verticalStrut_1);
	}
}

/*
 * Texto da lore
 * (nome), o reino precisa de você!
 * 
 * Terríveis vilões e seus lacaios estão aterrorizando a população.
 * 
 * Em tempos dificuldade, um homem ganancioso extorque os necessitados dizendo ter a salvação. 
 * Pobres almas manipuladas pelo sua suposta habilidade de juntar riquezas o seguem agora.
 * 
 * Um aterrador ancião leva a mente de quem o ouve a mais insana confusão.
 * Tolamente alguns o seguem como discípulos na falsa esperança de entender seus discursos incompreensíveis...
 * 
 * Dizem ainda que, nos momentos mais desafortunados, conseguem ouvir uma melodia assustadora e se sentem um arrepio na espinha,
 * como se a própria morte estivesse a seu lado quando então avistam uma figura ao longe produzindo tais sons.
 * Mesmo esta criatura conseguiu reunir lacaios que tentam imitá-la.
 * 
 * Por favor, eles usam uma torre como covil, invada-a e nos salve!
 */
