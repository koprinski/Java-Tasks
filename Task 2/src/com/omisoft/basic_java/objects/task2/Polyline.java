package com.omisoft.basic_java.objects.task2;
/**
 * Creates a polyline
 * @author bkoprinski
 *
 */
public class Polyline extends Quadrangle {
	private Line e;
	private Line f;
	
	public Polyline(Line a, Line b, Line c, Line d, Line e, Line f) {
		super(a, b, c, d);
		this.e=e;
		this.f=f;
		// TODO Auto-generated constructor stub
	}

	public Line getE() {
		return e;
	}

	public void setE(Line e) {
		this.e = e;
	}

	public Line getF() {
		return f;
	}

	public void setF(Line f) {
		this.f = f;
	}
	
void draw() {
		
		System.out.println("Draw Polyline");
	}

	void resize() {
	
		System.out.println("Resize Polyline");
	}
	void findSurface()
	{
		
	}
	
}
