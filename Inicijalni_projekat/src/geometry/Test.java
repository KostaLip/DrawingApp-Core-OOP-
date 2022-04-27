package geometry;

public class Test {

	public static void main(String[] args) {
		// Vezbe 2
		int i = 0;
		System.out.println(i);
		Point p = new Point();
		// System.out.println(point1.x);
		// point1.x=10;
		// System.out.println(point1.x);

		p.setX(10);
		System.out.println("X koordinata point1: " + p.getX());
		p.setY(20);
		System.out.println("Y koordinata point1: " + p.getY());

		p.distance(15, 20);

		// Vezbe 3
		// Point p -> x=10, y=20
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

		// 1. Inicijalizovati x koordinatu tacke p
		// na vrednost y koordinate tacke p1
		p.setX(p1.getY());

		// 2. Postaviti za pocetnu tacku linije l1 tacku p,
		// za krajnju tacku linije l1 tacku p1

		// gore je napisano

		// 3. Postaviti y koordinatu krajnje tacke l1 na 23

		l1.getEndPoint().setY(23);

		// 4. Inicijalizovati x koordinatu pocetne tacke linije l1
		// na vrednost y koordinate krajnje tacke linije l1
		l1.getStartPoint().setX(l1.getEndPoint().getY());

		// 5. Postaviti x koordinatu krajnje tacke l1 na vrednost
		// duzine linije l1 umanjene za vrednost zbira x i y
		// koordinate pocetne tacke linije l1
		l1.getEndPoint().setX((int) l1.length() - (l1.getStartPoint().getX() + l1.getStartPoint().getY()));

		// 6. Postaviti x koordinatu tacke gore levo pravougaonika
		// r1 na vrednost 10 i y koordinatu na vrednost 15
		r1.setUpperLeftPoint(p);
		r1.getUpperLeftPoint().setX(10);
		r1.getUpperLeftPoint().setY(15);

		// 7. Postaviti centar kruga c1 na koordinate tacke
		// gore levo od r1
		c1.setCenter(r1.getUpperLeftPoint());

		// 8. Postaviti x koordinatu centra kruga c1 na vrednost razlike
		// povrsine pravougaonika r1 i y koordinate pocetne tacke linije l1
		c1.getCenter().setX(r1.area() - l1.getStartPoint().getY());

		// Vezbe 4
		/*
		 * 1.Postaviti koordinatu x centra ranije kreiranog kruga k na vrednost zbira
		 * vrednosti poluprecnika kruga k i vrednosti koja predstavlja udaljenost
		 * pocetne i krajnje tacke prethodno kreirane linije lin (NE duzine). Sve
		 * objekte kreirati samostalno.
		 */

		System.out.println("Vezbe 4");
		Circle k = new Circle();
		Line lin = new Line();
		lin.setStartPoint(p);
		lin.setEndPoint(p1);
		k.setCenter(p);
		k.getCenter().setX((int) (k.getRadius()
				+ (lin.getStartPoint().distance(lin.getEndPoint().getX(), lin.getEndPoint().getY()))));

		/*
		 * Point p4=new Point(); p4.setX(10); p4.setY(15);
		 */
		Point p4 = new Point(10, 15);
		System.out.println("X koordinata p4: " + p4.getX());
		// kada zelim promenu vrednosti mogu pozvati setX()
		p4.setX(20);
		System.out.println("X koordinata p4: " + p4.getX());

		// toString() je redefinisan za sad samo u Point
		System.out.println("p4: " + p4);
		System.out.println("p4: " + p4.toString());
		System.out.println("lin: " + lin.toString());

		// prenos po vrednosti i referenci i poredjenje objekata
		Point p5 = new Point(10, 15);
		Point p6 = new Point(10, 15);
		System.out.println(p5 == p6);
		System.out.println(p5.equals(p6));

		p5 = p6;

		System.out.println(p5 == p6);
		System.out.println(p5.equals(p6));

		// ZADATAK - testirati konstruktore, toString() i equals(...) metode
		Point clickPoint = new Point(10, 15);
		System.out.println(p5.contains(clickPoint));
		System.out.println(lin.contains(clickPoint));
		System.out.println(p5.contains(clickPoint));
		Donut d1 = new Donut(p5, 20, 10, true);
		Donut d2 = new Donut(p5, 15, 10, true);
		System.out.println(d1.equals(d2));
	}
}
