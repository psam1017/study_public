package ch06_class;

public class ClassTest1 {

	public static void main(String[] args) {
		
		// ������� �����͸� ����ϴ� ���α׷�
		// Constructor, Getter, Setter �� �޼ҵ� ����
		AccountInfo cs = new AccountInfo("ö��", "1234", 1000);
		AccountInfo yh = new AccountInfo("����", "5678", 500);
		
		//cs.setAccountName("ö��");
		//cs.setAccountNo("1234");
		//cs.setAccountBalance(1000);
		//yh.setAccountName("����");
		//yh.setAccountNo("5678");
		//yh.setAccountBalance(500);
		
		cs.withdraw(200);
		yh.deposit(100);
		
		cs.getInfo();
		yh.getInfo();
		
	}

}
