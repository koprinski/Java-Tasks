package com.omisoft.basic_java.objects.task2;
/**
 * Creates a Parallelogram
 * @author bkoprinski
 *
 */
public class Parallelogram extends Quadrangle {
	private Point position;
	private Point size;
	
	public Parallelogram(Line a, Line b, Line c, Line d, Point position, Point size) {
		super(a, b, c, d);
		this.position=position;
		this.size=size;
		// TODO Auto-generated constructor stub
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}
	
	void draw() {
		
		System.out.println("Draw Parallelogram");
	}

	void resize() {
	
		System.out.println("Resize Parallelogram");
	}

	public Point getSize() {
		return size;
	}

	public void setSize(Point size) {
		this.size = size;
	}

}
