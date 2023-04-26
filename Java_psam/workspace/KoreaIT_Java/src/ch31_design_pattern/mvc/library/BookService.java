package ch31_design_pattern.mvc.library;

import java.util.ArrayList;
import java.util.Scanner;

public class BookService {
	
	ArrayList<BookData> list = new ArrayList<>();
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
			list.add(data);
		}
	}
	
	public void searchBook() {
		String value;
		boolean isBookOk = false;
		
		System.out.println("찾으시려는 책의 제목을 입력해주십시오.");
		System.out.print("제목 : "); value = sc.next();
		
		for(BookData data : list) {
			if(data.getTitle().contains(value)) {
				data.toString();
				isBookOk = true;
			}
		}
		
		if(!isBookOk) {
			System.out.println("찾으시는 제목의 도서가 존재하지 않습니다.");
		}
	}
	
	public void lendBook() {
		String code;
		int num;
		
		System.out.println("대여할 책의 코드와 권 수를 입력해주세요.");
		
		System.out.print("코드 : "); code = sc.next();
		System.out.print("권수 : "); num = sc.nextInt();
		
		for(BookData data : list) {
			if(data.getCode().equals(code)) {
				if(data.getStockCurrent() >= num) {
					System.out.println("이용해주셔서 감사합니다.");
					data.setStockCurrent(data.getStockCurrent() - num);
					return;
				}
				else {
					System.out.println("죄송합니다. 현재 도서는 " + data.getStockCurrent() + "권 남아있어서 대여가 불가능합니다.");
					System.out.println("다시 시도해주십시오.");
					return;
				}
			}
		}
		
		System.out.println(code + "에 해당하는 도서가 존재하지 않습니다.");
		System.out.println("도서 목록을 확인해주세요.");
	}
	
	public void returnBook() {
		String code;
		int num;
		
		System.out.println("반납하실 도서 정보를 입력해주세요.");
		System.out.print("코드 : "); code = sc.next();
		System.out.print("권수 : "); num = sc.nextInt();
		
		for(BookData data : list) {
			if(data.getCode().equals(code)) {
				if(data.getStockCurrent() + num <= data.getStockOrigin()) {
					System.out.println(data.getTitle() + " 도서가 " + num + "권 반납되었습니다.");
					data.setStockCurrent(data.getStockCurrent() + num);
					System.out.println("이용해주셔서 감사합니다.");
					return;
				}
				else {
					System.out.println("도서관에서 대여하신 도서가 아닌 것이 있습니다. 도서를 확인해주세요.");
					return;
				}
			}
		}
		
		System.out.println("입력 정보가 잘못되었습니다. 다시 확인해주십시오.");
		return;
	}
	
	public void getList() {
		if(list.isEmpty()) {
			System.out.println("도서가 존재하지 않습니다.");
			return;
		}
		
		System.out.println("도서 목록입니다.");
		for(BookData data : list) {
			data.toString();
		}
	}
}
