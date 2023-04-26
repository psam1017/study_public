package ch06_class;

// ClassTest3에서 사용
public class TVUp {
	
	boolean isPowerOn;
	int channel, volume;
	
	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 1;
	
	void turnOnOff() {
		isPowerOn = !isPowerOn;
	}
	
	void volumeUp() {
		if(isPowerOn)
			volume = volume >= MAX_VOLUME ? MAX_VOLUME : ++volume;
	}
	
	void volumeDown() {
		if(isPowerOn)
			volume = volume <= MIN_VOLUME ? MIN_VOLUME : --volume;
	}
	
	void channelUp() {
		if(isPowerOn)
			channel = channel >= MAX_CHANNEL ? MAX_CHANNEL : ++channel;
	}
	
	void channelDown() {
		if(isPowerOn)
			channel = channel <= MIN_CHANNEL ? MIN_CHANNEL : --channel;
	}
}
