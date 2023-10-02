package inheritance;

public class Circle extends Shape {

	private double diameter;

	// functionality only for circle
	// cause rectangle has no radius
	public double getRadius() {
		return diameter / 2;
	}

	public double getDiameter() {
		return diameter;
	}

	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}

	@Override
	public double calculateArea() {
		// TODO Auto-generated method stub
		return 3.14*getRadius()*getRadius();
	}

	@Override
	public double calculatePerimeter() {
		// TODO Auto-generated method stub
		return 0;
	}
}
