package geometry;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Drawing extends JPanel {

	public static void main(String args[]) {
		JFrame frame = new JFrame("Drawing");
		frame.setSize(800, 600);
		Drawing drawingPanel = new Drawing();
		frame.getContentPane().add(drawingPanel);
		frame.setVisible(true);
	}

	public void paint(Graphics g) {
		Point p = new Point(500, 600);
		p.draw(g);
		g.setColor(Color.red);
		Line l = new Line(new Point(100, 200), new Point(300, 400));
		l.draw(g);
		g.setColor(Color.black);
		Donut d = new Donut(new Point(350, 450), 70, 50, true);
		d.draw(g);
		g.setColor(Color.ORANGE);
		Rectangle rec=new Rectangle(new Point(200,300,true),80,90);
		rec.draw(g);
	}
}
