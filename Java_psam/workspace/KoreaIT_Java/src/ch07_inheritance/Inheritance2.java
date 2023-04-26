package ch07_inheritance;

public class Inheritance2 {

	public static void main(String[] args) {
		
		Student s = new Student();
		Teacher t = new Teacher();
		
		s.breathe(); // 상속 받은 breathe
		s.learn();
		
		t.eat(); // 상속 받은 eat
		t.teach();
	}
}
