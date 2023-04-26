package ch06_class;

public class Class3 {

	public static void main(String[] args) {
		
		// 멤버변수에 직접 접근하여 값을 대입하고 호출.
		Student sAhn = new Student();
		sAhn.studentName = "안승연";
		
		System.out.println("멤버변수를 직접 호출 : " + sAhn.studentName);
		
		
		
		// 실무에서는 메소드로 멤버변수에 접근하는 게 일반적이다.
		Student sHong = new Student();
		
		sHong.setStudentName("홍길동");
		System.out.println("메소드로 멤버변수를 호출 : " + sHong.getStudentName());
	}
}
