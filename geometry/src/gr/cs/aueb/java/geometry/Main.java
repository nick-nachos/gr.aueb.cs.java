package gr.cs.aueb.java.geometry;

public final class Main {

	public static void main(String[] args) {
		Square s1 = new Square();
		s1.setA(4);
		
		Circle c1 = new Circle();
		c1.setRadious(2);
		
		Rectangle r1 = new Rectangle();
		r1.setA(1);
		r1.setB(3);
		
		int cmp1 = compare(s1, c1);
		int cmp2 = compare(c1, c1);
		int cmp3 = compare(r1, c1);
		int cmp4 = compare(r1, s1);
		int cmp5 = compare(s1, r1);
		
		Shape sh1 = r1;
		System.out.println(r1);
		System.out.println(sh1);
		System.out.println(c1);
	}

	public static int compare(Shape s1, Shape s2) {
		return s1.compareTo(s2);
	}
	
	private Main() { }
}
