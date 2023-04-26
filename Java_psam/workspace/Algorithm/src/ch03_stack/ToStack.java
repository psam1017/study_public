package ch03_stack;

public interface ToStack {
	
	// 스택 예시 : 자바 프로그램이 메소드를 호출할 때 스택을 사용한다.
	// dump 메소드를 구현할 때는, 바닥부터 반환하도록 해야 한다. 그 이후 stack을 모두 비운다.
	public boolean push(int value);
	public int pop();
	public int peek();
	public void clear();
	public int indexOf(int value);
	public int size();
	public boolean isEmpty();
	public int[] dump();
}
