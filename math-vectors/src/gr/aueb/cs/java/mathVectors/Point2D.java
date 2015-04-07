package gr.aueb.cs.java.mathVectors;

public class Point2D {
	
	public static int numOfInstances;
	
	public double x;
	public double y;
	
	public Point2D() {
		this(0, 0);
	}
	
	public Point2D(double x, double y) {
		this.x = x;
		this.y = y;
		numOfInstances++;
	}
	
	public Point2D(Point2D other) {
		this(other.x, other.y);
	}
	
	public double getX() {
		return this.x;
	}
	
	public void setY(double value) {
		this.y = value;
	}
	
	public String toString() {
		return String.format("(%.2f, %.2f)", this.x, this.y);
	}
	
	public double distance(Point2D p) {
		return Point2D.distance(this, p);
	}
	
	public Point2D add(Point2D p) {
		return Point2D.add(this, p);
	}
	
	public Point2D subtract(Point2D p) {
		return Point2D.subtract(this, p);
	}
	
	public static double distance(Point2D p1, Point2D p2) {
		double xDiff = p1.x - p2.x;
		double yDiff = p1.y - p2.y;
		double squaredDist = Math.pow(xDiff, 2) + Math.pow(yDiff, 2);
		
		return Math.sqrt(squaredDist);
	}
	
	public static Point2D add(Point2D p1, Point2D p2) {
		return new Point2D(p1.x + p2.x, p1.y + p2.y);
	}
	
	public static Point2D subtract(Point2D p1, Point2D p2) {
		return new Point2D(p1.x - p2.x, p1.y - p2.y);
	}
}
