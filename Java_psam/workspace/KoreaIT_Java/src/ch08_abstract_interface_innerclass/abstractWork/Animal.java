package ch08_abstract_interface_innerclass.abstractWork;

public abstract class Animal {
	
	private String name;

	public Animal(String name) {
		this.name = name;
	}
	
	public abstract void bark();
	public abstract String toString();
	
	public String getName() { return this.name; }
	
	public void introduce() {
		System.out.println(toString() + "입니다.");
		bark();
	}
}

class Cat extends Animal{
	private int age;

	public Cat(String name, int age) {
		super(name);
		this.age = age;
	}
	
	@Override
	public String toString() {
		return age + "살인 " + getName();
	}
	
	@Override
	public void bark() {
		System.out.println("야옹!");
	}
}

class Dog extends Animal{
	private String type;
	
	public Dog(String name, String type) {
		super(name);
		this.type = type;
	}
	
	@Override
	public String toString() {
		return type + "인 " + getName();
	}
	
	@Override
	public void bark() {
		System.out.println("멍멍!");
	}
}
