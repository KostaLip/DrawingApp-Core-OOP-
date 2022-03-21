package geometry;

public class Line {
	private Point startPoint;
	private Point endPoint;
	private boolean selected;

	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	public Point getStartPoint() {
		return this.startPoint;
	}

	public Point getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	public double length() {
		return this.startPoint.distance(endPoint.getX(), endPoint.getY());
	}
}
