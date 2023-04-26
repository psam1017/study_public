package ch01_basic;

public class Sec07_Cast3 {
	public static void main(String[] args) {

		// 연산자 우선순위 : 최단산쉬 관리삼대
		int avg1 = 241 / 3; // 80
		double avg2 = 241 / 3; // 80.0
		double avg3 = (double)241 / 3; // 80.33

		System.out.println(avg1);
		System.out.println(avg2);
		System.out.println(avg3);
		System.out.println(Math.round(avg3*100) / 100.0);
	}
}
