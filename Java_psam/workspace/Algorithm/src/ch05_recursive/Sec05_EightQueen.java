package ch05_recursive;

public class Sec05_EightQueen {
	
	public static void main(String[] args) {
		
		set(0);
		System.out.println();
		System.out.println("가능한 경우의 수 : " + count);
	}
	
	private static boolean[] flag_a = new boolean[8];
	private static boolean[] flag_b = new boolean[15];
	private static boolean[] flag_c = new boolean[15];
	private static int[] pos = new int[8];
	private static int count = 0;
	
	private static void show() {
		count++;
		for(int i = 0; i < 8; i++) {
			System.out.print(" " + pos[i] + " ");
		}
		System.out.println();
	}
	
	private static void set(int i) {
		
		for(int j = 0; j < 8; j++) {
			if(!flag_a[j] && !flag_b[i + j] && !flag_c[i - j + 7]) {
				pos[i] = j;
				if(i == 7) {
					show();
				}
				else {
					flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = true;
					set(i + 1);
					flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = false;
				}
			}
		}
	}
}
