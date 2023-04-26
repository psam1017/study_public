package ch09_exceptionHandling;

public class ExceptionHandling3 {
	public static void main(String[] args) {
		
		int[] a = {1, 0};
		int b = 4;
		
		try {
			System.out.println("try 구문 시작");
			int c = b / a[2];
			System.out.print("정상 실행 : ");
			System.out.println(c);
		}
		catch (ArithmeticException ae) {
			System.out.println("산술 오류 발생");
		}
		catch (ArrayIndexOutOfBoundsException ie) {
			System.out.println("배열 길이 오류 발생");
		}
		System.out.println("finally 없이 예외 처리 구문 바깥에서 실행");
		
		System.out.println();
		
		try {
			System.out.println("try 구문 시작");
			int c = b / a[1];
			System.out.print("정상 실행 : ");
			System.out.println(c);
		}
		catch (ArithmeticException ae) {
			System.out.println("산술 오류 발생");
		}
		catch (ArrayIndexOutOfBoundsException ie) {
			System.out.println("배열 길이 오류 발생");
		}
		finally {
			System.out.println("finally에서 마지막 명령 실행");
		}
		
		System.out.println();
		
		try {
			System.out.println("외부와 연결");
			int c = b / a[0];
			System.out.print("정상 실행 : ");
			System.out.println(c);
		}
		catch (ArithmeticException ae) {
			System.out.println("산술 오류 발생");
		}
		catch (ArrayIndexOutOfBoundsException ie) {
			System.out.println("배열 길이 오류 발생");
		}
		finally {
			System.out.println("예외 발생 여부와 상관 없이 연결을 종료해야 함.");
		}
	}
}
