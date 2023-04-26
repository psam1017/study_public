package ch09_exceptionHandling;

import java.io.*;

public class ExceptionHandling4 {
	public static void main(String[] args) {
		
		String path = ".\\sample_file\\test.txt";
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(path);
			System.out.println("지정한 경로에 파일이 존재합니다.");
		}
		catch (FileNotFoundException fe) {
			System.out.println("지정한 경로에 파일이 존재하지 않습니다.");
		}
		finally {
			if(fis != null) {
				try {
					fis.close();
				}
				catch (IOException ioe) {;}
				System.out.println("파일을 닫았습니다.");
			}
			System.out.println("자원을 해제하고 종료합니다.");
		}
	}
}
