package ch05_recursive;

public class Sec04_TowersOfHanoi {
	
	public static void main(String[] args) {
		
		int count = 3;
		System.out.println("원반의 개수 : " + count);
		
		move(count, 1, 3);
	}
	
	private static void move(int num, int one, int ano) {
		
		// 한 번은 이쪽 기둥에
		if(num > 1) {
			move(num - 1, one, 6 - one - ano);
		}
		
		System.out.println("원반[" + num + "]을/를 " + one + "번 기둥에서 " + ano + "번 기둥으로 옮깁니다.");
		
		// 한 번은 저쪽 기둥에
		if(num > 1) {
			move(num - 1, 6 - one - ano, ano);
		}
	}
}
