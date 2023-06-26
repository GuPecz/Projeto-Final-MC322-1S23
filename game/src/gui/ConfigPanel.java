package gui;

import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JButton;

public class ConfigPanel extends JPanel {
	JButton botaoTriste;
	private static final long serialVersionUID = 4327526735864723755L;
	
	public ConfigPanel() {
		setLayout(null);
		
		botaoTriste = new JButton(":(");
		botaoTriste.setFont(new Font("Tahoma", Font.PLAIN, 99));
		botaoTriste.setBounds(518, 229, 283, 201);
		add(botaoTriste);
	}

	public JButton getBotaoTriste() {
		return botaoTriste;
	}
}
