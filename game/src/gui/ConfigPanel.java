package gui;

import javax.swing.JPanel;
import javax.swing.JSlider;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.SwingConstants;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

// gerado com Window Builder
public class ConfigPanel extends JPanel {
	private JSlider sliderVolume;
	private JButton botaoVoltar;
	private static final long serialVersionUID = 4327526735864723755L;
	
	public ConfigPanel() {
		setPreferredSize(new Dimension(1280, 720));
		setBounds(new Rectangle(21, 0, 0, 0));
		initialize();
	}
	
	private void initialize() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		sliderVolume = new JSlider(JSlider.HORIZONTAL, 0, 100, 50); // Values range from 0 to 100, initial value is 50
		sliderVolume.setMaximumSize(new Dimension(500, 100));
        sliderVolume.setMajorTickSpacing(10);
        sliderVolume.setPaintTicks(true);
        sliderVolume.setPaintLabels(true);
		
		Component verticalStrut_1 = Box.createVerticalStrut(259);
		add(verticalStrut_1);

		JLabel label = new JLabel("Volume:");
		label.setMaximumSize(new Dimension(500, 40));
		label.setFont(new Font("Tahoma", Font.BOLD, 33));
		label.setMinimumSize(new Dimension(500, 40));
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(label);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		add(verticalStrut_2);
		add(sliderVolume);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		add(verticalStrut);
		botaoVoltar = new JButton("Voltar");
		botaoVoltar.setMaximumSize(new Dimension(300, 100));
		botaoVoltar.setMinimumSize(new Dimension(500, 100));
		botaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botaoVoltar.setSize(new Dimension(500, 2147483647));
		botaoVoltar.setAlignmentX(Component.CENTER_ALIGNMENT);
		botaoVoltar.setFont(new Font("Tahoma", Font.BOLD, 33));
		botaoVoltar.setBounds(518, 229, 283, 201);
		add(botaoVoltar);
		
		Component verticalStrut_1_1 = Box.createVerticalStrut(259);
		verticalStrut_1_1.setMaximumSize(new Dimension(32767, 259));
		add(verticalStrut_1_1);
        JPanel volumePanel = new JPanel();
        volumePanel.add(new JLabel("Volume: "));
	}

	public JButton getBotaoVoltar() {
		return botaoVoltar;
	}

	public JSlider getSliderVolume() {
		return sliderVolume;
	}
}
