package ch31_design_pattern.singleton;

class Company{
	
	// 1. 생성자를 private으로 구현
	// 2. 클래스 내부에 static으로 유일한 인스턴스 생성하기
	// 3. 외부에서 참조할 수 있는 public 메소드 만들기
	
	private Company() {}
	
	// 아직은 '객체'를 생성하진 않는다. 쓸지 안 쓸지 정해져있지 않은데, 벌써 만들면 자원만 소모된다.
	private static Company instance = null;

	// 객체를 가져오는 메소드가 호출되면 그때 객체를 생성한다.
	public static Company getInstance() {
		if(instance == null)
			instance = new Company();
		return instance;
	}
}
