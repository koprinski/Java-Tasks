package com.omisoft.basic_java.objects.task2;
/**
 * Creates a Rhombus
 * @author bkoprinski
 *
 */
public class Rhombus extends Parallelogram {
	public Rhombus(Line a, Line b, Line c, Line d, Point position, Point size) {
		super(a, b, c, d, position, size);
		// TODO Auto-generated constructor stub
	}
	
	void draw() {
		
		System.out.println("Draw Rhombus");
	}

	void resize() {
	
		System.out.println("Resize Rhombus");
	}
}
