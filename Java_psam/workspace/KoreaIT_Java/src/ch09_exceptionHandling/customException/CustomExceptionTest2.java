package ch09_exceptionHandling.customException;

import java.util.Scanner;

public class CustomExceptionTest2 {
	public static void main(String[] args) {
		
		CustomExceptionTest2 cet2 = new CustomExceptionTest2();
		cet2.login();
	}
	
	
	
	String memberID = "abc";
	String password = "1234";
	boolean isAnswer = false;
	
	Scanner sc = new Scanner(System.in);
	
	public void login(){
		
		String memberID, password;
		
		System.out.println("로그인 정보를 입력하세요.");
		do {
			try {
				System.out.print("아이디 : ");
				memberID = sc.nextLine();
				System.out.print("비밀번호 : ");
				password = sc.nextLine();
				confirmLogin(memberID, password);
			}
			catch(LoginException le) {
				System.out.println(le.getMessage());
				System.out.println("로그인 정보를 기록했습니다.");
			}
		} while(!isAnswer);
	}
	
	private void confirmLogin(String memberID, String password) throws LoginException{
		
		if(this.memberID.equals(memberID) && this.password.equals(password)) {
			isAnswer = true;
			System.out.println("로그인에 성공했습니다.");
		}
		else {
			isAnswer = false;
			throw new LoginException("로그인 정보가 일치하지 않습니다.", memberID, password);
		}
	}
}

@SuppressWarnings("serial")
class LoginException extends Exception{

	public LoginException(String cause) {
		super(cause);
	}
	
	public LoginException(String cause, String memberID, String password) {
		super(cause);
		updateLog(memberID, password);
	}
	
	public void updateLog(String memberID, String password) {
		// 로그인 시도 정보를 Log 파일에 기록하여 해킹 여부를 파악한다.
	}
}
