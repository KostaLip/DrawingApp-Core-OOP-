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
	int br;
	private Shape selectedShape;

	public Drawing() {
			setBackground(Color.WHITE);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Iterator<Shape>it=shapes.iterator();
		while(it.hasNext()) {
			Shape sh=it.next();
			sh.draw(g);
		}
	}
	
	public void addShape(Shape sh) {
		shapes.add(sh);
		repaint();
	}

	public ArrayList<Shape> getShapes(){
		return shapes;
	}
	
	public void select(int x,int y) {
		for (br = shapes.size()-1; br >= 0; br--) {
			shapes.get(br).setSelected(false);
			repaint();
			if (shapes.get(br).contains(x, y)) {
				shapes.get(br).setSelected(true);
				repaint();
				return;
			}
		}
	}
	
	public Shape getSelectedShape() {
		return selectedShape;
	}
	
	public boolean isShapesEmpty() {
		return shapes.isEmpty();
	}
}
