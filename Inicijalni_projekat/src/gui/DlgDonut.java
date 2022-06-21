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

import geometry.Circle;
import geometry.Donut;
import geometry.Point;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgDonut extends JDialog {

	private final JPanel contentPanel = new JPanel();
	JTextArea txtCentarX = new JTextArea();
	JTextArea txtCentarY = new JTextArea();
	JTextArea txtRadius = new JTextArea();
	JTextArea txtInnerRadius = new JTextArea();
	Donut kifla=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgDonut dialog = new DlgDonut();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDonut() {
		setModal(true);
		setTitle("EDIT DONUT");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblCenterX = new JLabel("X coordinate of Center");
			GridBagConstraints gbc_lblCenterX = new GridBagConstraints();
			gbc_lblCenterX.insets = new Insets(0, 0, 5, 5);
			gbc_lblCenterX.anchor = GridBagConstraints.WEST;
			gbc_lblCenterX.gridx = 0;
			gbc_lblCenterX.gridy = 0;
			contentPanel.add(lblCenterX, gbc_lblCenterX);
		}
		{
			GridBagConstraints gbc_txtCenterX = new GridBagConstraints();
			gbc_txtCenterX.insets = new Insets(0, 0, 5, 0);
			gbc_txtCenterX.fill = GridBagConstraints.BOTH;
			gbc_txtCenterX.gridx = 1;
			gbc_txtCenterX.gridy = 0;
			JScrollPane scrollTxtCenterX = new JScrollPane(txtCentarX);
			contentPanel.add(scrollTxtCenterX, gbc_txtCenterX);
			txtCentarX.setLineWrap(true);
		}
		{
			JLabel lblCenterY = new JLabel("Y coordinate of Center");
			GridBagConstraints gbc_lblCenterY = new GridBagConstraints();
			gbc_lblCenterY.insets = new Insets(0, 0, 5, 5);
			gbc_lblCenterY.gridx = 0;
			gbc_lblCenterY.gridy = 1;
			contentPanel.add(lblCenterY, gbc_lblCenterY);
		}
		{
			GridBagConstraints gbc_txtCenterY = new GridBagConstraints();
			gbc_txtCenterY.insets = new Insets(0, 0, 5, 0);
			gbc_txtCenterY.fill = GridBagConstraints.BOTH;
			gbc_txtCenterY.gridx = 1;
			gbc_txtCenterY.gridy = 1;
			JScrollPane scrollTxtCenterY = new JScrollPane(txtCentarY);
			contentPanel.add(scrollTxtCenterY, gbc_txtCenterY);
			txtCentarY.setLineWrap(true);
		}
		{
			JLabel lblRadius = new JLabel("Radius");
			GridBagConstraints gbc_lblRadius = new GridBagConstraints();
			gbc_lblRadius.insets = new Insets(0, 0, 5, 5);
			gbc_lblRadius.gridx = 0;
			gbc_lblRadius.gridy = 2;
			contentPanel.add(lblRadius, gbc_lblRadius);
		}
		{
			GridBagConstraints gbc_txtRadius = new GridBagConstraints();
			gbc_txtRadius.insets = new Insets(0, 0, 5, 0);
			gbc_txtRadius.fill = GridBagConstraints.BOTH;
			gbc_txtRadius.gridx = 1;
			gbc_txtRadius.gridy = 2;
			JScrollPane scrollTxtRadius = new JScrollPane(txtRadius);
			contentPanel.add(scrollTxtRadius, gbc_txtRadius);
			txtRadius.setLineWrap(true);
		}
		{
			JLabel lblInnerRadius = new JLabel("Inner Radius");
			GridBagConstraints gbc_lblInnerRadius = new GridBagConstraints();
			gbc_lblInnerRadius.insets = new Insets(0, 0, 5, 5);
			gbc_lblInnerRadius.gridx = 0;
			gbc_lblInnerRadius.gridy = 3;
			contentPanel.add(lblInnerRadius, gbc_lblInnerRadius);
		}
		{
			GridBagConstraints gbc_txtInnerRadius = new GridBagConstraints();
			gbc_txtInnerRadius.insets = new Insets(0, 0, 5, 0);
			gbc_txtInnerRadius.fill = GridBagConstraints.BOTH;
			gbc_txtInnerRadius.gridx = 1;
			gbc_txtInnerRadius.gridy = 3;
			JScrollPane scrollTxtInnerRadius = new JScrollPane(txtInnerRadius);
			contentPanel.add(scrollTxtInnerRadius, gbc_txtInnerRadius);
			txtInnerRadius.setLineWrap(true);
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
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (txtCentarX.getText().isEmpty() || txtCentarY.getText().isEmpty()
								|| txtRadius.getText().isEmpty() || txtInnerRadius.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "MORATE UNIJETI SVE PODATKE", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						} else if (!isNumeric(txtCentarX.getText())) {
							JOptionPane.showMessageDialog(null, "X osa mora biti broj", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						} else if (!isNumeric(txtCentarY.getText())) {
							JOptionPane.showMessageDialog(null, "Y osa mora biti broj", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						} else if (!isNumeric(txtRadius.getText())) {
							JOptionPane.showMessageDialog(null, "Poluprecnik mora biti broj", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						} else if (!isNumeric(txtInnerRadius.getText())) {
							JOptionPane.showMessageDialog(null, "InnerRadius mora biti broj", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						} else if (isNumeric(txtCentarX.getText()) && isNumeric(txtCentarY.getText())
								&& isNumeric(txtRadius.getText()) && isNumeric(txtInnerRadius.getText())) {
							int x = Integer.parseInt(txtCentarX.getText());
							int y = Integer.parseInt(txtCentarY.getText());
							int radius = Integer.parseInt(txtRadius.getText());
							int innerRadius = Integer.parseInt(txtInnerRadius.getText());
							if (x < 0) {
								JOptionPane.showMessageDialog(null, "X osa mora biti veca 0", "ERROR",
										JOptionPane.ERROR_MESSAGE);
							} else if (y < 0) {
								JOptionPane.showMessageDialog(null, "Y osa mora biti veca od 0", "ERROR",
										JOptionPane.ERROR_MESSAGE);
							} else if (radius <= 0) {
								JOptionPane.showMessageDialog(null, "Poluprecnik mora biti strogo veci od 0", "ERROR",
										JOptionPane.ERROR_MESSAGE);
							} else if (innerRadius <= 0) {
								JOptionPane.showMessageDialog(null, "InnerRadius mora biti strogo veci od 0", "ERROR",
										JOptionPane.ERROR_MESSAGE);
							} else if (innerRadius >= radius) {
								JOptionPane.showMessageDialog(null,
										"InnerRadius mora biti storgo manji od poluprecnika", "ERROR",
										JOptionPane.ERROR_MESSAGE);
							} else {
								Point center = new Point(x, y);
								kifla = new Donut(center, radius, innerRadius);
								dispose();
							}
						}
					}
				});
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

	private static boolean isNumeric(String str) {
		int number;
		if (str == null || str == "") {
			return false;
		}
		try {
			number = Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public Donut getDonut() {
		return this.kifla;
	}
}