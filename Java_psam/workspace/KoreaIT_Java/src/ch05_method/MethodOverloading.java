package ch05_method;

public class MethodOverloading {

	public static void main(String[] args) {
		
		int a = 10, b = 20, c = 30;
		
		System.out.printf("%d, %d, %d 중에 제일 큰 수는 %d입니다.\n", a, b, c, max(a, b, c));
		System.out.printf("%d, %d 중에 제일 큰 수는 %d입니다.\n", a, b, max(a, b));
		
	}
	
	static int max(int a, int b) {
		return a > b ? a : b;
	}

	static int max(int a, int b, int c) {
		int max = a;
		if(b > max) max = b;
		if(c > max) max = c;
		return max;
	}

}
