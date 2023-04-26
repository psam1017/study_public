package ch07_inheritance;

public class ConstructTest1 {

	public static void main(String[] args) {
		
		SportCar sportCar1 = new SportCar("red", 330);
		
		System.out.println(sportCar1.color);
		System.out.println(sportCar1.speedLimit);
		
	}

}

class Car2{
	int wheel;
	int speed;
	String color;
	
	Car2(String color){
		this.color = color;
	}
}

class SportCar extends Car2{
	int speedLimit;

	public SportCar(String color, int speedLimit) {
		super(color);
		this.speedLimit = speedLimit;
	}
	
}