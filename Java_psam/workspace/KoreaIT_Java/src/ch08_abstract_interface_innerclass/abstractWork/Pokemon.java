package ch08_abstract_interface_innerclass.abstractWork;

public abstract class Pokemon {
	
	String name = "포켓몬";
	
	abstract void attack();
	abstract void sound();
	
	public String getName() {
		return this.name;
	}
}

// name 변수를 선언했으나 getName()을 오버라이딩하지 않았으므로 Pokemon 클래스의 멤버만이 활용된다.
class Eevee extends Pokemon{
	String name;
	
	Eevee(){
		this.name = "이브이";
	}
	Eevee(String name){
		this.name = name;
	}

	@Override
	void attack() {
		System.out.println("몸통박치기");
	}

	@Override
	void sound() {
		System.out.println("브이브이!");
	}
}

// name 변수를 선언하고 getName()을 오버라이딩했으므로 Zoroark에서 오버라이딩한 멤버가 활용된다.
class Zoroark extends Pokemon{
	String name;
	
	Zoroark(){
		this.name = "조로아크";
	}
	Zoroark(String name){
		this.name = name;
	}
	
	@Override
	void attack() {
		System.out.println("천추지한");
	}
	
	@Override
	void sound() {
		System.out.println("조로조로!");
	}
	
	public String getName() {
		return this.name;
	}
}

// 굳이 name을 선언하지도 않고, getName() 메소드도 오버라이드하지 않았다.
// -> Pokemon에 name이 저장되고, 같은 클래스 안에 있는 getName() 메소드를 통해 this.name이 반환된다.
// -> Pikachu 클래스는 Pokemon의 멤버를 상속받았기 때문에 아래의 경우 super.name과 this.name은 실질적으로 같다.
class Pikachu extends Pokemon{
	Pikachu(){
		this.name = "피카츄";
	}
	Pikachu(String name){
		this.name = name;
	}
	
	@Override
	void attack() {
		System.out.println("십만 볼트");
	}
	
	@Override
	void sound() {
		System.out.println("피카피카");
	}
}