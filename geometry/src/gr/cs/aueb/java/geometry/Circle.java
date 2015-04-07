package gr.cs.aueb.java.geometry;

public final class Circle extends Shape {

	private double radious;
	
	public double getRadious() {
		return radious;
	}

	public void setRadious(double radious) {
		this.radious = radious;
	}

	@Override
	public double getPerimeter() {
		return 2 * Math.PI * this.getRadious();
	}
	
	@Override
	public double getArea() {
		return Math.PI * Math.pow(this.getRadious(), 2);
	}
}
