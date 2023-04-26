package ch06_class;

public class ClassTest3 {

	public static void main(String[] args) {
		
		TVUp myTV = new TVUp();
		
		myTV.turnOnOff();
		
		myTV.channel = 100;
		myTV.volume = 0;
		System.out.printf("CH : %d, VOL : %d\n", myTV.channel, myTV.volume); // 100, 0

		myTV.channelDown();
		myTV.volumeDown();
		System.out.printf("CH : %d, VOL : %d\n", myTV.channel, myTV.volume); // 99, 0
		
		myTV.channelUp();
		myTV.volumeUp();
		System.out.printf("CH : %d, VOL : %d\n", myTV.channel, myTV.volume); // 100, 1
		
	}

}
