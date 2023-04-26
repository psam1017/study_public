package new_ch14_io;

import java.io.IOException;

public class StandardStream {
	public static void main(String[] args) {
		
		// System 클래스를 열어보면 아래와 같은 사항을 알 수 있다.
		// 표준 입력 : public static final InputStream in = null;
		// 표준 출력 : public static final PrintStream out = null;
		// 표준 오류 : public static final PrintStream err = null;
		// *최상위 입출력 클래스는 InputStream, OutputStream이다.
		
		System.out.println("알파벳 여러 개를 쓰고 [Enter]를 누르세요.");
		
		int i; // 표준 입력
		
		try {
			while((i = System.in.read()) != -1) {
				System.out.print((char)i); // 표준 출력
				System.err.print((char)i); // 표준 오류
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
