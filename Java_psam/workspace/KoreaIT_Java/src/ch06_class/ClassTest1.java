package ch06_class;

public class ClassTest1 {

	public static void main(String[] args) {
		
		// 은행계좌 데이터를 취급하는 프로그램
		// Constructor, Getter, Setter 외 메소드 생성
		AccountInfo cs = new AccountInfo("철수", "1234", 1000);
		AccountInfo yh = new AccountInfo("영희", "5678", 500);
		
		//cs.setAccountName("철수");
		//cs.setAccountNo("1234");
		//cs.setAccountBalance(1000);
		//yh.setAccountName("영희");
		//yh.setAccountNo("5678");
		//yh.setAccountBalance(500);
		
		cs.withdraw(200);
		yh.deposit(100);
		
		cs.getInfo();
		yh.getInfo();
		
	}

}
