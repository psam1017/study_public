package ch31_design_pattern.adapter;

public class Adapter01 {
	public static void main(String[] args) {
		
		AdapterServiceA asa = new AdapterServiceA();
		AdapterServiceB asb = new AdapterServiceB();
		
		// 디자인 패턴을 활용한 예시
		asa.runService();
		asb.runService();
	}
}

class AdapterServiceA{
	ServiceA sa = new ServiceA();
	void runService() { // 다른 이름의 메소드를 통합
		sa.runWork();
	}
}

class AdapterServiceB{
	ServiceB sb = new ServiceB();
	void runService() { // 다른 이름의 메소드를 통합
		sb.runStudy();
	}
}
