package new_ch13_thread;

public class ThreadDeamon1 implements Runnable{
	
	static boolean autosave = false;
	
	public static void main(String[] args) {
		
		Thread t = new Thread(new ThreadDeamon1());
		t.setDaemon(true); // start()보다 먼저 실행되어야 한다.
		t.start();
		
		for(int i = 1; i <= 10; i++) {
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {}
			System.out.println(i);
			
			if(i == 5) {
				autosave = true;
				System.out.println("자동저장이 실행됩니다.");
			}
		}
		
		System.out.println("프로그램을 종료합니다.");
	}
	
	public void run() {
		while(true) {
			try {
				Thread.sleep(3 * 1000);
			} catch(InterruptedException e) {}
			
			if(autosave) {
				autosave();
			}
		}
	}
	
	public void autosave() {
		System.out.println("작업파일이 자동저장되었습니다.");
	}
}
