package com.omisoft.basic_java.objects.task2;
/**
 * Tests all program by creating objects from the different figures
 * @author bkoprinski
 *
 */
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Point point = new Point(3,2);
		point.draw();
		point.resize();
		
		System.out.println();
		Line line = new Line(1,2,3,4);
		line.draw();
		line.resize();
		
		System.out.println();
		Circle circle = new Circle(3,4,5,7);
		circle.draw();
		circle.resize();
		
		System.out.println();
		Arc arc = new Arc(5, 6, 8, 12, 16, 1);
		arc.draw();
		arc.resize();
		
		System.out.println();
		Quadrangle quadrangle = new Quadrangle(line, line, line, line);
		quadrangle.draw();
		quadrangle.resize();
		
		System.out.println();
		Parallelogram parallel = new Parallelogram(line, line, line, line, point, point);
		parallel.draw();
		parallel.resize();
		
		System.out.println();
		Rectangle rectangle = new Rectangle(line, line, line, line, point, point);
		rectangle.draw();
		rectangle.resize();
		rectangle.findSurface(5, 6);
		
		System.out.println();
		Polyline poliline = new Polyline(line, line, line, line, line, line);
		poliline.draw();
		poliline.resize();
		
		System.out.println();
		Cube cube = new Cube(line, line, line, line, point, point);
		cube.draw();
		cube.resize();
		cube.findSurface(5);
	}

}
