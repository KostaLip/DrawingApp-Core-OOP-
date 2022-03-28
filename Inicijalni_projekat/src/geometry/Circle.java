package geometry;

public class Circle {
	private Point center;
	private int radius;
	private boolean selected;

	public double area() {
		return radius * getRadius() * Math.PI;
	}

	public double circumference() {
		return 2 * radius * Math.PI;
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public boolean isSelected() {
		return this.selected;
	}
}
