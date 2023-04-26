package ch01_basic;

public class Sec12_Condition1 {
	public static void main(String[] args) {
		
		int age = 20;
		if(age < 0) {
			System.out.println("나이가 적절하지 않습니다.");
		}
		else if(age < 20){
			System.out.println("미성년자입니다.");
		}
		else {
			System.out.println("성인입니다.");
		}
	}
}
