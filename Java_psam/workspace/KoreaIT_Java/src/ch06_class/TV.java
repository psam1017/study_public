package ch06_class;

// Class 2���� ���
public class TV {
	
	// �������, �ʵ�, ...
	String color;
	boolean power;
	int channel;
	
	// �޼���
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
