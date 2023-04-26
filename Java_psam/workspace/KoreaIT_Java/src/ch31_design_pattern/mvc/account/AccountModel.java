package ch31_design_pattern.mvc.account;

public class AccountModel {
	
	private int id;
	private String name;
	private long balance;
	
	public AccountModel() {}

	public AccountModel(int id, String name, long balance) {
		this.id = id;
		this.name = name;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return name + " 님의 계좌 " + id + "의 잔액은 " + balance + "원입니다.";
	}
	
	// bad -> 안내메시지들을 모두 모아 배열에 저장을 하고, 배열에서 각 메시지를 확인할 수 있도록 구성해야 한다.
	// 즉, index, value 등을 활용하면서 최대한 구조화하는 것이 좋다.
	public static String noAccount() {
		return "존재하지 않는 계좌입니다.";
	}
}
