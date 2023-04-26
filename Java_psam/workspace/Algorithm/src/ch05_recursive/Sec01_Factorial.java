package ch05_recursive;

public class Sec01_Factorial {
	public static void main(String[] args) {
		
		System.out.println("5!을 구합니다.");
		System.out.println(factorial(5));
	}
	
	private static int factorial(int number) {
		
		return number > 0 ? number * factorial(number - 1) : 1;
		
	}
}
