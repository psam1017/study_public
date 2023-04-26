package ch01_basic;

public class Sec17_ForLoopTest1 {
	public static void main(String[] args) {
		
		int rows = 10;
		
		for(int i = 1; i < rows; i++) {
			for(int j = 0; j < i; j++) {
				System.out.print("★");
			}
			System.out.println();
		}
		
		System.out.println();
		for(int i = 1; i < rows; i += 2) {
			for(int j = 0; j < rows - i - 1; j++) {
				System.out.print(" ");
			}
			for(int j = 0; j < i; j++)
				System.out.print("★");
			System.out.println();
		}
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < rows - i - 1; j++) {
				System.out.print("  ");
			}
			for(int j = 0; j < i; j++)
				System.out.print("★");
			System.out.println();
		}
	}
}
