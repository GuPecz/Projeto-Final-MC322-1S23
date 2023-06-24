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


public class PedirNomePanel extends JPanel {
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public PedirNomePanel() {
        setLayout(new BorderLayout());
        GridBagLayout gbl_contentPanel = new GridBagLayout();
        gbl_contentPanel.columnWeights = new double[]{0.0, 0.0};
        gbl_contentPanel.rowHeights = new int[]{45, 30};
        gbl_contentPanel.columnWidths = new int[] {480, 108};
        JPanel contentPanel = new JPanel(gbl_contentPanel);
        
        JLabel lblNewLabel = new JLabel("Digite seu nome:");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.gridwidth = 2;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 0;
        contentPanel.add(lblNewLabel, gbc_lblNewLabel);
        
        textField_1 = new JTextField(100);
        textField_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        GridBagConstraints gbc_textField_1 = new GridBagConstraints();
        gbc_textField_1.fill = GridBagConstraints.BOTH;
        gbc_textField_1.insets = new Insets(0, 0, 0, 5);
        gbc_textField_1.gridx = 0;
        gbc_textField_1.gridy = 1;
        contentPanel.add(textField_1, gbc_textField_1);
        textField_1.setColumns(10);

        add(contentPanel, BorderLayout.CENTER);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;

        JButton confirmButton = new JButton("Confirmar");
        confirmButton.setFont(new Font("Tahoma", Font.BOLD, 13));
                
        gbc.gridy = 1;
        gbc.weighty = 0.0;
        contentPanel.add(confirmButton, gbc);
    }

}
