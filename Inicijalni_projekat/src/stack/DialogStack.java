package stack;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Point;
import geometry.Rectangle;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;

public class DialogStack extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnOk;
	private JButton btnCancel;
	private Circle circle = null;
	private JLabel lblX;
	private JLabel lblY;
	private JLabel lblRadius;
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtRadius;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogStack dialog = new DialogStack();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DialogStack() {
		setTitle("ADD CIRCLE");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 306, 250);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.PINK);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);

		lblX = new JLabel("X coordinate of center");
		GridBagConstraints gbc_lblX = new GridBagConstraints();
		gbc_lblX.anchor = GridBagConstraints.WEST;
		gbc_lblX.insets = new Insets(0, 0, 5, 5);
		gbc_lblX.gridx = 1;
		gbc_lblX.gridy = 0;
		contentPanel.add(lblX, gbc_lblX);

		txtX = new JTextField();
		GridBagConstraints gbc_txtX = new GridBagConstraints();
		gbc_txtX.insets = new Insets(0, 0, 5, 0);
		gbc_txtX.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtX.gridx = 3;
		gbc_txtX.gridy = 0;
		contentPanel.add(txtX, gbc_txtX);
		txtX.setColumns(10);

		lblY = new JLabel("Y coordinate of center");
		GridBagConstraints gbc_lblY = new GridBagConstraints();
		gbc_lblY.insets = new Insets(0, 0, 5, 5);
		gbc_lblY.gridx = 1;
		gbc_lblY.gridy = 1;
		contentPanel.add(lblY, gbc_lblY);

		txtY = new JTextField();
		GridBagConstraints gbc_txtY = new GridBagConstraints();
		gbc_txtY.insets = new Insets(0, 0, 5, 0);
		gbc_txtY.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtY.gridx = 3;
		gbc_txtY.gridy = 1;
		contentPanel.add(txtY, gbc_txtY);
		txtY.setColumns(10);

		lblRadius = new JLabel("RADIUS");
		GridBagConstraints gbc_lblRadius = new GridBagConstraints();
		gbc_lblRadius.insets = new Insets(0, 0, 5, 5);
		gbc_lblRadius.gridx = 1;
		gbc_lblRadius.gridy = 2;
		contentPanel.add(lblRadius, gbc_lblRadius);

		txtRadius = new JTextField();
		GridBagConstraints gbc_txtRadius = new GridBagConstraints();
		gbc_txtRadius.insets = new Insets(0, 0, 5, 0);
		gbc_txtRadius.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRadius.gridx = 3;
		gbc_txtRadius.gridy = 2;
		contentPanel.add(txtRadius, gbc_txtRadius);
		txtRadius.setColumns(10);
		{
			JPanel btnPane = new JPanel();
			getContentPane().add(btnPane, BorderLayout.SOUTH);
			{
				btnOk = new JButton("ADD");
				btnOk.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (txtX.getText().isEmpty() || txtY.getText().isEmpty() || txtRadius.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "YOU MUST ENTER ALL DATA", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						} else if (!isNumeric(txtX.getText())) {
							JOptionPane.showMessageDialog(null, "X COORDINATE MUST BE A NUMBER", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						} else if (!isNumeric(txtY.getText())) {
							JOptionPane.showMessageDialog(null, "Y COORDINATE MUST BE A NUMBER", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						} else if (!isNumeric(txtRadius.getText())) {
							JOptionPane.showMessageDialog(null, "RADIUS MUST BE A NUMBER", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						} else if (isNumeric(txtX.getText()) && isNumeric(txtY.getText())
								&& isNumeric(txtRadius.getText())) {
							int x = Integer.parseInt(txtX.getText());
							int y = Integer.parseInt(txtY.getText());
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
								circle = new Circle(new Point(x, y), radius);
								dispose();
							}
						}
					}
				});
				btnOk.setActionCommand("OK");
				getRootPane().setDefaultButton(btnOk);
			}
			{
				btnCancel = new JButton("CANCEL");
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				btnCancel.setActionCommand("Cancel");
			}
			GroupLayout glBtnPane = new GroupLayout(btnPane);
			glBtnPane.setHorizontalGroup(
					glBtnPane.createParallelGroup(Alignment.LEADING).addGroup(glBtnPane.createSequentialGroup()
							.addGap(42).addComponent(btnOk).addGap(69).addComponent(btnCancel).addGap(68)));
			glBtnPane.setVerticalGroup(glBtnPane.createParallelGroup(Alignment.LEADING)
					.addGroup(glBtnPane.createSequentialGroup().addGap(11).addGroup(glBtnPane
							.createParallelGroup(Alignment.BASELINE).addComponent(btnOk).addComponent(btnCancel))));
			btnPane.setLayout(glBtnPane);
		}
	}

	public Circle getCircle() {
		return circle;
	}

	public void setCircle(Circle crc) {
		txtX.setText("" + crc.getCenter().getX());
		txtY.setText("" + crc.getCenter().getY());
		txtRadius.setText("" + crc.getRadius());
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
}
