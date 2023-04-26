package ch08_abstract_interface_innerclass.test;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ShopProduct sp = new ShopProduct();
		ShopCart sc = new ShopCart();
		String memberID;
		String password;
		String name;
		
		System.out.println("01. 회원가입 시작");
		System.out.println("회원님의 정보를 입력해주세요.");
		
		System.out.print("아이디 : ");
		memberID = input.nextLine();
		System.out.print("비밀번호 : ");
		password = input.nextLine();
		System.out.print("이름 : ");
		name = input.nextLine();
		
		MemberInsert mi = new MemberInsert(memberID, password, name);
		mi.updateAddInfo(); // 추가 정보 입력
		mi.printMemberInfo(); // 회원 가입 정보 출력
		System.out.println("회원이 되신 것을 축하드립니다.");
		System.out.println("01. 회원가입 종료");
		
		System.out.println("02. 로그인 시작");
		mi.login();
		System.out.println("02. 로그인 종료");
		
		System.out.println("03. 장바구니 시작");
		System.out.println("상점에서 구매 가능한 상품입니다.");
		sp.printProduct();
		sc.selectProduct();
		System.out.println("장바구니에 담긴 상품은 아래와 같습니다.");
		sc.printCart();
		System.out.println("03. 장바구니 종료");

		input.close();
	}
}
