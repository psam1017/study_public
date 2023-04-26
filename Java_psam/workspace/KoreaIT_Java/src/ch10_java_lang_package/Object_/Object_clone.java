package ch10_java_lang_package.Object_;

public class Object_clone {
	public static void main(String[] args) throws CloneNotSupportedException { // 예외 던지기 필요.
		
		Circle circleProto = new Circle(0, 0, 10);
		Circle circleCopy = (Circle)circleProto.clone(); // 명시적 형변환 필요.
		
		System.out.println(circleProto);
		System.out.println(circleCopy); // proto와는 독립적인 사본.
		
		System.out.println(System.identityHashCode(circleProto));
		System.out.println(System.identityHashCode(circleCopy));
	}
}

class Point{
	
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return x + ", " + y;
	}
}

class Circle implements Cloneable{
	
	Point point;
	int radius;
	
	Circle(int x, int y, int radius){
		point = new Point(x, y);
		this.radius = radius;
	}

	@Override
	public String toString() {
		return "원점의 좌표는" + point + "이고, 반지름은 " + radius + "입니다.";
	}
	
	// source로 자동 생성.
	@Override
	protected Object clone() throws CloneNotSupportedException { // 예외 던지기 필요.
		return super.clone();
	}
}
