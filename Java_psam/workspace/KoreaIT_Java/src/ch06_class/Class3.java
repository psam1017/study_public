package ch06_class;

public class Class3 {

	public static void main(String[] args) {
		
		// ��������� ���� �����Ͽ� ���� �����ϰ� ȣ��.
		Student sAhn = new Student();
		sAhn.studentName = "�Ƚ¿�";
		
		System.out.println("��������� ���� ȣ�� : " + sAhn.studentName);
		
		
		
		// �ǹ������� �޼ҵ�� ��������� �����ϴ� �� �Ϲ����̴�.
		Student sHong = new Student();
		
		sHong.setStudentName("ȫ�浿");
		System.out.println("�޼ҵ�� ��������� ȣ�� : " + sHong.getStudentName());
	}
}
