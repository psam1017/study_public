package ch08_abstract_interface_innerclass.abstractWork;

public class Abstract2 {
	public static void main(String[] args) {
		
		Pikachu pika1 = new Pikachu("피카돌이");
		System.out.println("이 포켓몬은 : " + pika1.getName());
		pika1.attack();
		pika1.sound();
		
		Eevee eevee1 = new Eevee("브이브이");
		System.out.println("이 포켓몬은 : " + eevee1.getName());
		eevee1.attack();
		eevee1.sound();
		
		Zoroark zoro = new Zoroark("조로");
		System.out.println("이 포켓몬은 : " + zoro.getName());
		zoro.attack();
		zoro.sound();
	}
}
