package ch31_design_pattern.mvc.account;

import java.util.ArrayList;
import java.util.Scanner;

public class AccountManager { // AccountController
	
	private ArrayList<AccountModel> list;
	private Scanner sc;
	
	public AccountManager() {
		list = new ArrayList<AccountModel>();
		sc = new Scanner(System.in);
	}
	
	public void makeAccount() {
		
		AccountModel account = new AccountModel();
		
		System.out.print("계좌번호 : ");
		account.setId(sc.nextInt());
		
		System.out.print("이름 : ");
		account.setName(sc.next());
		
		System.out.print("입금액 : ");
		account.setBalance(sc.nextLong());
		
		list.add(account);
		
		System.out.println("계좌가 개설되었습니다.");
		System.out.println(list.toString());
	}
	
	public void deposit() {
		
		System.out.print("계좌번호 : ");
		int id = sc.nextInt();
		
		System.out.print("입금액 : ");
		long money = sc.nextLong();
		
		for(AccountModel ac : list) {
			if(ac.getId() == id) {
				ac.setBalance(ac.getBalance() + money);
				System.out.println("입금이 완료되었습니다.");
				return;
			}
			AccountModel.noAccount();
		}
	}
	
	public long withdraw() {
		
		System.out.print("계좌번호 : ");
		int id = sc.nextInt();
		
		System.out.print("출금액 : ");
		long money = sc.nextLong();
		
		for(AccountModel ac : list) {
			if(ac.getId() == id) {
				if(ac.getBalance() < money) {
					System.out.println("잔액이 부족합니다.");
					return 0;
				}
				else {
					ac.setBalance(ac.getBalance() - money);
					System.out.println("출금이 완료되었습니다.");
					return money;
				}
			}
		}
		AccountModel.noAccount();
		return 0;
	}
	
	public void inquire() {
		
		System.out.print("계좌번호 : ");
		int id = sc.nextInt();
		
		for(AccountModel ac : list) {
			if(ac.getId() == id) {
				System.out.println(ac.toString());
				return;
			}
		}
		AccountModel.noAccount();
	}
	
	public void display() {
		for(AccountModel ac : list) {
			System.out.println(ac.toString());
		}
	}
}
