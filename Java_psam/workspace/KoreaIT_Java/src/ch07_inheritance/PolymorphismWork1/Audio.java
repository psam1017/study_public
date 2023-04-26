package ch07_inheritance.PolymorphismWork1;

public class Audio extends Product {
		
	// Computer 클래스의 가격은 200만 원으로 고정.
	Audio(){
		super(50);
	}

	@Override
	public String toString() {
		return "Audio";
	}
}
