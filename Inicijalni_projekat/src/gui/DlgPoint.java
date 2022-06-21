package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import geometry.Point;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgPoint extends JDialog {

	private final JPanel contentPanel = new JPanel();
	JTextArea txtX = new JTextArea();
	JTextArea txtY = new JTextArea();
	Point tacka = null;
	Color boja;
	private boolean colorChanged;
	JButton btnColor = new JButton("CHOSE COLOR");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgPoint dialog = new DlgPoint();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgPoint() {
		setTitle("EDIT POINT");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 56, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 1.0, 1.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblX = new JLabel("X coordinate");
			GridBagConstraints gbc_lblX = new GridBagConstraints();
			gbc_lblX.insets = new Insets(0, 0, 5, 5);
			gbc_lblX.gridx = 0;
			gbc_lblX.gridy = 0;
			contentPanel.add(lblX, gbc_lblX);
		}
		{
			GridBagConstraints gbc_txtX = new GridBagConstraints();
			gbc_txtX.insets = new Insets(0, 0, 5, 0);
			gbc_txtX.fill = GridBagConstraints.BOTH;
			gbc_txtX.gridx = 3;
			gbc_txtX.gridy = 0;
			JScrollPane scrollTxtX = new JScrollPane(txtX);
			contentPanel.add(scrollTxtX, gbc_txtX);
			txtX.setPreferredSize(new Dimension(200, 50));
			txtX.setLineWrap(true);
		}
		{
			JLabel lblY = new JLabel("Y coordinate");
			GridBagConstraints gbc_lblY = new GridBagConstraints();
			gbc_lblY.insets = new Insets(0, 0, 5, 5);
			gbc_lblY.gridx = 0;
			gbc_lblY.gridy = 1;
			contentPanel.add(lblY, gbc_lblY);
		}
		{
			{
				GridBagConstraints gbc_txtY = new GridBagConstraints();
				gbc_txtY.insets = new Insets(0, 0, 5, 0);
				gbc_txtY.fill = GridBagConstraints.BOTH;
				gbc_txtY.gridx = 3;
				gbc_txtY.gridy = 1;
				JScrollPane scrollTxtY = new JScrollPane(txtY);
				contentPanel.add(scrollTxtY, gbc_txtY);
				txtY.setPreferredSize(new Dimension(300, 50));
				txtY.setLineWrap(true);
			}
		}
		btnColor.setBackground(Color.RED);
		btnColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Color initialColor = Color.BLACK;
				Color color = JColorChooser.showDialog(null, "Select a color", initialColor);
				btnColor.setBackground(color);
				colorChanged = true;
			}
		});
		GridBagConstraints gbc_btnColor = new GridBagConstraints();
		gbc_btnColor.gridx = 3;
		gbc_btnColor.gridy = 2;
		contentPanel.add(btnColor, gbc_btnColor);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (txtX.getText().isEmpty() || txtY.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "MORATE UNIJETI SVE PODATKE", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						} else if (!isNumeric(txtX.getText())) {
							JOptionPane.showMessageDialog(null, "X osa mora biti broj", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						} else if (!isNumeric(txtY.getText())) {
							JOptionPane.showMessageDialog(null, "Y osa mora biti broj", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						} else if (isNumeric(txtX.getText()) && isNumeric(txtY.getText())) {
							int x = Integer.parseInt(txtX.getText());
							int y = Integer.parseInt(txtY.getText());
							if (x < 0) {
								JOptionPane.showMessageDialog(null, "X osa mora biti veca od 0", "ERROR",
										JOptionPane.ERROR_MESSAGE);
							} else if (y < 0) {
								JOptionPane.showMessageDialog(null, "Y osa mora biti veca od 0", "ERROR",
										JOptionPane.ERROR_MESSAGE);
							} else {
								tacka = new Point(x, y);
								if (colorChanged) {
									boja = btnColor.getBackground();
									tacka.setColor(boja);
								}
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

	public Color getColor() {
		return this.boja;
	}

	public Point getPoint() {
		return this.tacka;
	}

}
