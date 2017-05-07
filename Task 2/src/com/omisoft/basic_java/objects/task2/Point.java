package com.omisoft.basic_java.objects.task2;
/**
 * Creating a point
 * 
 * @author bkoprinski
 *
 */
public class Point extends Figure {
	private double x;
	private double y;
	
	/**
	 * Initialize point
	 * @param x - X coordinate
	 * @param y - Y coordinate
	 */
	public Point(double x,double y)
	{
		this.setX(x);
		this.setY(y);
	}
	/**
	 * Gets X coordinate
	 * @return - x
	 */
	public double getX() {
		return x;
	}
	/**
	 * Sets X coordinate
	 * @param x
	 */
	public void setX(double x) {
		this.x = x;
	}
	/**
	 * Gets Y coordinate
	 * @return - y
	 */
	public double getY() {
		return y;
	}
	/**
	 * Sets Y coordinate
	 * @param y
	 */
	public void setY(double y) {
		this.y = y;
	}
	/**
	 * Prints Draw point text
	 */
	void draw() {
		
		System.out.println("Draw point");
	}

	/**
	 * Resize
	 */
	void resize() {
	
		System.out.println("Resize point");
	}
	/**
	 * Empty function
	 */
	void findSurface()
	{
		
	}
}
