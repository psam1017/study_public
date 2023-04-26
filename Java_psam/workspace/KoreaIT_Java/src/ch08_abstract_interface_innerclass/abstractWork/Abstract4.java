package ch08_abstract_interface_innerclass.abstractWork;

public class Abstract4 {
	public static void main(String[] args) {
		
//		Shape s = new Shape();
//		추상 클래스는 인스턴스로 사용할 수 없음.
		Shape[] shapes = new Shape[2];
		
		shapes[0] = new Point();
		shapes[1] = new Rectangle(4, 3);
		
		for(Shape s : shapes) {
			s.draw();
			System.out.println();
		}
		
		for(int i = 0; i < shapes.length; i++) {
			shapes[i].draw();
			System.out.println();
		}
		
	}
}
