package gui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Insets;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JProgressBar;
import java.awt.Color;
import javax.swing.SwingConstants;

public class SalaPanel extends JPanel {
	private static final long serialVersionUID = -476786453758437071L;
	private JLabel labelPosicao;
	private JLabel labelTexto;
	private JLabel labelImagem;
	private JProgressBar barraHp;
	private JProgressBar barraHpInimigo;
	private JProgressBar barraMp;
	private JButton botao1;
	private JButton botao2;
	private JButton botao3;
	private JButton botao4;
	private JLabel labelHp_1;
	
	public SalaPanel() {
	    initialize();
	}
	
	private void initialize() {
        setLayout(new BorderLayout());
        GridBagLayout gbl_contentPanel = new GridBagLayout();
        gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0};
        gbl_contentPanel.rowHeights = new int[]{55, 92, 25, 0, 226, 32, 143, 92, 11, 17, 0, 0, 0, 29};
        gbl_contentPanel.columnWidths = new int[] {170, 469, 480, 174};
        JPanel contentPanel = new JPanel(gbl_contentPanel);

        add(contentPanel, BorderLayout.CENTER);
        
        labelPosicao = new JLabel("Andar %d, Sala %d");
        labelPosicao.setFont(new Font("Tahoma", Font.BOLD, 13));
        GridBagConstraints gbc_labelPosicao = new GridBagConstraints();
        gbc_labelPosicao.insets = new Insets(0, 0, 5, 5);
        gbc_labelPosicao.gridx = 0;
        gbc_labelPosicao.gridy = 0;
        contentPanel.add(labelPosicao, gbc_labelPosicao);
        
        labelTexto = new JLabel("Lorem ipsum dolor sit amet, consectetur adipiscing elit. In finibus commodo diam, sit amet malesuada nulla fringilla eu");
        labelTexto.setFont(new Font("Tahoma", Font.PLAIN, 17));
        GridBagConstraints gbc_labelTexto = new GridBagConstraints();
        gbc_labelTexto.gridwidth = 2;
        gbc_labelTexto.insets = new Insets(0, 0, 5, 5);
        gbc_labelTexto.gridx = 1;
        gbc_labelTexto.gridy = 1;
        contentPanel.add(labelTexto, gbc_labelTexto);
        
        labelHp_1 = new JLabel("%s");
        labelHp_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        GridBagConstraints gbc_labelHp_1 = new GridBagConstraints();
        gbc_labelHp_1.gridwidth = 2;
        gbc_labelHp_1.insets = new Insets(0, 0, 5, 5);
        gbc_labelHp_1.gridx = 1;
        gbc_labelHp_1.gridy = 2;
        contentPanel.add(labelHp_1, gbc_labelHp_1);
        
        barraHpInimigo = new JProgressBar();
        barraHpInimigo.setValue(50);
        barraHpInimigo.setToolTipText("");
        barraHpInimigo.setStringPainted(true);
        barraHpInimigo.setForeground(new Color(153, 0, 0));
        GridBagConstraints gbc_barraHpInimigo = new GridBagConstraints();
        gbc_barraHpInimigo.fill = GridBagConstraints.HORIZONTAL;
        gbc_barraHpInimigo.gridwidth = 2;
        gbc_barraHpInimigo.insets = new Insets(0, 0, 5, 5);
        gbc_barraHpInimigo.gridx = 1;
        gbc_barraHpInimigo.gridy = 3;
        contentPanel.add(barraHpInimigo, gbc_barraHpInimigo);
        
        labelImagem = new JLabel("");
        labelImagem.setHorizontalAlignment(SwingConstants.CENTER);
        labelImagem.setIcon(null);
        GridBagConstraints gbc_labelImagem = new GridBagConstraints();
        gbc_labelImagem.gridwidth = 2;
        gbc_labelImagem.insets = new Insets(0, 0, 5, 5);
        gbc_labelImagem.gridx = 1;
        gbc_labelImagem.gridy = 4;
        contentPanel.add(labelImagem, gbc_labelImagem);
        
