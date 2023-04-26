package ch09_exceptionHandling;

import java.io.*;

public class ExceptionHandling5 {
	public static void main(String[] args) {
		
		String path = ".\\sample_file\\test2.txt";
		
		try {
			FileInputStream fis = new FileInputStream(path);
			fis.close();
			System.out.println("파일 열고 닫기 성공");
		} catch(FileNotFoundException fe) { // 다형성을 이용한 예외처리
			System.out.println("**FileNotFoundException**");
			//fe.printStackTrace();
		} catch(IOException ioe) {
			System.out.println("**IOException**");
			//ioe.printStackTrace();
		} catch(Exception e) {
			System.out.println("**Exception**");
			//e.printStackTrace();
		} finally {
			System.out.println("프로그램 종료");
		}
		
	}
}
