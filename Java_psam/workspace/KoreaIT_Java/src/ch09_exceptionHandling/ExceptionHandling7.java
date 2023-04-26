package ch09_exceptionHandling;

public class ExceptionHandling7 {
	public static void main(String[] args) {
		
		try {
			methodA();
		}
		catch (Exception e) {
			System.out.println("메인에서 예외를 처리");
		}
		
		try {
			methodB();
		}
		catch (Exception e) {
			System.out.println("메인에서 예외를 처리");
		}
	}
	
	public static void methodA() throws Exception{ // 호출한 쪽으로 책임을 넘기기
		methodC(); // 예외가 발생하는 메소드
	}
	
	public static void methodB(){ // 메소드가 예외를 처리
		try {
			methodC();
		}
		catch (Exception e) {
			System.out.println("methodB에서 예외를 처리");
		}
	}
	
	public static void methodC() throws Exception{
		throw new Exception(); // 예외가 발생
	}	
}
