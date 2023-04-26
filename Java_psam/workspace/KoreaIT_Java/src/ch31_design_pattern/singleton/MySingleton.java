package ch31_design_pattern.singleton;

public class MySingleton {
	
	private int page;
	
	private static MySingleton singletonObject; // 참조변수 private으로 선언
	
	private MySingleton() {} // 생성자 private으로 선언
	
	public static MySingleton getInstance() {
		if(singletonObject == null)
			singletonObject = new MySingleton(); // 단 하나만의 인스턴스를 생성
		return singletonObject;
	}
	
	public int getPage() {
		return page;
	}
	
	public void setPage(int page) {
		this.page = page;
	}
}
