package ch09_exceptionHandling;

import java.io.*;
import java.util.Date;

public class ExceptionLog2 {
	public static void main(String[] args) {
		
		PrintStream ps = null;
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream(".\\sample_file\\error2.log", true);
			ps = new PrintStream(fos);
			System.setErr(ps);
			
			System.out.println(1);
			System.out.println(2);
			System.out.println(0/0);	// 예외 발생!
			System.out.println(3);		// unreachable syntax.
		}
		catch (Exception e) {
			System.err.println("-------------------------------");
			System.err.println("Exception Occur Time : " + new Date());
			e.printStackTrace(System.err);
			System.err.println("Exception Message : " + e.getMessage());
			System.err.println("-------------------------------\n\n\n");
		}
		
		System.out.println(6);
	}
}
