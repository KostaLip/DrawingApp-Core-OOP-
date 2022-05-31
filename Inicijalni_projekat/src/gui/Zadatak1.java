package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JToggleButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class Zadatak1 extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroupColor = new ButtonGroup();
	private JLabel lblCrvena;
	private JLabel lblPlava;
	private JLabel lblZuta;
	private DefaultListModel<String> dlm=new DefaultListModel<String>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Zadatak1 frame = new Zadatak1();
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
	public Zadatak1() {
		setTitle("Vezbe 9");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 631, 360);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlCenter = new JPanel();
		contentPane.add(pnlCenter, BorderLayout.CENTER);
		GridBagLayout gbl_pnlCenter = new GridBagLayout();
		gbl_pnlCenter.columnWidths = new int[]{113, 0, 0, 0};
		gbl_pnlCenter.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_pnlCenter.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlCenter.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlCenter.setLayout(gbl_pnlCenter);
		
		lblCrvena = new JLabel("Crvena boja");
		GridBagConstraints gbc_lblCrvena = new GridBagConstraints();
		gbc_lblCrvena.insets = new Insets(0, 0, 5, 5);
		gbc_lblCrvena.gridx = 1;
		gbc_lblCrvena.gridy = 0;
		pnlCenter.add(lblCrvena, gbc_lblCrvena);
		
		JToggleButton tglbtnCrvena = new JToggleButton("Crvena");
		tglbtnCrvena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblPlava.setForeground(Color.black);
				lblZuta.setForeground(Color.black);
				lblCrvena.setForeground(Color.green);
				dlm.addElement(lblCrvena.getText());
			}
		});
		buttonGroupColor.add(tglbtnCrvena);
		GridBagConstraints gbc_tglbtnCrvena = new GridBagConstraints();
		gbc_tglbtnCrvena.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnCrvena.fill = GridBagConstraints.HORIZONTAL;
		gbc_tglbtnCrvena.gridx = 0;
		gbc_tglbtnCrvena.gridy = 0;
		pnlCenter.add(tglbtnCrvena, gbc_tglbtnCrvena);
			
		JToggleButton tglbtnPlava = new JToggleButton("Plava");
		tglbtnPlava.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblCrvena.setForeground(Color.black);
				lblZuta.setForeground(Color.black);
				lblPlava.setForeground(Color.green);
				dlm.addElement(lblPlava.getText());
			}
		});
		buttonGroupColor.add(tglbtnPlava);
		GridBagConstraints gbc_tglbtnPlava = new GridBagConstraints();
		gbc_tglbtnPlava.fill = GridBagConstraints.HORIZONTAL;
		gbc_tglbtnPlava.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnPlava.gridx = 0;
		gbc_tglbtnPlava.gridy = 1;
		pnlCenter.add(tglbtnPlava, gbc_tglbtnPlava);
		
		lblPlava = new JLabel("Plava boja");
		GridBagConstraints gbc_lblPlava = new GridBagConstraints();
		gbc_lblPlava.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlava.gridx = 1;
		gbc_lblPlava.gridy = 1;
		pnlCenter.add(lblPlava, gbc_lblPlava);
		
		JToggleButton tglbtnZuta = new JToggleButton("Zuta");
		tglbtnZuta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblPlava.setForeground(Color.black);
				lblCrvena.setForeground(Color.black);
				lblZuta.setForeground(Color.green);
				dlm.addElement(lblZuta.getText());
			}
		});
		buttonGroupColor.add(tglbtnZuta);
		GridBagConstraints gbc_tglbtnZuta = new GridBagConstraints();
		gbc_tglbtnZuta.fill = GridBagConstraints.HORIZONTAL;
		gbc_tglbtnZuta.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnZuta.gridx = 0;
		gbc_tglbtnZuta.gridy = 2;
		pnlCenter.add(tglbtnZuta, gbc_tglbtnZuta);
		
		lblZuta = new JLabel("Zuta boja");
		GridBagConstraints gbc_lblZuta = new GridBagConstraints();
		gbc_lblZuta.insets = new Insets(0, 0, 5, 5);
		gbc_lblZuta.gridx = 1;
		gbc_lblZuta.gridy = 2;
		pnlCenter.add(lblZuta, gbc_lblZuta);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 3;
		pnlCenter.add(scrollPane, gbc_scrollPane);
		
		JList<String> list = new JList<String>();
		scrollPane.setViewportView(list);
		list.setModel(dlm);
		
		JLabel lblNaslov = new JLabel("Zadatak 1");
		lblNaslov.setForeground(Color.BLUE);
		lblNaslov.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNaslov.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNaslov, BorderLayout.NORTH);
		
		JButton btnKlik = new JButton("Klikni me");
		btnKlik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Antistres dugme :)",
						"Poruka korisniku", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		contentPane.add(btnKlik, BorderLayout.SOUTH);
	}

}
