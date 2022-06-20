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

public class FrameSort extends JFrame {

	private JPanel contentPane;
	private ArrayList<Rectangle> arrLst = new ArrayList<Rectangle>();
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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel pnlCenter = new JPanel();
		contentPane.add(pnlCenter, BorderLayout.CENTER);
		JScrollPane scrlPaneSort = new JScrollPane();

		GroupLayout gl_pnlCenter = new GroupLayout(pnlCenter);
		gl_pnlCenter.setHorizontalGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup().addGap(53)
						.addComponent(scrlPaneSort, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(63, Short.MAX_VALUE)));
		gl_pnlCenter.setVerticalGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_pnlCenter.createSequentialGroup().addContainerGap()
						.addComponent(scrlPaneSort, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE).addContainerGap()));

		sortLst.setModel(dlm);
		scrlPaneSort.setViewportView(sortLst);
		pnlCenter.setLayout(gl_pnlCenter);

		JPanel pnlSouth = new JPanel();
		contentPane.add(pnlSouth, BorderLayout.SOUTH);

		JButton addBtn = new JButton("ADD");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogSort dlgSort = new DialogSort();
				dlgSort.setVisible(true);
				if (dlgSort.getRectangle() != null) {
					arrLst.add(dlgSort.getRectangle());
				}
				arrLst.sort(null);
				sortLst.setModel(sort());
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
				glPnlSouth.createParallelGroup(Alignment.LEADING).addGroup(glPnlSouth.createSequentialGroup().addGap(46)
						.addComponent(addBtn).addGap(54).addComponent(btnClose).addContainerGap(61, Short.MAX_VALUE)));
		glPnlSouth.setVerticalGroup(glPnlSouth.createParallelGroup(Alignment.TRAILING)
				.addGroup(glPnlSouth.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(glPnlSouth.createParallelGroup(Alignment.BASELINE).addComponent(addBtn)
								.addComponent(btnClose))));
		pnlSouth.setLayout(glPnlSouth);
	}

	private DefaultListModel<Rectangle> sort() {
		Iterator<Rectangle> it = arrLst.iterator();
		DefaultListModel<Rectangle>dlm=new DefaultListModel<Rectangle>();
		while(it.hasNext()) {
			dlm.addElement(it.next());
		}
		return dlm;
	}
}
