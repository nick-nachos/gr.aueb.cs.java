package gr.cs.aueb.java.geometry;

public abstract class Shape implements Comparable<Shape> {

	public abstract double getPerimeter();
	
	public abstract double getArea();
	
	public int compareTo(Shape other) {
		double diff = this.getArea() - other.getArea();
		
		if (diff < 0) {
			return -1;
		}
		else if (diff > 0) {
			return 1;
		}
		
		return 0;
	}
}
