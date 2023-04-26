package ch07_inheritance.PolymorphismWork2;

public class Test1 {

	public static void main(String[] args) {
		
		Pet kurt = new Pet("Kurt", "아이1");
		kurt.introduce();
		System.out.println();
		
		RobotPet r2d2 = new RobotPet("R2D2", "루크");
		r2d2.introduce();
		r2d2.work(0);
		System.out.println();
		
		
		
		Pet toy = new RobotPet("toy", "아이2");
		toy.introduce();
//		toy.work(); // 부모 클래스에 없는 메소드
		System.out.println();
		
		
		
		Pet p = r2d2;
		p.introduce();
//		p.work(); // 부모 클래스에 없는 메소드
		System.out.println();
		
		r2d2.setName("아이로봇");
		r2d2.introduce();
		p.introduce();
	}

}
