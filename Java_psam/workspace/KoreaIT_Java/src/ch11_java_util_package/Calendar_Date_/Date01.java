package ch11_java_util_package.Calendar_Date_;

import java.util.Date;

public class Date01 {
	public static void main(String[] args) {
		
		// Date 인스턴스 생성하기
		// 방법 1
		Date today = new Date();
		
		// 방법 2 : 시스템에서 long 타입으로 시간을 가져와서 매개변수 생성자로 생성.
		long a = System.currentTimeMillis();
		Date today2 = new Date(a);
		
		System.out.println(today);
		System.out.println(today2);
	}
}
