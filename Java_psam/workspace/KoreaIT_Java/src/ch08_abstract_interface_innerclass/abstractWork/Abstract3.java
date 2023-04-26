package ch08_abstract_interface_innerclass.abstractWork;

public class Abstract3 {
	public static void main(String[] args) {
		
		// 추상클래스를 업캐스팅하여 사용.
		Animal[] animals = {
				new Dog("바둑이", "삽살개"),
				new Cat("아롱이", 7),
				new Dog("백두", "진돗개")
		};
		
		for(Animal a : animals) {
			a.introduce();
			System.out.println();
		}
		
	}
}
