package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgRectangle extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgRectangle dialog = new DlgRectangle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgRectangle() {
		setTitle("EDIT RECTANGLE");
		setModal(true);
		setBounds(100, 100, 450, 300);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 428, 0 };
		gridBagLayout.rowHeights = new int[] { 195, 39, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagConstraints gbc_contentPanel = new GridBagConstraints();
		gbc_contentPanel.fill = GridBagConstraints.BOTH;
		gbc_contentPanel.insets = new Insets(0, 0, 5, 0);
		gbc_contentPanel.gridx = 0;
		gbc_contentPanel.gridy = 0;
		getContentPane().add(contentPanel, gbc_contentPanel);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblUpperX = new JLabel("X coordinate of UpperLeftPoint");
			GridBagConstraints gbc_lblUpperX = new GridBagConstraints();
			gbc_lblUpperX.insets = new Insets(0, 0, 5, 5);
			gbc_lblUpperX.anchor = GridBagConstraints.WEST;
			gbc_lblUpperX.gridx = 0;
			gbc_lblUpperX.gridy = 0;
			contentPanel.add(lblUpperX, gbc_lblUpperX);
		}
		{
			JTextArea txtUpperX = new JTextArea();
			GridBagConstraints gbc_txtUpperX = new GridBagConstraints();
			gbc_txtUpperX.insets = new Insets(0, 0, 5, 0);
			gbc_txtUpperX.fill = GridBagConstraints.BOTH;
			gbc_txtUpperX.gridx = 1;
			gbc_txtUpperX.gridy = 0;
			JScrollPane scrollTxtUpperX = new JScrollPane(txtUpperX);
			contentPanel.add(scrollTxtUpperX, gbc_txtUpperX);
			txtUpperX.setLineWrap(true);
		}
		{
			JLabel lblUpperY = new JLabel("Y coordinate of UpperLeftPoint");
			GridBagConstraints gbc_lblUpperY = new GridBagConstraints();
			gbc_lblUpperY.insets = new Insets(0, 0, 5, 5);
			gbc_lblUpperY.gridx = 0;
			gbc_lblUpperY.gridy = 1;
			contentPanel.add(lblUpperY, gbc_lblUpperY);
		}
		{
			JTextArea txtUpperY = new JTextArea();
			GridBagConstraints gbc_txtUpperY = new GridBagConstraints();
			gbc_txtUpperY.insets = new Insets(0, 0, 5, 0);
			gbc_txtUpperY.fill = GridBagConstraints.BOTH;
			gbc_txtUpperY.gridx = 1;
			gbc_txtUpperY.gridy = 1;
			JScrollPane scrollTxtUpperY = new JScrollPane(txtUpperY);
			contentPanel.add(scrollTxtUpperY, gbc_txtUpperY);
			txtUpperY.setLineWrap(true);
		}
		{
			JLabel lblWidth = new JLabel("Width");
			GridBagConstraints gbc_lblWidth = new GridBagConstraints();
			gbc_lblWidth.insets = new Insets(0, 0, 5, 5);
			gbc_lblWidth.gridx = 0;
			gbc_lblWidth.gridy = 2;
			contentPanel.add(lblWidth, gbc_lblWidth);
		}
		{
			JTextArea txtWidth = new JTextArea();
			GridBagConstraints gbc_txtWidth = new GridBagConstraints();
			gbc_txtWidth.insets = new Insets(0, 0, 5, 0);
			gbc_txtWidth.fill = GridBagConstraints.BOTH;
			gbc_txtWidth.gridx = 1;
			gbc_txtWidth.gridy = 2;
			JScrollPane scrollTxtWidth = new JScrollPane(txtWidth);
			contentPanel.add(scrollTxtWidth, gbc_txtWidth);
			txtWidth.setLineWrap(true);
		}
		{
			JLabel lblHeight = new JLabel("Height");
			GridBagConstraints gbc_lblHeight = new GridBagConstraints();
			gbc_lblHeight.insets = new Insets(0, 0, 5, 5);
			gbc_lblHeight.gridx = 0;
			gbc_lblHeight.gridy = 3;
			contentPanel.add(lblHeight, gbc_lblHeight);
		}
		{
			JTextArea txtHeight = new JTextArea();
			GridBagConstraints gbc_txtHeight = new GridBagConstraints();
			gbc_txtHeight.insets = new Insets(0, 0, 5, 0);
			gbc_txtHeight.fill = GridBagConstraints.BOTH;
			gbc_txtHeight.gridx = 1;
			gbc_txtHeight.gridy = 3;
			JScrollPane scrollTxtHeight = new JScrollPane(txtHeight);
			contentPanel.add(scrollTxtHeight, gbc_txtHeight);
			txtHeight.setLineWrap(true);
		}
		{
			JButton btnColor = new JButton("CHOSE COLOR");
			btnColor.setBackground(Color.RED);
			btnColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Color initialColor = Color.BLACK;
					Color color = JColorChooser.showDialog(null, "Select a color", initialColor);
					btnColor.setBackground(color);
				}
			});
			GridBagConstraints gbc_btnColor = new GridBagConstraints();
			gbc_btnColor.gridx = 1;
			gbc_btnColor.gridy = 4;
			contentPanel.add(btnColor, gbc_btnColor);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			GridBagConstraints gbc_buttonPane = new GridBagConstraints();
			gbc_buttonPane.anchor = GridBagConstraints.NORTH;
			gbc_buttonPane.fill = GridBagConstraints.HORIZONTAL;
			gbc_buttonPane.gridx = 0;
			gbc_buttonPane.gridy = 1;
			getContentPane().add(buttonPane, gbc_buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
