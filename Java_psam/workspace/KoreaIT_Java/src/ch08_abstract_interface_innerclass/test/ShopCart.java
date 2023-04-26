package ch08_abstract_interface_innerclass.test;

import java.util.Scanner;

public class ShopCart {
	// 중복되는 상품은 합치지 않고, Array를 이용하여 별도의 객체로 취급
	Scanner sc = new Scanner(System.in);
	int length = 10;
	Cart[] cArray = new Cart[length];
	int i = 0;
	
	public void selectProduct() {
		while(true) {
			int productID, cnt;
			String isMore;
			
			try {
				System.out.print("구매할 상품의 번호 : ");
				productID = Integer.parseInt(sc.nextLine());
				System.out.print("구매할 상품의 개수 : ");
				cnt = Integer.parseInt(sc.nextLine());
				
				cArray[i] = new Cart(productID, cnt);
				i++;
			} catch (NumberFormatException e) {
				System.out.println("잘못된 값이 입력되었습니다.");
			}
			
			if(i > (length - 1)) {
				System.out.println("장바구니가 가득 찼습니다.");
				return;
			}
			System.out.print("계속해서 구매하시려면 Y 또는 y를 입력하세요.");
			isMore = sc.nextLine();
			if(!(isMore.equals("Y") || isMore.equals("y"))) {
				return;
			}
		}
	}
	
	public void printCart() {
		for(Cart c : cArray) {
			if(c != null) {
				System.out.println(c.toString());
			}
		}
	}
}
