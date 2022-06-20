package sort;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.Group;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import geometry.Rectangle;
import java.awt.Color;

public class FrameSort extends JFrame {

	private JPanel contentPane;
	private ArrayList<Rectangle> recLst = new ArrayList<Rectangle>();
	private DefaultListModel<Rectangle> dlm = new DefaultListModel<Rectangle>();
	JList sortLst = new JList();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameSort frame = new FrameSort();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameSort() {
		setTitle("Kosta Bjelogrlic IT31/2021");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel pnlCenter = new JPanel();
		pnlCenter.setBackground(Color.PINK);
		contentPane.add(pnlCenter, BorderLayout.CENTER);
		JScrollPane scrlPaneSort = new JScrollPane();

		GroupLayout glPnlCenter = new GroupLayout(pnlCenter);
		glPnlCenter.setHorizontalGroup(glPnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(glPnlCenter.createSequentialGroup().addGap(60)
						.addComponent(scrlPaneSort, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(60, Short.MAX_VALUE)));
		glPnlCenter.setVerticalGroup(glPnlCenter.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				glPnlCenter.createSequentialGroup().addContainerGap()
						.addComponent(scrlPaneSort, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE).addContainerGap()));

		sortLst.setModel(dlm);
		scrlPaneSort.setViewportView(sortLst);
		pnlCenter.setLayout(glPnlCenter);

		JPanel pnlSouth = new JPanel();
		contentPane.add(pnlSouth, BorderLayout.SOUTH);

		JButton addBtn = new JButton("ADD");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogSort dlgSort = new DialogSort();
				dlgSort.setVisible(true);
				if (dlgSort.getRectangle() != null) {
					recLst.add(dlgSort.getRectangle());
				}
				recLst.sort(null);
				sortLst.setModel(sortRects());
			}
		});
		JButton btnClose = new JButton("CLOSE");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
		GroupLayout glPnlSouth = new GroupLayout(pnlSouth);
		glPnlSouth.setHorizontalGroup(
				glPnlSouth.createParallelGroup(Alignment.LEADING).addGroup(glPnlSouth.createSequentialGroup().addGap(60)
						.addComponent(addBtn).addGap(60).addComponent(btnClose).addContainerGap(60, Short.MAX_VALUE)));
		glPnlSouth.setVerticalGroup(glPnlSouth.createParallelGroup(Alignment.TRAILING)
				.addGroup(glPnlSouth.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(glPnlSouth.createParallelGroup(Alignment.BASELINE).addComponent(addBtn)
								.addComponent(btnClose))));
		pnlSouth.setLayout(glPnlSouth);
	}

	private DefaultListModel<Rectangle> sortRects() {
		Iterator<Rectangle> it = recLst.iterator();
		DefaultListModel<Rectangle> dlm = new DefaultListModel<Rectangle>();
		while (it.hasNext()) {
			dlm.addElement(it.next());
		}
		return dlm;
	}
}
