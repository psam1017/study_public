package ch31_design_pattern.adapter;

public class NotAdapter {
	public static void main(String[] args) {
		
		ServiceA sa = new ServiceA();
		ServiceB sb = new ServiceB();
		
		sa.runWork();
		sb.runStudy();
	}
}

class ServiceA{
	void runWork() {
		System.out.println("Work");
	}
}

class ServiceB{
	void runStudy() {
		System.out.println("Study");
	}
}
