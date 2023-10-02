package inheritance;

public class Rectangle extends Shape {

	private double height;
	private double width;
	
	public Rectangle () { 
		super();
	}

	public double getHeight() {
		return height;
	}
	
	
	//this is formula of area
	//this is implementation of the Area interface
	public double calculateArea()  {  
		return height * width;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	@Override
	public double calculatePerimeter() {
		// TODO Auto-generated method stub
		return 0;
	}
}
