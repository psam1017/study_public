package ch06_class;

public class ClassTest2 {

	public static void main(String[] args) {
		
		StudentTest sHong = new StudentTest("ȫ�浿", 1, 1, 100, 76, 60);
		
		System.out.println(sHong.name);
		System.out.println(sHong.getTotal());
		System.out.printf("%.2f", sHong.getAverage());
	}
}

// �ǽ��� ���� ClassTest2���� StudentTest ����
class StudentTest{
	
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	
	public StudentTest() {}
	
	public StudentTest(String name, int ban, int no, int kor, int eng, int math) {
		super();
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	int getTotal() {
		return this.kor + this.eng + this.math;
	}
	
	float getAverage() {
		return (this.kor + this.eng + this.math) / (float)3;
	}
	
}
