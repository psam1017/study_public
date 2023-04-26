package new_ch13_thread;

import javax.swing.JOptionPane;

public class Thread04 {
	public static void main(String[] args) throws Exception{
		
		TimeStop ts1 = new TimeStop();
		ts1.start();
		
		String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
		System.out.println("입력하신 값은 " + input + "입니다.");
		ts1.interrupt(); // sleep() 중에 interrupt()를 호출하면 interrupted가 true가 되는 것이 아니라 InterruptedException이 발생한다.
		System.out.println("isInterrupted() : " + ts1.isInterrupted());
	}
	
	public static void delay(long millis) {
		try {
			Thread.sleep(millis);
		} catch(InterruptedException e) {}
	}
}

class TimeStop extends Thread{

	@Override
	public void run() {
		
			for(int i = 10; i > 0; i--) {
				if(!isInterrupted()) {
					try {
						System.out.println(i);
						Thread.sleep(1000);
					} catch(InterruptedException e) { // sleep() 중에 interrupt()를 호출하면 InterruptedException이 발생한다.
						interrupt();
					}
				}
			}
		
		System.out.println("카운트 다운이 종료되었습니다.");
	}
}
