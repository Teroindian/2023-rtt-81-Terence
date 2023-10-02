package inheritance;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		Rectangle rect = new Rectangle();
		rect.setName("Rectangle");
		rect.setHeight(10);
		rect.setWidth(5);

		Circle circle = new Circle();
		circle.setName("Circle");
		circle.setDiameter(100);
		
		Triangle triangle = new Triangle();
		triangle.setName("Triangle");
		triangle.setSide1(7);
		triangle.setSide2(9);
		triangle.setSide3(4);

		List<Shape> shapes = new ArrayList<>();
		shapes.add(rect);
		shapes.add(circle);
		shapes.add(triangle);
		
		for ( Shape shape : shapes) { 
			System.out.println("The Area for the shape is" + shape.getName() + "is" + shape.calculateArea());
			System.out.println("The perimeter for the shape is " + shape.getName() + " is " + shape.calculatePerimeter());
		}
	}

}
