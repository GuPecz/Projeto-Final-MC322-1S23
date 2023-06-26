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

	JLabel labelLore;
	private JButton botaoContinuar;
	
	public LorePanel() {
		super();
		botaoContinuar = new JButton("Continuar");
		botaoContinuar.setAlignmentX(Component.CENTER_ALIGNMENT);
		inicializar();
	}

	private void inicializar() {
		int buttonWidth = 500;
		 
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

	    labelLore = new JLabel("<html>%s, o reino precisa de você!<br><br>"
	    		+ "  Terríveis vilões e seus lacaios estão aterrorizando a população.<br>"
	    		+ "  \r<br>"
	    		+ "  Em tempos dificuldade, um homem ganancioso extorque os necessitados dizendo ter a salvação. \r<br>"
	    		+ "  Pobres almas manipuladas pelo sua suposta habilidade de juntar riquezas o seguem agora.\r<br>"
	    		+ "  \r<br>"
	    		+ "  Dizem ainda que, nos momentos mais desafortunados, conseguem ouvir uma melodia assustadora,\r<br>"
	    		+ "  como se a própria morte estivesse a seu lado quando então avistam uma figura ao longe produzindo tais sons.\r<br>"
	    		+ "  Mesmo esta criatura conseguiu reunir lacaios que tentam imitá-la.\r<br>"
	    		+ "  \r<br>"
	    		+ "  E a raiz desse mal... Um aterrador ancião que leva a mente de quem o ouve a mais insana confusão.\r<br>"
	    		+ "  Tolamente alguns o seguem como discípulos na falsa esperança de entender seus discursos incompreensíveis...\r<br>"
	    		+ "  \r<br>"
	    		+ "  Por favor, eles usam uma torre como covil, derrote o Ancião!</html>");
	    labelLore.setHorizontalAlignment(SwingConstants.CENTER);
	    labelLore.setAlignmentX(Component.CENTER_ALIGNMENT);
	    labelLore.setFont(new Font("Monotype Corsiva", Font.BOLD, 20));
	    labelLore.setMaximumSize(new Dimension(buttonWidth, Integer.MAX_VALUE));
	    add(labelLore);
	    
	    JPanel panel = new JPanel();
	    add(panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	    Component verticalStrut_1 = Box.createVerticalStrut(40);
	    panel.add(verticalStrut_1);
        
	    panel.add(botaoContinuar);	
	    botaoContinuar.setFont(new Font("Tahoma", Font.PLAIN, 33));
        botaoContinuar.setMaximumSize(new Dimension(buttonWidth, Integer.MAX_VALUE));
        Component verticalStrut_2 = Box.createVerticalStrut(40);
        panel.add(verticalStrut_2);
	}

	public JButton getBotaoContinuar() {
		return botaoContinuar;
	}

	public JLabel getLabelLore() {
		return labelLore;
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
 * Dizem ainda que, nos momentos mais desafortunados, conseguem ouvir uma melodia assustadora,
 * como se a própria morte estivesse a seu lado quando então avistam uma figura ao longe produzindo tais sons.
 * Mesmo esta criatura conseguiu reunir lacaios que tentam imitá-la.
 * 
 * E a raiz desse mal... Um aterrador ancião que leva a mente de quem o ouve a mais insana confusão.
 * Tolamente alguns o seguem como discípulos na falsa esperança de entender seus discursos incompreensíveis.
 * 
 * Por favor, eles usam uma torre como covil, invada-a e nos salve!
 */
