package gr.aueb.cs.java.mathVectors;

public class Main {

	public static void main(String[] args) {
		Point2D p1 = new Point2D(2, 3);		
		Point2D p2 = new Point2D();
		Point2D p3 = new Point2D(p1);
		
		System.out.println(Point2D.numOfInstances);
		
		println(p1, "point #1");
		println(p2, "point #2");
		println(p3, "point #3");
		
		double dist1_2 = p1.distance(p2);
		double dist1_3 = Point2D.distance(p1, p3);
		
		System.out.println("p1.distanceTo(p2) = " + dist1_2);
		System.out.println("p1.distanceTo(p3) = " + dist1_3);
		
		Vector2D v1 = new Vector2D(1, 1, 3, 4);
		Vector2D v2 = new Vector2D(v1);
		v2.setY1(2);
		v2.setY2(2);
		Vector2D v3 = Vector2D.add(v1, v2);
		Vector2D v4 = Vector2D.subtract(v3, v2);
		println(v1);
		println(v2);
		println(v3);
		println(v4);
		System.out.println(v1 + " x " + v2 + " = " + Vector2D.dotProduct(v1, v2));
	}
	
	public static void println(Point2D p, String label) {
		System.out.println(label + ": " + p.toString());
	}
	
	private static void println(Vector2D v)
	{
		System.out.println("Euclidean representation:" + v.toString() + ", norm of vector = " + toString(v.norm(), 2));
	}
	
	private static String toString(double number, int digits)
	{
		String format = "%." + digits + "f";
		return String.format(format, number);
	}

}
