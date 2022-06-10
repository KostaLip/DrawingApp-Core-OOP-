package gui;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;

import geometry.Point;
import geometry.Shape;
import gui.Paint;

public class Drawing extends JPanel {
	private Paint frame;
	private Point startPoint;
	private Shape selected;
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	
	public Drawing(Paint frame) {
		this.frame=frame;
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				shapes.add(new Point(e.getX(),e.getY()));
				repaint();
			}
		});
	}

	public void paint(Graphics g) {
		
		Iterator<Shape>it=shapes.iterator();
		while(it.hasNext()) {
			Shape s=it.next();
			s.draw(g);
		}
}}
