package projects.project1;

public class Point {  
  /*Sample Output in Point_Driver.java*/
  
	private double x, y;  

	/* Constructor*/
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/*Swap x & y coordinates*/
	public void swap () {
		double holdX = x;
		x = y;
		y = holdX;
	}
	
	/*Distance from A to origin (if we call A.distance())*/
	public double distance()	{
		double ret = Math.sqrt(Math.pow((x - 0), 2) + 
				Math.pow((y - 0), 2));
		return ret;
	}
	
	/*Distance from A to B (if we call A.distance(B))*/
	public double distance(Point b)	{
		double ret = Math.sqrt(Math.pow((x - b.x), 2) + 
				Math.pow((y - b.y), 2));
		return ret;
	}
	
	/*Shift along x-axis*/
	public void shiftX(double s) {
		x = x + s;
	}
  
  /*Shift along y-axis*/
	public void shiftY(double s) {
		y = y + s;
	}
	
	/*Rotate d radians*/
	public void rotate(double d) {
		double xPrime = x * Math.cos(d) - y * Math.sin(d);
		double yPrime = x * Math.sin(d) - y * Math.cos(d);
		
		x = xPrime;
		y = Math.round(yPrime);
	}
	
	@Override
	public  String toString() {
		String ret = "(" + x + ", " + y + ")";
		return ret;
	}
}
