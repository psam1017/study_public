package ch31_design_pattern.mvc.libraryDB;

import java.util.Scanner;

public class BookView {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		BookService service = new BookService();
		
		System.out.println("도서관에 입장하였습니다.");
		
		while(true) {
			printMenu();
			
			System.out.println("어떤 서비스를 이용하시겠습니까?");
			int choice = sc.nextInt();
			
			switch (choice) {
			case 1: {
				service.addBook();
				break;
			}
			case 2: {
				service.searchBook();
				break;
			}
			case 3: {
				service.lendBook();
				break;
			}
			case 4: {
				service.returnBook();
				break;
			}
			case 5: {
				service.getList();
				break;
			}
			case 6: {
				sc.close();
				System.out.println("서비스를 종료합니다.");
				return;
			}
			default:
				System.out.println("잘못 입력하였습니다.");
				System.out.println("숫자만을 입력해주세요.");
			}
		}
	}
	
	public static void printMenu() {
		System.out.println("================메뉴================");
		System.out.println("1. 도서추가");
		System.out.println("2. 도서검색");
		System.out.println("3. 도서대여");
		System.out.println("4. 도서반납");
		System.out.println("5. 전체출력");
		System.out.println("6. 종료");
		System.out.println();
	}
}
