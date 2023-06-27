package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

// gerado com Window Builder
public class SelecaoSalaPanel extends JPanel {
    private static final long serialVersionUID = -7063787468413315273L;
    private JButton botaoNorte;
    private JButton botaoSul;
    private JButton botaoLeste;
    private JButton botaoOeste;

    public SelecaoSalaPanel() {
        initialize();
    }

    private void initialize() {
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0};
        gridBagLayout.rowHeights = new int[]{0};
        gridBagLayout.columnWeights = new double[]{};
        gridBagLayout.rowWeights = new double[]{};
        setLayout(gridBagLayout);
        setLayout(new BorderLayout());
        GridBagLayout gbl_contentPanel = new GridBagLayout();
        gbl_contentPanel.columnWeights = new double[]{0.0, 0.0};
        gbl_contentPanel.rowHeights = new int[]{45, 0, 0};
        gbl_contentPanel.columnWidths = new int[] {130, 0};
        JPanel contentPanel = new JPanel(gbl_contentPanel);

        JLabel lblNewLabel = new JLabel("O que deseja fazer?");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.gridwidth = 2;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 0;
        contentPanel.add(lblNewLabel, gbc_lblNewLabel);

        add(contentPanel, BorderLayout.CENTER);

        botaoNorte = new JButton("Subir");
        botaoNorte.setFont(new Font("Tahoma", Font.BOLD, 13));
        GridBagConstraints gbc_botaoNorte = new GridBagConstraints();
        gbc_botaoNorte.fill = GridBagConstraints.HORIZONTAL;
        gbc_botaoNorte.insets = new Insets(0, 0, 5, 5);
        gbc_botaoNorte.gridx = 0;
        gbc_botaoNorte.gridy = 1;
        contentPanel.add(botaoNorte, gbc_botaoNorte);
        botaoSul = new JButton("Descer");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 0, 5, 0);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;

        botaoSul.setFont(new Font("Tahoma", Font.BOLD, 13));

        gbc.gridy = 1;
        gbc.weighty = 0.0;
        contentPanel.add(botaoSul, gbc);
        botaoOeste = new JButton("Ir para a esquerda");

        botaoOeste.setFont(new Font("Tahoma", Font.BOLD, 13));
        GridBagConstraints gbc_botaoOeste = new GridBagConstraints();
        gbc_botaoOeste.fill = GridBagConstraints.HORIZONTAL;
        gbc_botaoOeste.insets = new Insets(0, 0, 0, 5);
        gbc_botaoOeste.gridx = 0;
        gbc_botaoOeste.gridy = 2;
        contentPanel.add(botaoOeste, gbc_botaoOeste);
        botaoLeste = new JButton("Ir para a direita");

        botaoLeste.setFont(new Font("Tahoma", Font.BOLD, 13));
        GridBagConstraints gbc_botaoLeste = new GridBagConstraints();
        gbc_botaoLeste.fill = GridBagConstraints.HORIZONTAL;
        gbc_botaoLeste.gridx = 1;
        gbc_botaoLeste.gridy = 2;
        contentPanel.add(botaoLeste, gbc_botaoLeste);
    }

    public JButton getBotaoLeste() {
        return botaoLeste;
    }

    public JButton getBotaoNorte() {
        return botaoNorte;
    }

    public JButton getBotaoOeste() {
        return botaoOeste;
    }

    public JButton getBotaoSul() {
        return botaoSul;
    }
}
