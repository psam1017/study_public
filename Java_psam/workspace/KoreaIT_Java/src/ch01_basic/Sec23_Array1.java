package ch01_basic;

public class Sec23_Array1 {
	public static void main(String[] args) {

		// 배열 선언 및 생성
		int[] intArr1 = new int[5];
		int intArr2[] = new int[5];

		int[] intArr3 = new int[] {1, 2, 3, 4, 5};
		int[] intArr4 = {1, 2, 3, 4, 5};
		int intArr5[] = {1, 2, 3, 4, 5};
		
		int[] intArr6;
		intArr6 = new int[5];
		
		
		
		// 배열에 대입하지 않은 값은 0으로 초기화된다.
		// 배열의 시작 index는 0이다.
		// 배열의 마지막 index는 index.length - 1이다.
		intArr6[0] = 1;
		intArr6[2] = 3;
		intArr6[4] = intArr6[0] + intArr6[2];
		
		
		
		// 배열 자체는 첫 번째 값의 주소 값을 가지고 있다.
		System.out.println(intArr1);
		System.out.println(intArr2);
		System.out.println(intArr3);
		System.out.println(intArr4);
		System.out.println(intArr5);
		
		
		
		// foreach : 배열의 element에 대한 반복문
		for(int element : intArr6) {
			System.out.print(element + " ");
		}
	}
}
