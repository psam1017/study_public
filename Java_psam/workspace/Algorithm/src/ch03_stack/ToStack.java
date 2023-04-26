package ch03_stack;

public interface ToStack {
	
	// ���� ���� : �ڹ� ���α׷��� �޼ҵ带 ȣ���� �� ������ ����Ѵ�.
	// dump �޼ҵ带 ������ ����, �ٴں��� ��ȯ�ϵ��� �ؾ� �Ѵ�. �� ���� stack�� ��� ����.
	public boolean push(int value);
	public int pop();
	public int peek();
	public void clear();
	public int indexOf(int value);
	public int size();
	public boolean isEmpty();
	public int[] dump();
}
