package ch06_class;

// ClassTest1���� ���
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
		System.out.println(money + "���� �Ա��߽��ϴ�.");
		System.out.println(this.accountName + " �ܾ� : " + this.accountBalance);
	}
	
	public void withdraw(int money) {
		this.accountBalance -= money;
		System.out.println(money + "���� �����߽��ϴ�.");
		System.out.println(this.accountName + " �ܾ� : " + this.accountBalance);
	}
	
	public void getInfo() {
		System.out.println("---" + accountName + "�� ����---");
		System.out.println("���¸��� : " + this.getAccountName());
		System.out.println("���¹�ȣ : " + this.getAccountNo());
		System.out.println("�����ܰ� : " + this.getAccountBalance());
	}
}
