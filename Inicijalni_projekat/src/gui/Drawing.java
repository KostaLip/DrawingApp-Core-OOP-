package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;
import gui.Paint;

public class Drawing extends JPanel {
	
	private ArrayList<Shape>shapes=new ArrayList<Shape>();

	public Drawing() {
			addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					Point p=new Point(e.getX(),e.getY());
					Circle c=new Circle(p,12);
					shapes.add(c);
					repaint();
				}
			});
	}
	
	public void paint(Graphics g) {
		Iterator<Shape>it=shapes.iterator();
		while(it.hasNext()) {
			Shape sh=it.next();
			sh.draw(g);
		}
	}

}
