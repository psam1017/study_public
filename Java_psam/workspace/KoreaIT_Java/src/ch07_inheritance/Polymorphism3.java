package ch07_inheritance;

import java.util.Scanner;

public class Polymorphism3 {
	public static void main(String[] args) {
		
		// Zookeeper는 Animal 타입 객체에 먹이를 줄 수 있다.
		// Lion은 Animal을 상속받기 때문에, lion1 인스턴스는 Zookeeper에게 먹이를 받을 수 있다.
		// Animal 타입으로 생성된 lion2가 Lion 클래스로 업캐스팅됐을 때, lion2는 여전히 Animal 타입이므로 먹이를 받을 수 있다.
		
		Zookeeper james = new Zookeeper();
		
		System.out.println("Animal을 상속 받은 lion 타입의 인스턴스");
		Lion lion1 = new Lion();
		james.feed(lion1);
		
		System.out.println("\nAnimal 타입이 자식 인스턴스를 참조. 즉, 업캐스팅");
		Animal lion2 = new Lion();
		james.feed(lion2);
		
		
		
		// 부모 타입 참조변수만 생성하고, 어느 자식 인스턴스를 참조할지 모르는 상태일 때 유용하다.
		
		Animal animal = null;
		Scanner sc = new Scanner(System.in);
		String which = "";
		
		System.out.println("\n\n배고픈 동물은 누구인가요? 1. lion 2. rabbit 3. cat");
		which = sc.next();
		
		if(which.equals("lion"))
			animal = new Lion();
		else if(which.equals("rabbit"))
			animal = new Rabbit();
		else if(which.equals("cat"))
			animal = new Cat();
		
		james.feed(animal);
		
		System.out.println("\n\n심심한 동물은 누구인가요? 1. lion 2. rabbit 3. cat");
		which = sc.next();
		
		if(which.equals("lion"))
			animal = new Lion();
		else if(which.equals("rabbit"))
			animal = new Rabbit();
		else if(which.equals("cat"))
			animal = new Cat();
		
		james.play(animal);
		
		sc.close();
		
	}
}

class Zookeeper{
	void feed(Animal animal) { System.out.println(animal + "에게 먹이 주기"); }
	void play(Animal animal) { System.out.println(animal + "와 놀아주기"); }
}

class Animal{
	void breathe() { System.out.println("숨쉬기"); }
}

class Lion extends Animal{
	@Override
	public String toString() { return "사자"; }
}

class Rabbit extends Animal{
	@Override
	public String toString() { return "토끼"; }
}

class Cat extends Animal{
	@Override
	public String toString() { return "고양이"; }
}
