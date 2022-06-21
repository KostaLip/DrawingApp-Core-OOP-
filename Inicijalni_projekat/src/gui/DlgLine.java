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
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgLine extends JDialog {

	private final JPanel contentPanel = new JPanel();
	Color boja;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgLine dialog = new DlgLine();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgLine() {
		setTitle("EDIT LINE");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblStartX = new JLabel("X coordinate of StartPoint");
			GridBagConstraints gbc_lblStartX = new GridBagConstraints();
			gbc_lblStartX.insets = new Insets(0, 0, 5, 5);
			gbc_lblStartX.gridx = 0;
			gbc_lblStartX.gridy = 0;
			contentPanel.add(lblStartX, gbc_lblStartX);
		}
		{
			JTextArea txtStartX = new JTextArea();
			GridBagConstraints gbc_txtStartX = new GridBagConstraints();
			gbc_txtStartX.insets = new Insets(0, 0, 5, 0);
			gbc_txtStartX.fill = GridBagConstraints.BOTH;
			gbc_txtStartX.gridx = 2;
			gbc_txtStartX.gridy = 0;
			JScrollPane scrollTxtStartX = new JScrollPane(txtStartX);
			contentPanel.add(scrollTxtStartX, gbc_txtStartX);
			txtStartX.setLineWrap(true);
		}
		{
			JLabel lblStartY = new JLabel("Y coordinate of StartPoint");
			GridBagConstraints gbc_lblStartY = new GridBagConstraints();
			gbc_lblStartY.insets = new Insets(0, 0, 5, 5);
			gbc_lblStartY.gridx = 0;
			gbc_lblStartY.gridy = 1;
			contentPanel.add(lblStartY, gbc_lblStartY);
		}
		{
			JTextArea txtStartY = new JTextArea();
			GridBagConstraints gbc_txtStartY = new GridBagConstraints();
			gbc_txtStartY.insets = new Insets(0, 0, 5, 0);
			gbc_txtStartY.fill = GridBagConstraints.BOTH;
			gbc_txtStartY.gridx = 2;
			gbc_txtStartY.gridy = 1;
			JScrollPane scrollTxtStartY = new JScrollPane(txtStartY);
			contentPanel.add(scrollTxtStartY, gbc_txtStartY);
			txtStartY.setLineWrap(true);
		}
		{
			JLabel lblEndX = new JLabel("X coordinate of EndPoint");
			GridBagConstraints gbc_lblEndX = new GridBagConstraints();
			gbc_lblEndX.insets = new Insets(0, 0, 5, 5);
			gbc_lblEndX.gridx = 0;
			gbc_lblEndX.gridy = 2;
			contentPanel.add(lblEndX, gbc_lblEndX);
		}
		{
			JTextArea txtEndX = new JTextArea();
			GridBagConstraints gbc_txtEndX = new GridBagConstraints();
			gbc_txtEndX.insets = new Insets(0, 0, 5, 0);
			gbc_txtEndX.fill = GridBagConstraints.BOTH;
			gbc_txtEndX.gridx = 2;
			gbc_txtEndX.gridy = 2;
			JScrollPane scrollTxtEndX = new JScrollPane(txtEndX);
			contentPanel.add(scrollTxtEndX, gbc_txtEndX);
			txtEndX.setLineWrap(true);
		}
		{
			JLabel lblEndY = new JLabel("Y coordinate of EndPoint");
			GridBagConstraints gbc_lblEndY = new GridBagConstraints();
			gbc_lblEndY.insets = new Insets(0, 0, 5, 5);
			gbc_lblEndY.anchor = GridBagConstraints.WEST;
			gbc_lblEndY.gridx = 0;
			gbc_lblEndY.gridy = 3;
			contentPanel.add(lblEndY, gbc_lblEndY);
		}
		{
			JTextArea txtEndY = new JTextArea();
			GridBagConstraints gbc_txtEndY = new GridBagConstraints();
			gbc_txtEndY.insets = new Insets(0, 0, 5, 0);
			gbc_txtEndY.fill = GridBagConstraints.BOTH;
			gbc_txtEndY.gridx = 2;
			gbc_txtEndY.gridy = 3;
			JScrollPane scrollTxtEndY = new JScrollPane(txtEndY);
			contentPanel.add(scrollTxtEndY, gbc_txtEndY);
			txtEndY.setLineWrap(true);
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
			gbc_btnColor.gridx = 2;
			gbc_btnColor.gridy = 4;
			contentPanel.add(btnColor, gbc_btnColor);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
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
	
	public Color getColor() {
		return this.boja;
	}

}
