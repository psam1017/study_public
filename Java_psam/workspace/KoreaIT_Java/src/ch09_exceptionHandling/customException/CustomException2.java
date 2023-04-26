package ch09_exceptionHandling.customException;

public class CustomException2 {
	public static void main(String[] args) {
		
		int age = -19;
		try {
			ticketing(age); // 1. ticketing 메소드 호출 -> 오류 발생 
		}
		catch(AgeException ae) { // 3. 오류를 넘겨받아 main에서 처리. 생성된 예외를 넘겨 받고, 참조변수 ae에 저장.
			ae.printStackTrace(); //4. ae가 참조하는 인스턴스의 메시지를 출력.
		}
	}
	
	public static void ticketing(int age) throws AgeException{ // 2. 생성된 AgeException을 호출 쪽으로 넘김.
		if(age < 0)
			throw new AgeException("나이 입력이 잘못되었습니다."); // 2-1. 메시지가 포함된 AgeException 예외를 발생시킴.
	}
}

@SuppressWarnings("serial")
class AgeException extends Exception{
	
	public AgeException() {}
	public AgeException(String msg) {
		super(msg);
	}
	
	public void printStackTrace() {
		System.out.println(getMessage());
	}
}
