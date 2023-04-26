package ch11_java_util_package;

import java.util.Scanner;
import java.io.FileInputStream;

public class ScannerWork01 {
	public static void main(String[] args) {
		
		try {
			FileInputStream fs = new FileInputStream("./sample_file/sample.txt");
			Scanner sc = new Scanner(fs);
			while(sc.hasNext()) {
				System.out.println(sc.nextLine());
			}
			sc.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
