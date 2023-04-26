package ch07_inheritance;

public class TV extends Product {
	
	// TV 클래스의 가격은 100만 원으로 고정.
	TV(){
		super(100);
	}

	@Override
	public String toString() {
		return "TV";
	}
}
