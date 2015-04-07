package gr.cs.aueb.java.geometry;

public final class Square extends Shape {

	private double a;

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}
	
	@Override
	public double getPerimeter() {
		return 4 * this.getA();
	}
	
	@Override
	public double getArea() {
		return Math.pow(this.getA(), 2);
	}
	
	public void noSexyThing() {
		
	}
}
