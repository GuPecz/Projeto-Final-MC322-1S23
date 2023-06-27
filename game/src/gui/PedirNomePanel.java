package gui;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Insets;

// gerado com Window Builder
public class PedirNomePanel extends JPanel {
	private static final long serialVersionUID = -5365825153990485201L;
	private JTextField textFieldNome;
	private JButton botaoConfirmar;
	private JButton botaoVoltar; 

	/**
	 * Create the panel.
	 */
	public PedirNomePanel() {
        textFieldNome = new JTextField(100);
        botaoConfirmar = new JButton("Confirmar");
        botaoVoltar = new JButton("Voltar");
        initialize();
    }
	
	private void initialize() {
        setLayout(new BorderLayout());
        GridBagLayout gbl_contentPanel = new GridBagLayout();
        gbl_contentPanel.columnWeights = new double[]{0.0, 0.0};
        gbl_contentPanel.rowHeights = new int[]{45, 30, 20, 29};
        gbl_contentPanel.columnWidths = new int[] {480, 108};
        JPanel contentPanel = new JPanel(gbl_contentPanel);
        
        JLabel lblNewLabel = new JLabel("Digite seu nome:");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.gridwidth = 2;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 0;
        contentPanel.add(lblNewLabel, gbc_lblNewLabel);
        
        textFieldNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
        GridBagConstraints gbc_textField_1 = new GridBagConstraints();
        gbc_textField_1.fill = GridBagConstraints.BOTH;
        gbc_textField_1.insets = new Insets(0, 0, 5, 5);
        gbc_textField_1.gridx = 0;
        gbc_textField_1.gridy = 1;
        contentPanel.add(textFieldNome, gbc_textField_1);
        textFieldNome.setColumns(10);

        add(contentPanel, BorderLayout.CENTER);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 0, 5, 0);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;

        botaoConfirmar.setFont(new Font("Tahoma", Font.BOLD, 13));
                
        gbc.gridy = 1;
        gbc.weighty = 0.0;
        contentPanel.add(botaoConfirmar, gbc);
        
        botaoVoltar.setFont(new Font("Tahoma", Font.BOLD, 13));
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
        gbc_btnNewButton.gridwidth = 2;
        gbc_btnNewButton.gridx = 0;
        gbc_btnNewButton.gridy = 3;
        contentPanel.add(botaoVoltar, gbc_btnNewButton);
	}

	public JButton getBotaoConfirmar() {
        return botaoConfirmar;
    }

    public JButton getBotaoVoltar() {
        return botaoVoltar;
    }

    public JTextField getTextFieldNome() {
        return textFieldNome;
    }
	
}
