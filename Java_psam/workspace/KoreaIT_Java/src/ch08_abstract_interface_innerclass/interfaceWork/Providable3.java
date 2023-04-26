package ch08_abstract_interface_innerclass.interfaceWork;

public class Providable3 {}

class JapanTour implements Providable1{

	@Override
	public void leisureSports() {
		System.out.println("도쿄타워 번지점프 투어");
	}

	@Override
	public void sightseeing() {
		System.out.println("오사카 관람 투어");
	}

	@Override
	public void food() {
		System.out.println("스시 투어");
	}
	
}
