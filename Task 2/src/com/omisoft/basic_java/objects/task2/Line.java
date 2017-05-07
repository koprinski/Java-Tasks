package com.omisoft.basic_java.objects.task2;
/**
 * Creates a line
 * @author bkoprinski
 *
 */
public class Line extends Point {
	private double x0;
	private double y0;
	
	public Line(double x, double y, double x0, double y0) {
		super(x, y);
		this.x0=x0;
		this.y0=y0;
		// TODO Auto-generated constructor stub
	}

	public double getX0() {
		return x0;
	}
	public void setX0(double x0) {
		this.x0 = x0;
	}
	public double getY0() {
		return y0;
	}
	public void setY0(double y0) {
		this.y0 = y0;
	}
	
	void draw() {
		
		System.out.println("Draw line");
	}


	void resize() {
	
		System.out.println("Resize line");
	}
}
