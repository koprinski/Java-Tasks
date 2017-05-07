package com.omisoft.basic_java.objects.task2;
/**
 * Creates a cube
 * @author bkoprinski
 *
 */
public class Cube extends Parallelogram {
	
	public Cube(Line a, Line b, Line c, Line d, Point position, Point size) {
		super(a, b, c, d, position, size);
		// TODO Auto-generated constructor stub
	}
	
	void draw() {
		
		System.out.println("Draw Cube");
	}

	void resize() {
	
		System.out.println("Resize Cube");
	}
	void findSurface(double a)
	{
		double c = a*a;
		System.out.println("Cube surface = " + c);	
	}
}
