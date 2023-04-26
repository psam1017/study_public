package ch05_method;

public class JavaArgs {

	// javascript는 오버로딩이 없고, 인자의 길이를 직접 해석하여 함수를 실행한다.
	// java는 오버로딩이 있고, 가변길이 인자를 배열로 받을 수 있다.
	
	// 가변길이 인자는 반드시 제일 오른쪽에 있어야 한다.
	// 가변길이 인자를 2개 이상 사용해선 안 된다. 하나만 사용해야 한다.
	
	public static void test(int... args) {
		System.out.print(args.length + " : ");
		for(int x : args) {
			System.out.print(x + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		test(1);
		test(1, 2);
		test(1, 2, 3);
	}
}
