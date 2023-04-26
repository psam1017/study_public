package ch01_backup;

public class JaggedArray {

	public static void main(String[] args) {
		
		// 다차원 배열
		
		// 선언과 생성.
		// 자료형[][] 변수명 = new int[i][j];
		
		// 배열에 값을 바로 대입
		// 자료형[][] 변수명 = {
		// 				{값[0][0], 값[0][1], ...},
		// 				{값[1][0], 값[1][1], ...},
		// 				{값[2][0], 값[2][1], ...},
		// 				...
		// };
		
		// 다차원 배열의 길이 구하기
		
		int[][] scores = new int[][] {
				{30, 40, 50},
				{22, 45, 80, 23},
				{41, 20},
				{20, 40, 60, 80, 100}
		};
		
		int total = 0, count = 0;
		float avg = 0;
		
		for(int i = 0; i < scores.length; i++) {
			for(int j = 0; j < scores[i].length; j++) {
				total += scores[i][j];
				count++;
			}
		}
		avg = (float)total / count;
		
		System.out.println("avg : " + avg);
		System.out.println("total : " + total);
	}

}
