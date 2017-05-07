package com.omisoft.basic_java.objects.task2;
/**
 * Creates a Quadrangle
 * @author bkoprinski
 *
 */
public class Quadrangle extends Figure {
	private Line a;
	private Line b;
	private Line c;
	private Line d;
	
	public Quadrangle(Line a, Line b, Line c, Line d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
	

	public Line getA() {
		return a;
	}

	public void setA(Line a) {
		this.a = a;
	}

	public Line getB() {
		return b;
	}

	public void setB(Line b) {
		this.b = b;
	}

	public Line getC() {
		return c;
	}

	public void setC(Line c) {
		this.c = c;
	}

	public Line getD() {
		return d;
	}

	public void setD(Line d) {
		this.d = d;
	}
	
	void draw() {
		
		System.out.println("Draw Quadrangle");
	}

	void resize() {
	
		System.out.println("Resize Quadrangle");
	}
	void findSurface()
	{
		
	}
}
