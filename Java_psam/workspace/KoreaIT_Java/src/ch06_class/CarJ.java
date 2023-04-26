package ch06_class;

// Class 5, 6���� ���
public class CarJ {		
		 private String name;
		 private int width, height, length;
		 private double x, y, fuel;
		 
		public CarJ(String name, int width, int height, int length, double fuel) {
			super();
			this.name = name;
			this.width = width;
			this.height = height;
			this.length = length;
			this.fuel = fuel;
			this.x = 0;
			this.y = 0;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getWidth() {
			return width;
		}
		public void setWidth(int width) {
			this.width = width;
		}
		public int getHeight() {
			return height;
		}
		public void setHeight(int height) {
			this.height = height;
		}
		public int getLength() {
			return length;
		}
		public void setLength(int length) {
			this.length = length;
		}
		public double getX() {
			return x;
		}
		public void setX(double x) {
			this.x = x;
		}
		public double getY() {
			return y;
		}
		public void setY(double y) {
			this.y = y;
		}
		public double getFuel() {
			return fuel;
		}
		public void setFuel(double fuel) {
			this.fuel = fuel;
		}



		void putSpec() {
			System.out.println("�̸� : " + name);
			System.out.println("�� �ʺ� : " + width + "mm");
			System.out.println("�� ���� : " + height + "mm");
			System.out.println("�� ���� : " + length + "mm");
		}
		
		boolean move(double dx, double dy) {
			double dist = Math.sqrt(dx * dx + dy * dy); // ��Ÿ��� ���� ����
			
			if(dist > fuel)
				return false;
			else {
				fuel -= dist;
				x += dx;
				y += dy;
				return true;
			}
		}
}
