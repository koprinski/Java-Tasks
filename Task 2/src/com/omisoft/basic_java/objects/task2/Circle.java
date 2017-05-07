package com.omisoft.basic_java.objects.task2;
/**
 * Creates a Circle
 * @author bkoprinski
 *
 */
public class Circle extends Point {
	private double width;
	private double height;
	
	public Circle(double x, double y, double height, double width) {
		super(x, y);
		this.height=height;
		this.width=width;
		// TODO Auto-generated constructor stub
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	void draw() {
		
		System.out.println("Draw circle");
	}

	void resize() {
	
		System.out.println("Resize circle");
	}
}
