package ch07_inheritance;

public class Instanceof3 {

	public static void main(String[] args) {
		
		Robot[] arr = {new DanceRobot(), new SingRobot(), new DrawRobot()};
		
		for(int i = 0; i < arr.length; i++)
			action(arr[i]);
		
	}
	
	public static void action(Robot r) {
		if(r instanceof DanceRobot) {
			DanceRobot dr = (DanceRobot)r;
			dr.dance();
		}
		else if(r instanceof SingRobot) {
			SingRobot sr = (SingRobot)r;
			sr.sing();
		}
		else if(r instanceof DrawRobot) {
			DrawRobot wr = (DrawRobot)r;
			wr.draw();
		}
	}
}

class Robot{}

class DanceRobot extends Robot{
	void dance() {
		System.out.println("Dance!");
	}
}

class SingRobot extends Robot{
	void sing() {
		System.out.println("Sing!!");
	}
}
class DrawRobot extends Robot{
	void draw() {
		System.out.println("Draw!");
	}
}