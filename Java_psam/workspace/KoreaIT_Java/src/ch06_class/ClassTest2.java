package ch06_class;

public class ClassTest2 {

	public static void main(String[] args) {
		
		StudentTest sHong = new StudentTest("홍길동", 1, 1, 100, 76, 60);
		
		System.out.println(sHong.name);
		System.out.println(sHong.getTotal());
		System.out.printf("%.2f", sHong.getAverage());
	}
}

// 실습을 위해 ClassTest2에서 StudentTest 생성
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
