package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import gui.Drawing;
import geometry.Point;
import geometry.Shape;

import java.awt.GridBagLayout;
import javax.swing.JToggleButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Paint extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	Border blackline = BorderFactory.createLineBorder(Color.black);
	private ArrayList<Shape> shapes = new ArrayList<Shape>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Paint frame = new Paint();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @return
	 */
	public Paint() {
		setTitle("Paint");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 865, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel pnlBtns = new JPanel();
		pnlBtns.setBackground(Color.PINK);
		contentPane.add(pnlBtns, BorderLayout.NORTH);
		GridBagLayout gbl_pnlBtns = new GridBagLayout();
		gbl_pnlBtns.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_pnlBtns.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_pnlBtns.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_pnlBtns.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		pnlBtns.setLayout(gbl_pnlBtns);

		JLabel lblShapes = new JLabel("Shapes");
		GridBagConstraints gbc_lblShapes = new GridBagConstraints();
		gbc_lblShapes.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblShapes.insets = new Insets(0, 0, 5, 5);
		gbc_lblShapes.gridx = 0;
		gbc_lblShapes.gridy = 0;
		pnlBtns.add(lblShapes, gbc_lblShapes);
		lblShapes.setPreferredSize(new Dimension(140, 50));

		JToggleButton tglBtnPoint = new JToggleButton("Point");
		tglBtnPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DlgPoint dlgP = new DlgPoint();
				dlgP.setVisible(true);
			}
		});
		buttonGroup.add(tglBtnPoint);
		tglBtnPoint.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_tglBtnPoint = new GridBagConstraints();
		gbc_tglBtnPoint.insets = new Insets(0, 0, 5, 5);
		gbc_tglBtnPoint.gridx = 1;
		gbc_tglBtnPoint.gridy = 0;
		pnlBtns.add(tglBtnPoint, gbc_tglBtnPoint);
		tglBtnPoint.setPreferredSize(new Dimension(100, 50));

		JToggleButton tglBtnLine = new JToggleButton("Line");
		tglBtnLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DlgLine dlgL=new DlgLine();
				dlgL.setVisible(true);
			}
		});
		buttonGroup.add(tglBtnLine);
		tglBtnLine.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_tglBtnLine = new GridBagConstraints();
		gbc_tglBtnLine.insets = new Insets(0, 0, 5, 5);
		gbc_tglBtnLine.gridx = 4;
		gbc_tglBtnLine.gridy = 0;
		pnlBtns.add(tglBtnLine, gbc_tglBtnLine);
		tglBtnLine.setPreferredSize(new Dimension(100, 50));

		JToggleButton tglBtnRectangle = new JToggleButton("Rectangle");
		tglBtnRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgRectangle dlgR = new DlgRectangle();
				dlgR.setVisible(true);
			}
		});
		buttonGroup.add(tglBtnRectangle);
		tglBtnRectangle.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_tglBtnRectangle = new GridBagConstraints();
		gbc_tglBtnRectangle.insets = new Insets(0, 0, 5, 5);
		gbc_tglBtnRectangle.gridx = 7;
		gbc_tglBtnRectangle.gridy = 0;
		pnlBtns.add(tglBtnRectangle, gbc_tglBtnRectangle);
		tglBtnRectangle.setPreferredSize(new Dimension(100, 50));

		JToggleButton tglBtnCircle = new JToggleButton("Circle");
		tglBtnCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgCircle dlgC = new DlgCircle();
				dlgC.setVisible(true);
			}
		});
		buttonGroup.add(tglBtnCircle);
		tglBtnCircle.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_tglBtnCircle = new GridBagConstraints();
		gbc_tglBtnCircle.insets = new Insets(0, 0, 5, 5);
		gbc_tglBtnCircle.gridx = 10;
		gbc_tglBtnCircle.gridy = 0;
		pnlBtns.add(tglBtnCircle, gbc_tglBtnCircle);
		tglBtnCircle.setPreferredSize(new Dimension(100, 50));

		JToggleButton tglBtnDonut = new JToggleButton("Donut");
		tglBtnDonut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgDonut dlgD = new DlgDonut();
				dlgD.setVisible(true);
			}
		});
		buttonGroup.add(tglBtnDonut);
		tglBtnDonut.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_tglBtnDonut = new GridBagConstraints();
		gbc_tglBtnDonut.insets = new Insets(0, 0, 5, 0);
		gbc_tglBtnDonut.gridx = 13;
		gbc_tglBtnDonut.gridy = 0;
		pnlBtns.add(tglBtnDonut, gbc_tglBtnDonut);
		tglBtnDonut.setPreferredSize(new Dimension(100, 50));

		JLabel lblOptions = new JLabel("Options");
		GridBagConstraints gbc_lblOptions = new GridBagConstraints();
		gbc_lblOptions.anchor = GridBagConstraints.WEST;
		gbc_lblOptions.insets = new Insets(0, 0, 5, 5);
		gbc_lblOptions.gridx = 0;
		gbc_lblOptions.gridy = 1;
		pnlBtns.add(lblOptions, gbc_lblOptions);

		JToggleButton tglBtnSelect = new JToggleButton("Select");
		tglBtnSelect.setBackground(Color.GRAY);
		buttonGroup.add(tglBtnSelect);
		GridBagConstraints gbc_tglBtnSelect = new GridBagConstraints();
		gbc_tglBtnSelect.anchor = GridBagConstraints.NORTH;
		gbc_tglBtnSelect.insets = new Insets(0, 0, 5, 5);
		gbc_tglBtnSelect.gridx = 4;
		gbc_tglBtnSelect.gridy = 1;
		pnlBtns.add(tglBtnSelect, gbc_tglBtnSelect);
		tglBtnSelect.setPreferredSize(new Dimension(110, 30));

		JToggleButton tglBtnDelete = new JToggleButton("Delete");
		tglBtnDelete.setBackground(Color.GRAY);
		buttonGroup.add(tglBtnDelete);
		GridBagConstraints gbc_tglBtnDelete = new GridBagConstraints();
		gbc_tglBtnDelete.insets = new Insets(0, 0, 5, 5);
		gbc_tglBtnDelete.gridx = 7;
		gbc_tglBtnDelete.gridy = 1;
		pnlBtns.add(tglBtnDelete, gbc_tglBtnDelete);
		tglBtnDelete.setPreferredSize(new Dimension(110, 30));

		JToggleButton tglBtnEdit = new JToggleButton("Edit");
		tglBtnEdit.setBackground(Color.GRAY);
		buttonGroup.add(tglBtnEdit);
		GridBagConstraints gbc_tglBtnEdit = new GridBagConstraints();
		gbc_tglBtnEdit.insets = new Insets(0, 0, 5, 5);
		gbc_tglBtnEdit.gridx = 10;
		gbc_tglBtnEdit.gridy = 1;
		pnlBtns.add(tglBtnEdit, gbc_tglBtnEdit);
		tglBtnEdit.setPreferredSize(new Dimension(110, 30));

		JPanel drawingPanel = new JPanel();
		contentPane.add(new Drawing(), BorderLayout.CENTER);
		drawingPanel.setBorder(blackline);
	}
}
