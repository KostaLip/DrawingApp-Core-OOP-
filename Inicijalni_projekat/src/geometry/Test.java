package geometry;

public class Test {

	public static void main(String[] args) {
		Point p = new Point();
		p.setX(22);
		p.setY(21);
		System.out.println("X koordinata je: " + p.getX());
		System.out.println("Y koordinata je: " + p.getY());
		System.out.println(p.distance(31, 43));
		Point p1 = new Point();
		p1.setX(20);
		p1.setY(30);
		Line l1 = new Line();
		System.out.println(l1.isSelected());
		// System.out.println(l1.getStartPoint().getX());
		// System.out.println(l1.getEndPoint().getY());
		l1.setStartPoint(p);
		l1.setEndPoint(p1);
		System.out.println(l1.getStartPoint().getX());
		System.out.println(l1.getEndPoint().getY());
		System.out.println(l1.length());
		Rectangle r1 = new Rectangle();
		Circle c1 = new Circle();
		p.setX(p1.getY());
		l1.getEndPoint().setY(23);
		l1.getStartPoint().setX(l1.getEndPoint().getY());
		l1.getEndPoint().setX((int) (l1.length() - (l1.getStartPoint().getX()) + l1.getStartPoint().getY()));
		r1.setUpperLeftPoint(p);
		r1.getUpperLeftPoint().setX(10);
		r1.getUpperLeftPoint().setY(15);
		c1.setCenter(r1.getUpperLeftPoint());
		c1.getCenter().setX(r1.area() - l1.getStartPoint().getY());
		// Vezbe 4
				/*
				 * 1.Postaviti koordinatu x centra ranije kreiranog kruga k na vrednost zbira
				 * vrednosti poluprecnika kruga k i vrednosti koja predstavlja udaljenost
				 * pocetne i krajnje tacke prethodno kreirane linije lin (NE duzine). Sve
				 * objekte kreirati samostalno.
				 */
		c1.getCenter().setX(c1.getRadius()+(int)l1.getStartPoint().distance(l1.getEndPoint().getX(), l1.getEndPoint().getY()));
		Point p2=new Point();
		p2.setX(10);
		p2.setY(15);
		Point p3=new Point(10,15);
		System.out.println("Koordinata X je: "+p3.getX());
		System.out.println("Koordinata Y je: "+p3.getY());
		System.out.println("p3:"+p3);
		System.out.println("p3:"+p3.toString());
		
		
		Point p5=new Point(10,15);
		Point p6=new Point(10,15);
		System.out.println(p5==p6);
		System.out.println(p5.equals(p6));
	}
	
}
