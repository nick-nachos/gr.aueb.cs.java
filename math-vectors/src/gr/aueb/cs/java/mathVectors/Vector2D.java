package gr.aueb.cs.java.mathVectors;

public class Vector2D
{
	private Point2D start;
	private Point2D end;
	
	public Vector2D()
	{
		this(0, 0, 0, 0);
	}
	
	public Vector2D(Point2D start, Point2D end)
	{
		this(start.x, start.y, end.x, end.y);
	}
	
	public Vector2D(double x1, double y1, double x2, double y2)
	{
		this.start = new Point2D(x1, y1);
		this.end = new Point2D(x2, y2);
	}
	
	public Vector2D(Vector2D v)
	{
		this(v.start, v.end);
	}
	
	public double getX1()
	{
		return this.start.x;
	}
	
	public void setX1(double value)
	{
		this.start.x = value;
	}
	
	public double getY1()
	{
		return this.start.y;
	}
	
	public void setY1(double value)
	{
		this.start.y = value;
	}
	
	public double getX2()
	{
		return this.end.x;
	}
	
	public void setX2(double value)
	{
		this.end.x = value;
	}
	
	public double getY2()
	{
		return this.end.y;
	}
	
	public void setY2(double value)
	{
		this.end.y = value;
	}
	
	public double norm()
	{
		return this.start.distance(this.end);
	}
	
	public Vector2D euclideanForm()
	{
		return new Vector2D(0, 0, this.getX2() - this.getX1(), this.getY2() - this.getY1());
	}
	
	@Override
	public String toString()
	{
		return this.euclideanForm().end.toString();
	}
	
	public static Vector2D add(Vector2D v1, Vector2D v2)
	{
		Point2D start = Point2D.add(v1.start, v2.start);
		Point2D end = Point2D.add(v1.end, v2.end);
		
		return new Vector2D(start, end);
	}
	
	public static Vector2D subtract(Vector2D v1, Vector2D v2)
	{
		Point2D start = Point2D.subtract(v1.start, v2.start);
		Point2D end = Point2D.subtract(v1.end, v2.end);
		
		return new Vector2D(start, end);
	}
	
	public static double dotProduct(Vector2D v1, Vector2D v2)
	{
		v1 = v1.euclideanForm();
		v2 = v2.euclideanForm();
		
		return v1.getX2() * v2.getX2() + v1.getY2() * v2.getY2();
	}
}