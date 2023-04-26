package ch09_exceptionHandling;

public class ExceptionHandling6 {
	public static void main(String[] args) {
		
		try {
			Exception e = new Exception("고의 예외");
			throw e;
			// throw new Exception("고의 예외");
		}
		catch(Exception e) {
			System.out.println("예외 발생!");
			// 위에서 e라는 예외를 던졌으므로, e가 가리키는 객체가 담고 있는 메시지를 반환할 수 있다.
			System.out.println(e.getMessage());
		}
	}
}
