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
		c1.getCenter().setX(r1.area()-l1.getStartPoint().getY());
	}

}
