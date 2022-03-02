package projects.project1;

public class Project1Driver {
	public static void main(String[] args) {
    
    /*Sample Output:
    Point 1: (2.0, 4.0)
    Point 2: (-1.0, 8.0)
    Distance between (2.0, 4.0) and (-1.0, 8.0): 5.0

    After shift:
    Point 1: (5.0, 4.0)
    Point 2: (-1.0, 6.0)
    Distance: 6.324

    Rotate test:
    Before rotate: Point 3: (0.0, 1.0)
    After rotate: Point 3: (-1.0, 0.0)
    */
    
		Point p1 = new Point(2,4);
		Point p2 = new Point(-1, 8);
		Point p3 = new Point(0,1);
		
		System.out.println("Point 1: " + p1);
		System.out.println("Point 2: " + p2);
		System.out.println("Distance between " + p1 + " and " + 
				p2 + ": " + p1.distance(p2));
		p1.shiftX(3);
		p2.shiftY(-2); 
		System.out.println("\nAfter shift:");
		System.out.println("Point 1: " + p1);
		System.out.println("Point 2: " + p2);
		System.out.println("Distance: " + p1.distance(p2));
		System.out.println("\nRotate test:");
		System.out.println("Before rotate: Point 3: " + p3);
		p3.rotate(Math.PI / 2);
		System.out.println(" After rotate: Point 3: " + p3);
	}

}
