package ch09_exceptionHandling.customException;

public class CustomExceptionTest1 {
	public static void main(String[] args) {
		
		int[] arr = new int[10];
		
		try {
			for(int i = 0; i < 10; i++) {
				arr[i] = i + 1;
			}
			
			for(int i = 0; i < 11; i++) {
				System.out.println(arr[i]);			
			}
		}
		catch(ArrayIndexOutOfBoundsException aie) {
			System.out.println("배열 범위를 초과했습니다.");
			System.out.println(aie.getMessage());
		}
	}
}
