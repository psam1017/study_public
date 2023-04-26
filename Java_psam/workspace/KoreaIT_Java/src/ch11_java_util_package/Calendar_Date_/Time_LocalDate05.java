package ch11_java_util_package.Calendar_Date_;

import java.math.BigDecimal;

public class Time_LocalDate05 {
	public static void main(String[] args) {
		
		double a = 24.3953;
		double b = 50.343998;
		
		System.out.println(a + b);
		
		BigDecimal number1 = new BigDecimal(String.valueOf(a));
		BigDecimal number2 = new BigDecimal(String.valueOf(b));
		
		System.out.println(number1.add(number2));
	}
}
