package ch11_java_util_package.Calendar_Date_;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatTest01 {
	public static void main(String[] args) {

		SimpleDateFormat mySimpleFormat = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 HH시 mm분");
		System.out.println(mySimpleFormat.format(new Date()));
	}
}