        JPanel painelBotoes = new JPanel();
        GridBagConstraints gbc_painelBotoes = new GridBagConstraints();
        gbc_painelBotoes.fill = GridBagConstraints.BOTH;
        gbc_painelBotoes.gridheight = 2;
        gbc_painelBotoes.gridwidth = 2;
        gbc_painelBotoes.insets = new Insets(0, 0, 5, 5);
        gbc_painelBotoes.gridx = 1;
        gbc_painelBotoes.gridy = 6;
        contentPanel.add(painelBotoes, gbc_painelBotoes);
        painelBotoes.setLayout(new GridLayout(2, 2, 10, 10));
        
        botao1 = new JButton("Ataque");
        botao1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        painelBotoes.add(botao1);
        
        botao2 = new JButton("Magia");
        botao2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        painelBotoes.add(botao2);
        
        botao3 = new JButton("Pocao");
        botao3.setFont(new Font("Tahoma", Font.PLAIN, 20));
        painelBotoes.add(botao3);
        
        botao4 = new JButton("Fugir");
        botao4.setFont(new Font("Tahoma", Font.PLAIN, 20));
        painelBotoes.add(botao4);
        
        JLabel labelHp = new JLabel("HP");
        labelHp.setFont(new Font("Tahoma", Font.PLAIN, 14));
        GridBagConstraints gbc_labelHp = new GridBagConstraints();
        gbc_labelHp.gridwidth = 2;
        gbc_labelHp.insets = new Insets(0, 0, 5, 5);
        gbc_labelHp.gridx = 1;
        gbc_labelHp.gridy = 9;
        contentPanel.add(labelHp, gbc_labelHp);
        
        barraHp = new JProgressBar();
        barraHp.setToolTipText("");
        barraHp.setValue(50);
        barraHp.setStringPainted(true);
        barraHp.setForeground(new Color(153, 0, 0));
        GridBagConstraints gbc_barraHp = new GridBagConstraints();
        gbc_barraHp.fill = GridBagConstraints.HORIZONTAL;
        gbc_barraHp.gridwidth = 2;
        gbc_barraHp.insets = new Insets(0, 0, 5, 5);
        gbc_barraHp.gridx = 1;
        gbc_barraHp.gridy = 10;
        contentPanel.add(barraHp, gbc_barraHp);
        
        JLabel labelMp = new JLabel("MP");
        labelMp.setFont(new Font("Tahoma", Font.PLAIN, 14));
        GridBagConstraints gbc_labelMp = new GridBagConstraints();
        gbc_labelMp.gridwidth = 2;
        gbc_labelMp.insets = new Insets(0, 0, 5, 5);
        gbc_labelMp.gridx = 1;
        gbc_labelMp.gridy = 11;
        contentPanel.add(labelMp, gbc_labelMp);
        
        barraMp = new JProgressBar();
        barraMp.setForeground(Color.BLUE);
        barraMp.setStringPainted(true);
        barraMp.setValue(75);
        GridBagConstraints gbc_barraMp = new GridBagConstraints();
        gbc_barraMp.fill = GridBagConstraints.HORIZONTAL;
        gbc_barraMp.gridwidth = 2;
        gbc_barraMp.insets = new Insets(0, 0, 5, 5);
        gbc_barraMp.gridx = 1;
        gbc_barraMp.gridy = 12;
        contentPanel.add(barraMp, gbc_barraMp);
	}

    public JButton getBotao1() {
        return botao1;
    }

    public JButton getBotao2() {
        return botao2;
    }

    public JButton getBotao3() {
        return botao3;
    }

    public JButton getBotao4() {
        return botao4;
    }

    public JProgressBar getBarraHp() {
        return barraHp;
    }

    public JProgressBar getBarraMp() {
        return barraMp;
    }

    public JLabel getLabelImagem() {
        return labelImagem;
    }

    public JLabel getLabelPosicao() {
        return labelPosicao;
    }

    public JLabel getLabelTexto() {
        return labelTexto;
    }

    public JProgressBar getBarraHpInimigo() {
        return barraHpInimigo;
    }
}
