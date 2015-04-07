package gr.cs.aueb.java.geometry;

public final class Rectangle extends Shape  {

	private double a;
	private double b;
	
	public double getA() {
		return a;
	}
	
	public void setA(double a) {
		this.a = a;
	}
	
	public double getB() {
		return b;
	}
	
	public void setB(double b) {
		this.b = b;
	}
	
	@Override
	public double getPerimeter() {
		return 2 * (this.getA() + this.getB());
	}
	
	@Override
	public double getArea() {
		return this.getA() * this.getB();
	}
	
	@Override
	public String toString() {
		return "a: " + this.getA() + " b: " + this.getB();
	}
}
