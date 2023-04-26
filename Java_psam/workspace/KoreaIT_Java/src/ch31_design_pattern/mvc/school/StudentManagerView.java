package ch31_design_pattern.mvc.school;

import java.util.Scanner;

public class StudentManagerView {
	
	public static void main(String[] args) {
		
		StudentManagerUpdate studentManager = StudentManagerUpdate.getInstance();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("학생 관리 프로그램을 시작합니다.");
		
		while(true) {
			
			System.out.println("메뉴를 선택하세요.\n1. 학생 추가\n2. 학생 삭제\n3. 수강 신청\n4. 성적입력\n5. 정보 조회\n6. 프로그램 종료");
			
			int menu = sc.nextInt();
			switch(menu) {
			case 1:
				System.out.println("학생 추가 및 수정 메뉴입니다.");
				studentManager.addStudent();
				break;
			case 2:
				System.out.println("학생 삭제 메뉴입니다.");
				studentManager.removeStudent();
				break;
			case 3:
				System.out.println("수강 신청 메뉴입니다.");
				studentManager.addClass();
				break;
			case 4:
				System.out.println("성적 입력 메뉴입니다.");
				studentManager.setScore();
				break;
			case 5:
				System.out.println("정보 조회 메뉴입니다.");
				studentManager.informStudent();
				break;
			case 6:
				System.out.println("프로그램을 종료합니다.");
				sc.close();
				return;
			default:
				System.out.println("잘못된 입력입니다.");
			}
		}
	}
}
