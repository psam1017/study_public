package new_ch13_thread;

public class Thread02 {
	public static void main(String[] args) {
		
		CTThread ctt = new CTThread();
		Thread itt = new Thread(new ITThread());
		
		ctt.run();
		itt.run();
		// 결과가 항상 같다. 왜냐하면 새로운 스레드가 생성되지 않고 그저 run()이라는 메소드를 실행할 뿐이기 때문.
		
		ctt.start();
		itt.start();
		// 결과가 항상 다르다. 왜냐하면 컴퓨터 리소스가 번갈아가면서 새로 생성된 스레드에게 할당되기 때문.
		// start 메소드는 단 한 번만 호출이 가능하다. 2번 이상 호출하면 오류가 발생한다.
	}
}

class CTThread extends Thread{

	public void run() {
		for(int i = 0; i < 5; i++) {
			System.out.println(getName());
		}
	}
}

class ITThread implements Runnable{
	
	// Runnable의 멤버에는 run밖에 없으므로 현재 실행중인 스레드 참조를 얻어와야만 호출이 가능하다.
	public void run() {
		for(int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName());
		}
	}
}