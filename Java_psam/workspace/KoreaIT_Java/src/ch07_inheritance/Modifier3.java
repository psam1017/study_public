package ch07_inheritance;

public class Modifier3 {
	public static void main(String[] args) {
		
		// number와 say는 각각 static으로 선언되었으므로 인스턴스 생성 없이 사용이 가능.
		System.out.println(StaticPractice.number);
		StaticPractice.say();
	}
}
