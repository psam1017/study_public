package ch01_backup;

public class Shuffle {

	public static void main(String[] args) {
		
		// 값에 의한 전달(Call by Value)은 원래 변수에 영향을 주지 못 한다.
		// -> swap에 전달한 a와 b는 그 안에 저장된 값을 매개변수로 활용하도록 준 것뿐이지 자기 자신(주소)를 준 것은 아니다.
		int a = 5, b = 10;
		System.out.println("---스왑 함수 안에서 a, b 출력---");
		swap(a, b);
		System.out.println("\n---스왑 함수 밖에서 a, b 출력---");
		System.out.println(a + " " + b);
		
		
		
		// 참조에 의한 전달(Call by Reference) cf. C에서는 주소에 의한 전달이라는 게 있다.
		// -> 배열 셔플(배열끼리 값을 교환) : 배열 변수도 참조변수이므로 주소에 값을 저장하는 식으로 교환하면 셔플이 가능.
		int[] number = new int[10];
		
		System.out.println("\n---초기 생성값---\n");
		for(int i = 0; i < 10; i++) {
			number[i] = i;
			System.out.print(number[i] + " ");
		}
		System.out.println();
		
		System.out.println("\n---함수 안에서 셔플---\n");
		arrayShuffle(number, 10);
		System.out.println();
		
		System.out.println("\n---함수 밖에서 다시 출력---\n");
		for(int d : number)
			System.out.print(number[d] + " ");
		
		
		
		System.out.print("\n\n\n");
		// 로또 번호 만들기
		int[] ball = new int[45];
		for(int i = 0; i < 45; i++) {
			ball[i] = i + 1;
		}
		
		for(int i = 0; i < 1000; i++) {
			int n = (int)(Math.random() * 45);
			
			int temp = ball[0];
			ball[0] = ball[n];
			ball[n] = temp;
		}
		
		System.out.println("---로또 번호 스왑 결과---\n");
		for(int i = 0; i < 6; i++) {
			System.out.print(ball[i] + " ");
		}
		
		
		
		System.out.print("\n\n\n");
		// for문을 이용해서 주어진 배열의 항목에서 최대값을 구하기.
		int max = 0;
		int[] array = {1, 5, 3, 8, 2};
		
		for(int i = 0; i < array.length; i++) {
			if(array[i] > max)
				max = array[i];
		}
		
		System.out.println("---최대값 구하기---\n");
		System.out.println("max : " + max);
		
	}

	static void swap(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
		System.out.println(a + " " + b);
	}
	
	static void arrayShuffle(int[] number, int max) {

		for(int i = 0; i < 100; i++) {
			int n = (int)(Math.random() * max);
			int temp = number[0];
			number[0] = number[n];
			number[n] = temp;
		}
		
		for(int d : number)
			System.out.print(number[d] + " ");
	}
	
}
