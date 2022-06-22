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
import geometry.Point;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgCircle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	protected JTextArea txtCenterX = new JTextArea();
	protected JTextArea txtCenterY = new JTextArea();
	protected JTextArea txtRadius = new JTextArea();
	Circle krug = null;
	Color boja;
	private boolean colorChanged=true;
	JButton btnColor = new JButton("CHOSE COLOR");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgCircle dialog = new DlgCircle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgCircle() {
		setTitle("EDIT CIRCLE");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.PINK);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
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
			JScrollPane scrollTxtCenterX = new JScrollPane(txtCenterX);
			contentPanel.add(scrollTxtCenterX, gbc_txtCenterX);
			txtCenterX.setLineWrap(true);
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
			JScrollPane scrollTxtCenterY = new JScrollPane(txtCenterY);
			contentPanel.add(scrollTxtCenterY, gbc_txtCenterY);
			txtCenterY.setLineWrap(true);
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
			btnColor.setForeground(Color.WHITE);
			btnColor.setBackground(Color.BLACK);
			btnColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Color initialColor = Color.BLACK;
					Color color = JColorChooser.showDialog(null, "Select a color", initialColor);
					btnColor.setBackground(color);
					colorChanged = true;
				}
			});
			GridBagConstraints gbc_btnColor = new GridBagConstraints();
			gbc_btnColor.gridx = 1;
			gbc_btnColor.gridy = 3;
			contentPanel.add(btnColor, gbc_btnColor);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.PINK);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (txtCenterX.getText().isEmpty() || txtCenterY.getText().isEmpty()
								|| txtRadius.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "YOU MUST ENTER ALL DATA", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						} else if (!isNumeric(txtCenterX.getText())) {
							JOptionPane.showMessageDialog(null, "X COORDINATE MUST BE A NUMBER", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						} else if (!isNumeric(txtCenterY.getText())) {
							JOptionPane.showMessageDialog(null, "Y COORDINATE MUST BE A NUMBER", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						} else if (!isNumeric(txtRadius.getText())) {
							JOptionPane.showMessageDialog(null, "RADIUS MUST BE A NUMBER", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						} else if (isNumeric(txtCenterX.getText()) && isNumeric(txtCenterY.getText())
								&& isNumeric(txtRadius.getText())) {
							int x = Integer.parseInt(txtCenterX.getText());
							int y = Integer.parseInt(txtCenterY.getText());
							int radius = Integer.parseInt(txtRadius.getText());
							if (x < 0) {
								JOptionPane.showMessageDialog(null, "X COORDINATE MUST BE GREATER THAN 0", "ERROR",
										JOptionPane.ERROR_MESSAGE);
							} else if (y < 0) {
								JOptionPane.showMessageDialog(null, "Y COORDINATE MUST BE GREATER THAN 0", "ERROR",
										JOptionPane.ERROR_MESSAGE);
							} else if (radius <= 0) {
								JOptionPane.showMessageDialog(null, "RADIUS MUST BE STRICTLY GREATER THAN 0", "ERROR",
										JOptionPane.ERROR_MESSAGE);
							} else {
								Point center = new Point(x, y);
								krug = new Circle(center, radius);
								if (colorChanged) {
									boja = btnColor.getBackground();
									krug.setColor(boja);
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

	public Circle getCircle() {
		return krug;
	}

}
