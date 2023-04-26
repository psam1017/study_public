package ch11_java_util_package.Calendar_Date_;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormat01 {
	public static void main(String[] args) {
		
		// SimpleDateFormat : 날짜 정보를 형식화하는 클래스
		// yy : MM : dd : HH : mm : ss
		// E : 요일
		// a : 오전/오후
		
		Date today = new Date();
		
		String patternKr = "yyyy-MM-dd";
		String patternWeek = "E요일 HH시 mm분 ss초";
		SimpleDateFormat kr = new SimpleDateFormat(patternKr);
		SimpleDateFormat weekDate = new SimpleDateFormat(patternWeek);
		
		System.out.println("현재 날짜 : " + today);
		System.out.println("한국 형식 : " + kr.format(today));
		System.out.println("한국 형식 : " + weekDate.format(today));
	}
}
