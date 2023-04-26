package new_ch13_thread;

public class Thread05 {
	public static void main(String[] args) {
		
		Thread5 t1 = new Thread5();
		Thread5 t2 = new Thread5();
		
		t1.setName("☆");
		t2.setName("★");
		t1.setPriority(1);
		t2.setPriority(10); // t2의 우선순위를 더 높게. 하지만 멀티코어에서는 큰 차이가 없다.
		
		t1.start();
		t2.start();
		
		try {
			Thread.sleep(500);
			t1.interrupt();
		} catch (InterruptedException e) {}
	}
}

class Thread5 extends Thread{
	
	@Override
	public void run() {
		
		boolean isInterrupted = false;
		
		for(int i = 0; i < 10; i++) {
				for(int j = 0; j < 10; j++) {
					if(!isInterrupted) {
						try {
							Thread.sleep(10);
							System.out.print(this.getName());
						} catch (InterruptedException e) {
							isInterrupted = true;
							System.out.println("\n-------------");
							System.out.println(this.getName() + "is stopped!");
							System.out.println("-------------");
						}
					} else {
						Thread.yield(); // yield 구문을 넣음으로써 응답성이 더 좋아진다.
				}
			}
			if(!isInterrupted) {
				System.out.println();
			}
		}
	}
}