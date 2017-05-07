package com.omisoft.basic_java.objects.task2;
/**
 * Creates a Rectangle
 * @author bkoprinski
 *
 */
public class Rectangle extends Parallelogram {

	public Rectangle(Line a, Line b, Line c, Line d, Point position, Point size) {
		super(a, b, c, d, position, size);
		// TODO Auto-generated constructor stub
	}
	
	void draw() {
		
		System.out.println("Draw Rectangle");
	}

	void resize() {
	
		System.out.println("Resize Rectangle");
	}
	/**
	 * Finds the surface of the Rectangle
	 * @param a - first line
	 * @param b - second line
	 */
	void findSurface(double a, double b)
	{
		 double f = a*b;
		 System.out.println("Rectangle surface = " + f);		 
	}

}
