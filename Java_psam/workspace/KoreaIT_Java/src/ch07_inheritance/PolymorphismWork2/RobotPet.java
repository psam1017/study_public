package ch07_inheritance.PolymorphismWork2;

public class RobotPet extends Pet{
	
	public RobotPet(String name, String masterName) {
		super(name, masterName);
	}

	@Override
	public void introduce() {
		System.out.println("삐쀼삐! 내 이름은 " + getName() + "입니다.");
		System.out.println("삐쀼삐! 내 주인 이름은 " + getMasterName() + "입니다.");
	}
	
	public void work(int sw) {
		switch(sw) {
		case 0:
			System.out.println("청소를 합니다.");
			break;
		case 1:
			System.out.println("빨래를 합니다.");
			break;
		case 2:
			System.out.println("밥을 짓습니다.");
			break;
		}
	}
}
