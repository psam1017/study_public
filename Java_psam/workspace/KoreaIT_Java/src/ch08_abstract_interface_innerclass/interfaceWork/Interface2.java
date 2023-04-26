package ch08_abstract_interface_innerclass.interfaceWork;

public class Interface2 {
	public static void main(String[] args) {
		
		TourGuide guide = new TourGuide(new KoreaTour());
		guide.leisureSports();
		guide.sightSeeing();
		guide.food();
		
		System.out.println();
		
		TourGuide guide2 = new TourGuide(new JapanTour());
		guide2.leisureSports();
		guide2.sightSeeing();
		guide.food();
	}
}
