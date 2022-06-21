package stack;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
	private Rectangle rectangle = null;
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtWidth;
	private JTextField txtHeight;

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
		setTitle("ADD RECTANGLE");
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

		JLabel lblX = new JLabel("X coordinate");
		GridBagConstraints gbc_lblX = new GridBagConstraints();
		gbc_lblX.insets = new Insets(0, 0, 5, 5);
		gbc_lblX.anchor = GridBagConstraints.SOUTHWEST;
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

		JLabel lblY = new JLabel("Y coordinate");
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

		JLabel lblWidth = new JLabel("Width");
		GridBagConstraints gbc_lblWidth = new GridBagConstraints();
		gbc_lblWidth.insets = new Insets(0, 0, 5, 5);
		gbc_lblWidth.gridx = 1;
		gbc_lblWidth.gridy = 2;
		contentPanel.add(lblWidth, gbc_lblWidth);

		txtWidth = new JTextField();
		GridBagConstraints gbc_txtWidth = new GridBagConstraints();
		gbc_txtWidth.insets = new Insets(0, 0, 5, 0);
		gbc_txtWidth.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtWidth.gridx = 3;
		gbc_txtWidth.gridy = 2;
		contentPanel.add(txtWidth, gbc_txtWidth);
		txtWidth.setColumns(10);

		JLabel lblHeight = new JLabel("Height");
		GridBagConstraints gbc_lblHeight = new GridBagConstraints();
		gbc_lblHeight.insets = new Insets(0, 0, 0, 5);
		gbc_lblHeight.gridx = 1;
		gbc_lblHeight.gridy = 3;
		contentPanel.add(lblHeight, gbc_lblHeight);

		txtHeight = new JTextField();
		GridBagConstraints gbc_txtHeight = new GridBagConstraints();
		gbc_txtHeight.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtHeight.gridx = 3;
		gbc_txtHeight.gridy = 3;
		contentPanel.add(txtHeight, gbc_txtHeight);
		txtHeight.setColumns(10);
		{
			JPanel btnPane = new JPanel();
			getContentPane().add(btnPane, BorderLayout.SOUTH);
			{
				btnOk = new JButton("ADD");
				btnOk.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (txtX.getText().isEmpty() || txtY.getText().isEmpty() || txtWidth.getText().isEmpty()
								|| txtHeight.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "MORATE UNIJETI SVE PODATKE", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						} else if (!isNumeric(txtX.getText())) {
							JOptionPane.showMessageDialog(null, "X osa mora biti broj", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						} else if (!isNumeric(txtY.getText())) {
							JOptionPane.showMessageDialog(null, "Y osa mora biti broj", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						} else if (!isNumeric(txtWidth.getText())) {
							JOptionPane.showMessageDialog(null, "Sirina mora biti broj", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						} else if (!isNumeric(txtHeight.getText())) {
							JOptionPane.showMessageDialog(null, "Visina mora biti broj", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						} else if (isNumeric(txtX.getText()) && isNumeric(txtY.getText())
								&& isNumeric(txtWidth.getText()) && isNumeric(txtHeight.getText())) {
							int x = Integer.parseInt(txtX.getText());
							int y = Integer.parseInt(txtY.getText());
							int width = Integer.parseInt(txtWidth.getText());
							int height = Integer.parseInt(txtHeight.getText());
							if (x < 0) {
								JOptionPane.showMessageDialog(null, "X koordinata mora biti veca od 0", "ERROR",
										JOptionPane.ERROR_MESSAGE);
							} else if (y < 0) {
								JOptionPane.showMessageDialog(null, "Y koordinata mora biti veca od 0", "ERROR",
										JOptionPane.ERROR_MESSAGE);
							} else if (width <= 0) {
								JOptionPane.showMessageDialog(null, "Sirina mora biti strogo veca od 0", "ERROR",
										JOptionPane.ERROR_MESSAGE);
							} else if (height <= 0) {
								JOptionPane.showMessageDialog(null, "Visina mora biti strogo veca od 0", "ERROR",
										JOptionPane.ERROR_MESSAGE);
							} else {
								rectangle = new Rectangle(new Point(x, y), width, height);
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

	public Rectangle getRectangle() {
		return rectangle;
	}

	public void setRectangle(Rectangle rect) {
		txtX.setText("" + rect.getUpperLeftPoint().getX());
		txtY.setText("" + rect.getUpperLeftPoint().getY());
		txtHeight.setText("" + rect.getHeight());
		txtWidth.setText("" + rect.getWidth());
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
