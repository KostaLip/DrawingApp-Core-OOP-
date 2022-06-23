package stack;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Rectangle;
import javax.swing.JButton;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class FrameStack extends JFrame {

	JList stackLst = new JList();
	private JPanel contentPane;
	private DefaultListModel<Circle> dlm = new DefaultListModel<Circle>();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameStack frame = new FrameStack();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrameStack() {
		setTitle("Kosta Bjelogrlic IT31/2021");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 338, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel pnlCenter = new JPanel();
		pnlCenter.setBackground(Color.PINK);
		contentPane.add(pnlCenter, BorderLayout.CENTER);

		JScrollPane scrlPnlCenter = new JScrollPane();
		GroupLayout glPnlCenter = new GroupLayout(pnlCenter);
		glPnlCenter.setHorizontalGroup(glPnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(glPnlCenter.createSequentialGroup().addGap(50)
						.addComponent(scrlPnlCenter, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(50, Short.MAX_VALUE)));
		glPnlCenter.setVerticalGroup(glPnlCenter.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				glPnlCenter.createSequentialGroup().addContainerGap()
						.addComponent(scrlPnlCenter, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
						.addContainerGap()));

		stackLst.setModel(dlm);
		scrlPnlCenter.setViewportView(stackLst);
		pnlCenter.setLayout(glPnlCenter);

		JPanel pnlSouth = new JPanel();
		contentPane.add(pnlSouth, BorderLayout.SOUTH);

		JButton addBtn = new JButton("ADD");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int br = 0;
				DialogStack dlgStack = new DialogStack();
				dlgStack.setVisible(true);

				if (dlgStack.getCircle() != null) {
					dlm.add(br, dlgStack.getCircle());
				}
			}
		});

		JButton deleteBtn = new JButton("DELETE");
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!dlm.isEmpty()) {
					dlm.removeElementAt(0);
				} else {
					JOptionPane.showMessageDialog(null, "STACK IS EMPTY", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		GroupLayout glPnlSouth = new GroupLayout(pnlSouth);
		glPnlSouth.setHorizontalGroup(glPnlSouth.createParallelGroup(Alignment.LEADING)
				.addGroup(glPnlSouth.createSequentialGroup().addGap(48).addComponent(addBtn)
						.addPreferredGap(ComponentPlacement.RELATED, 101, Short.MAX_VALUE).addComponent(deleteBtn)
						.addGap(43)));
		glPnlSouth.setVerticalGroup(glPnlSouth.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				glPnlSouth.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(glPnlSouth.createParallelGroup(Alignment.BASELINE).addComponent(addBtn)
								.addComponent(deleteBtn))));
		pnlSouth.setLayout(glPnlSouth);
	}
}
