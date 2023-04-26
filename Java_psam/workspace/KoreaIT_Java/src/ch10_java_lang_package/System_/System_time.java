package ch10_java_lang_package.System_;

public class System_time {
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		System.out.println("시작시간 : " + start);
		@SuppressWarnings("unused")
		int a = 0;
		for(int i = 0; i < 100000000; i++) {
			a++;
			for(int j = 0; j < i; j++) {
				a++;
			}
			a = 1;
		}
		long end = System.currentTimeMillis();
		
		System.out.println("종료시간 : " + end);
		System.out.println("작업시간 : " + (end - start));
	}
}
