package ch08_abstract_interface_innerclass.interfaceWork;

import java.io.IOException;

public class Interface4 {
	public static void main(String[] args) throws IOException {
		
		System.out.println("전화 상담 전화 방식을 선택하세요.");
		System.out.println("R : 한 명씩 차례로 할당");
		System.out.println("L : 대기가 적은 상담원에게 할당");
		System.out.println("P : 등급이 높은 고객을 먼저 할당");
		
		int ch = System.in.read();
		Scheduler sch = null;
		
		if(ch == 'R' || ch == 'r')
			sch = new RoundRobin();
		else if(ch == 'L' || ch == 'l')
			sch = new LeastJob();
		else if(ch == 'P' || ch == 'p')
			sch = new PriorityAllocation();
		else {
			System.out.println("지원하지 않는 기능입니다.");
			return;
		}
		
		sch.getNextCall();
		sch.sendCallToAgent();
	}
}
