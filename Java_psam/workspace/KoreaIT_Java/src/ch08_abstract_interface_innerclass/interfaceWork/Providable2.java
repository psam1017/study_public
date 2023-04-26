package ch08_abstract_interface_innerclass.interfaceWork;

public class Providable2 {}

class KoreaTour implements Providable1{

	@Override
	public void leisureSports() {
		System.out.println("한강 수상스키 투어");
	}

	@Override
	public void sightseeing() {
		System.out.println("경복궁 관람 투어");
	}

	@Override
	public void food() {
		System.out.println("전주 비빔밥 투어");
	}
}

class TourGuide{
	
	// 생성자로 Providable 인터페이스를 구현한 인스턴스들을 받아와 업캐스팅하여 일괄 사용
	private Providable1 tour;
	TourGuide(Providable1 p){
		tour = p;
	}
	
	// 오버라이드가 아님에 주의.
	public void leisureSports() {
		tour.leisureSports();
	}
	
	public void sightSeeing() {
		tour.sightseeing();
	}
	
	public void food() {
		tour.food();
	}
}
