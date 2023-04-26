package ch01_backup;

public class WhileStudy {
	public static void main(String[] args) {
		
		int a = 0;
		
		while(a != 10) { // a가 10이 아닌 동안에 loop를 실행
			if(a == 10) // a가 10일 때 loop를 탈출
				break;
			a++;
		}
		
		while(true) { // while 조건에 true를 입력하여 loop를 실행
			if(a == 20)
				break;
			a++;
		}
		
		do { // while 조건이 false이더라도 적어도 1회 실행
			a += 10;
		} while(a >= 100);
		
		System.out.println(a);
	}
}
