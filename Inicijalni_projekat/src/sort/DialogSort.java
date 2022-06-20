package sort;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import geometry.Point;
import geometry.Rectangle;

public class DialogSort extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnOk;
	private JButton btnCancel;
	private JTextField txtX;
	private JTextField txtHeight;
	private JTextField txtY;
	private JTextField txtWidth;
	private Rectangle rectangle = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogSort dialog = new DialogSort();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogSort() {
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblXCoordinate = new JLabel("X COORDINATE:");
		JLabel lblYCoordinate = new JLabel("Y COORDINATE:");
		JLabel lblWidth = new JLabel("WIDTH:");
		JLabel lblHeight = new JLabel("HEIGHT:");
		txtX = new JTextField();
		txtX.setColumns(15);
		txtY = new JTextField();
		txtY.setColumns(15);
		txtWidth = new JTextField();
		txtWidth.setColumns(15);
		txtHeight = new JTextField();
		txtHeight.setColumns(15);

		GroupLayout glContentPanel = new GroupLayout(contentPanel);
		glContentPanel.setHorizontalGroup(glContentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(glContentPanel.createSequentialGroup().addContainerGap()
						.addGroup(glContentPanel.createParallelGroup(Alignment.LEADING).addComponent(lblXCoordinate)
								.addComponent(lblYCoordinate).addComponent(lblWidth).addComponent(lblHeight))
						.addGap(32)
						.addGroup(glContentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txtY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txtWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txtHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap(64, Short.MAX_VALUE)));
		glContentPanel.setVerticalGroup(glContentPanel.createParallelGroup(Alignment.LEADING).addGroup(glContentPanel
				.createSequentialGroup().addContainerGap()
				.addGroup(glContentPanel
						.createParallelGroup(Alignment.BASELINE).addComponent(lblXCoordinate).addComponent(txtX,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(glContentPanel
						.createParallelGroup(Alignment.BASELINE).addComponent(lblYCoordinate).addComponent(txtY,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(glContentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblWidth).addComponent(
						txtWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(glContentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblHeight).addComponent(
						txtHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(82, Short.MAX_VALUE)));

		contentPanel.setLayout(glContentPanel);
		{
			JPanel btnPane = new JPanel();
			getContentPane().add(btnPane, BorderLayout.SOUTH);
			{
				btnOk = new JButton("ADD");
				btnOk.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int x = Integer.parseInt(txtX.getText());
						int y = Integer.parseInt(txtY.getText());
						int width = Integer.parseInt(txtWidth.getText());
						int height = Integer.parseInt(txtHeight.getText());
						rectangle = new Rectangle(new Point(x, y), height, width);
						dispose();

					}
				});
				btnOk.setActionCommand("OK");
				getRootPane().setDefaultButton(btnOk);
			}
			{
				btnCancel = new JButton("CANCEL");
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();

					}
				});
				btnCancel.setActionCommand("CANCEL");
			}
			GroupLayout glButtonPane = new GroupLayout(btnPane);
			glButtonPane.setHorizontalGroup(
					glButtonPane.createParallelGroup(Alignment.LEADING).addGroup(glButtonPane.createSequentialGroup()
							.addGap(47).addComponent(btnOk).addGap(76).addComponent(btnCancel).addGap(189)));
			glButtonPane.setVerticalGroup(glButtonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(glButtonPane.createSequentialGroup().addGap(5).addGroup(glButtonPane
							.createParallelGroup(Alignment.BASELINE).addComponent(btnOk).addComponent(btnCancel))));
			btnPane.setLayout(glButtonPane);
		}
	}

	public Rectangle getRectangle() {
		return rectangle;
	}

	public void setRectangle(Rectangle r) {
		txtX.setText("" + r.getUpperLeftPoint().getX());
		txtY.setText("" + r.getUpperLeftPoint().getY());
		txtWidth.setText("" + r.getWidth());
		txtHeight.setText("" + r.getHeight());
	}

}
