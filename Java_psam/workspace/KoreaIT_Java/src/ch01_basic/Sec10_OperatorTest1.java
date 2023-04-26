package ch01_basic;

public class Sec10_OperatorTest1 {
	public static void main(String[] args) {
		int pencils = 534;
		int students = 30;
		
		// 모든 학생이 공평하게 받을 수 있는 연필 개수
		int pencilsPerStudent = pencils / students;
		System.out.println(pencilsPerStudent);
		
		// 모든 학생에게 공평하게 연필을 나눠줄 경우 남는 연필 개수
		int pencilsLeft = pencils % students;
		System.out.println(pencilsLeft);
		
		
		
		// 10의 자리 이하는 버림.
		int value = 365;
		System.out.println(value / 100 * 100);
		
		
		
		// String은 클래스이므로 값만 비교하고 싶은 경우 equals를 사용해야 함.
		String str1 = "Hello World";
		String str2 = new String("Hello World");
		System.out.println(str1 == str2); // false
		System.out.println(str1.equals(str2)); // true
	}
}
