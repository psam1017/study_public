package ch06_class;

public class Class4 {
	public static void main(String[] args) {
		
	CellPhone cp = new CellPhone("Silver", 128);
	
	System.out.println(cp.model);
	System.out.println(cp.color);
	System.out.println(cp.capacity);
	
	}
}

// 실습을 위해 Class4에서 CellPhone Class 생성
class CellPhone{
	
	String model = "Galaxy 8";
	String color;
	int capacity;
	
	// ch_07의 Constructor 참고.
	public CellPhone() {}
	
	public CellPhone(String color, int capacity) {
		super();
		this.color = color;
		this.capacity = capacity;
	}
}