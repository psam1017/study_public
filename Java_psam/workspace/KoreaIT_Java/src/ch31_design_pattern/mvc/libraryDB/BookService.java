package ch31_design_pattern.mvc.libraryDB;

import java.util.Scanner;

public class BookService {
	
	BookConnection connection = new BookConnection();
	Scanner sc = new Scanner(System.in);
	
	public void addBook() {
		
		BookData data = new BookData();
		
		System.out.println("어떤 책을 추가하시겠습니까?");
		System.out.print("코드 : "); data.setCode(sc.next());
		System.out.print("제목 : "); data.setTitle(sc.next());
		System.out.print("저자 : "); data.setAuthor(sc.next());
		System.out.print("재고 : ");
		data.setStockOrigin(sc.nextInt());
		data.setStockCurrent(data.getStockOrigin());
		
		System.out.println("책 내용을 확인해주십시오.");
		data.toString();
		
		System.out.println("책 내용이 일치하면 Y를 누르십시오.");
		String check = sc.next();
		
		if(check.equals("Y") || check.equals("y")) {
			connection.connectDB();
			connection.addBook(data);
			connection.closeDB();
		}
	}
	
	public void searchBook() {
		
		String title;
		
		System.out.println("찾으시려는 책의 제목을 입력해주십시오.");
		System.out.print("제목 : "); title = sc.next();
		
		connection.connectDB();
		connection.searchBook(title);
		connection.closeDB();
	}
	
	public void lendBook() {
		
		String code;
		int num;
		
		System.out.println("대여할 책의 코드와 권 수를 입력해주세요.");
		
		System.out.print("코드 : "); code = sc.next();
		System.out.print("권수 : "); num = sc.nextInt();
		
		connection.connectDB();
		int stock = connection.checkStock(code);
		
		if(stock < num && stock != -1) {
			System.out.println("해당 재고가 " + stock + "권 남아있습니다.");
			System.out.println("나중에 다시 이용해주십시오.");
		}
		else if(stock > 0) {
			connection.lendBook(code, num);
		}
		connection.closeDB();
	}
	
	public void returnBook() {
		
		String code;
		int num;
		
		System.out.println("반납할 책의 코드와 권 수를 입력해주세요.");
		
		System.out.print("코드 : "); code = sc.next();
		System.out.print("권수 : "); num = sc.nextInt();
		
		connection.connectDB();
		int stock = connection.checkStock(code);
		int origin = connection.checkOrigin(code);
		if(stock >= 0 && (num + stock) <= origin) {
			connection.returnBook(code, num);
		}
		else if(num + stock > origin) {
			System.out.println("대여하지 않은 도서가 섞여 있습니다.");
			System.out.println("반납하실 도서의 권수를 확인해주십시오.");
		}
		connection.closeDB();
	}
	
	public void getList() {
		connection.connectDB();
		connection.getList();
		connection.closeDB();
	}
}
