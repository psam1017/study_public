package ch06_class;

// ClassTest1에서 사용
public class AccountInfo {
	
	String accountName;
	String accountNo;
	long accountBalance;
	
	public AccountInfo() {}
	
	public AccountInfo(String accountName, String accountNo, long accountBalance) {
		super();
		this.accountName = accountName;
		this.accountNo = accountNo;
		this.accountBalance = accountBalance;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public long getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(long accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	public void deposit(int money) {
		this.accountBalance += money;
		System.out.println(money + "원을 입금했습니다.");
		System.out.println(this.accountName + " 잔액 : " + this.accountBalance);
	}
	
	public void withdraw(int money) {
		this.accountBalance -= money;
		System.out.println(money + "원을 인출했습니다.");
		System.out.println(this.accountName + " 잔액 : " + this.accountBalance);
	}
	
	public void getInfo() {
		System.out.println("---" + accountName + "의 계좌---");
		System.out.println("계좌명의 : " + this.getAccountName());
		System.out.println("계좌번호 : " + this.getAccountNo());
		System.out.println("예금잔고 : " + this.getAccountBalance());
	}
}
