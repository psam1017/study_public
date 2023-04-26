package ch08_abstract_interface_innerclass.abstractWork;

public abstract class Shape {
	abstract void draw();
}

class Point extends Shape{
	Point(){}

	@Override
	void draw() {
		System.out.println(" +");
	};
	
}

class Rectangle extends Shape{
	private int width, height;

	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	void draw() {
		for(int i = 1; i <= height; i++) {
			for(int j = 0; j <= width; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}