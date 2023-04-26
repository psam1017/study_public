package ch08_abstract_interface_innerclass.abstractWork;

import java.util.ArrayList;

public class Abstract5 {
	public static void main(String[] args) {
		
		ArrayList<Car> carList = new ArrayList<Car>();
		
		carList.add(new Sonata());
		carList.add(new Granduer());
		carList.add(new Avante());
		carList.add(new Genesis());
		
		for(Car c : carList) {
			c.run();
			System.out.println("=========================");
		}
	}
}
