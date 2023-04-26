package ch10_java_lang_package.System_;

public class System_exit {
	public static void main(String[] args) {
		
		for(int i = 0; i < 10; i++) {
			if(i == 5)
				System.exit(0); // i가 5에 도달하면 프로그램을 종료.
			System.out.println(i);
		}
		
		System.out.println("끝까지 프로그램을 실행한 경우 출력되는 문장");
	}
}
