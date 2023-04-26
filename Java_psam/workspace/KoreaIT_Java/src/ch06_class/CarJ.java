package ch06_class;

// Class 5, 6에서 사용
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
			System.out.println("이름 : " + name);
			System.out.println("차 너비 : " + width + "mm");
			System.out.println("차 높이 : " + height + "mm");
			System.out.println("차 길이 : " + length + "mm");
		}
		
		boolean move(double dx, double dy) {
			double dist = Math.sqrt(dx * dx + dy * dy); // 피타고라스 정리 응용
			
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
