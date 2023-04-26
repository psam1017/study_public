package ch11_java_util_package.Calendar_Date_;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Calendar01 {
	public static void main(String[] args) {
		
		// Calendar는 추상 클래스이므로 직접 객체를 생성하지 못하고,
		// getInstance()를 통해서, 또는 GregorianCalendar 인스턴스를 생성해야 한다.
		
		Calendar a = Calendar.getInstance();	// 방법1
		Calendar b = new GregorianCalendar();	// 방법2
		
		System.out.println(a);
		System.out.println(b);
	}
}
