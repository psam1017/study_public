package ch12_collection.generics;

public class Generics04 {
	public static void main(String[] args) {
		
		Final f = new Final();
		GenericInheritance<Final> gi = new GenericInheritance<>(f);
		
		System.out.println(gi.compare(f));
	}
}

interface First{
	abstract int getInt();
}

interface Second{
	abstract boolean getBoolean();
}

class Third{
	String getString() {
		return "String";
	}
}

class Final extends Third implements First, Second{

	@Override
	public boolean getBoolean() {
		return false;
	}

	@Override
	public int getInt() {
		return 0;
	}
	
}

// GenericInheritance의 T는 Thrid를 상속 받고, First와 Second를 구현하고 있어야 한다.

class GenericInheritance<T extends Third & First & Second>{
	
	private T type;
	
	public GenericInheritance(T type){
		this.type = type;
	}
	
	public boolean compare(T otherType) {
		return type.equals(otherType);
	}
}