package ch07_inheritance;

public class Instanceof2 {

	public static void main(String[] args) {
		
		FireTruck fe = new FireTruck();
		
		if(fe instanceof FireTruck)
			System.out.println("This is a FireTruck instance");
		if(fe instanceof Car)
			System.out.println("This is a Car instance");
		if(fe instanceof Object)
			System.out.println("This is a Object instance\n");
		
		
		
		Car car = new FireTruck();
		
		if(car instanceof FireTruck)
			System.out.println("This is a FireTruck instance");
		if(car instanceof Car)
			System.out.println("This is a Car instance");
		if(car instanceof Object)
			System.out.println("This is a Object instance\n");
		
		
		
		Car myCar = new Car();
		
		if(myCar instanceof FireTruck)
			System.out.println("This is a FireTruck instance");
		if(myCar instanceof Car)
			System.out.println("This is a Car instance");
		if(myCar instanceof Object)
			System.out.println("This is a Object instance");
		
	}

}
