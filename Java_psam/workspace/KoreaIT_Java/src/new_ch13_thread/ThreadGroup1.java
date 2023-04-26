package new_ch13_thread;

public class ThreadGroup1 {
	public static void main(String[] args) {
		
		ThreadGroup main = Thread.currentThread().getThreadGroup();
		ThreadGroup grp1 = new ThreadGroup("Group1");		
		ThreadGroup grp2 = new ThreadGroup("Group2");
		
		// ThreadGroup(ThreadGroup parent, String name);
		ThreadGroup subGrp1 = new ThreadGroup(grp1, "SubGroup1");
		
		grp1.setMaxPriority(3);
		
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch(InterruptedException e) {}
			}
		};
		
		// Thread(ThreadGroup tg, Runnable r, String name)
		new Thread(grp1, r, "th1").start();
		new Thread(subGrp1, r, "th2").start();
		new Thread(grp2, r, "th3").start();
		
		System.out.println("List of ThreadGroup : " + main.getName());
		// activeGroupCount : ="쓰레드 그룹에 포함된" 활성화된 그룹 수를 반환한다. 자기 자신은 포함하지 않는다.
		System.out.println("Active ThreadGroup : " + main.activeGroupCount());
		System.out.println("Active Thread : " + main.activeCount());
		
		main.list();
	}
}
