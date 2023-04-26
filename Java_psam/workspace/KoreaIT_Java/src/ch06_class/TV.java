package ch06_class;

// Class 2에서 사용
public class TV {
	
	// 멤버변수, 필드, ...
	String color;
	boolean power;
	int channel;
	
	// 메서드
	void power() {
		power = !power;
	}
	void channelUp() {
		++channel;
	}
	void channelDown() {
		--channel;
	}
	
}
