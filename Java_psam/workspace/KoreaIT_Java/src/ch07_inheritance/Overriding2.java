package ch07_inheritance;

public class Overriding2 {

	public static void main(String[] args) {
		
		Student s = new Student();
		Leader l = new Leader();
		
		s.eat();
		s.sayHi();
		
		l.eat();
		l.sayHi(); // 오버라이딩한 메서드
		
	}

}
