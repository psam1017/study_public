package ch07_inheritance.PolymorphismWork2;

public class Test2 {
	public static void main(String[] args) {
		
		Pet[] array = {
				new Pet("Kurt", "아이1"),
				new RobotPet("R2D2", "루크"),
				new RobotPet("toy", "아이2")
		};
		
		for(Pet pet : array) {
			pet.introduce();
			System.out.println();
		}
	}
}
