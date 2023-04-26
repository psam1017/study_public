package new_ch13_thread;

import javax.swing.JOptionPane;

public class Thread03 {
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Timer());
		t1.start();
		
		String input = JOptionPane.showInputDialog("아무 값이나 입력해보세요.");
		System.out.println("입력하신 값은 " + input + "입니다.");
	}
}

class Timer implements Runnable{

	@Override
	public void run() {
		System.out.println("Timer를 시작합니다.");
		for(int i = 10; i > 0; i--) {
			System.out.println(i);
			try {
				Thread.currentThread();
				Thread.sleep(1000);
			} catch(Exception e) {}
		}
		System.out.println("Timer를 종료합니다.");
	}
}