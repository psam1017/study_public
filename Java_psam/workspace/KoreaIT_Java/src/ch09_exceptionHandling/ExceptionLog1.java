package ch09_exceptionHandling;

import java.io.*;

public class ExceptionLog1 {
	public static void main(String[] args) {
		
		PrintStream ps = null;
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream(".\\sample_file\\error.log");
			ps = new PrintStream(fos);
			
			System.out.println(1);
			System.out.println(2);
			System.out.println(3);
			System.out.println(0/0);
			System.out.println(4);
		}
		catch (Exception e) {
			// 에러를 ps로 기록한다.
			e.printStackTrace(ps);
			ps.println("Exception Message : " + e.getMessage());
		}
	}
}
