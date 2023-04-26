package ch04_queue;

public interface ToQueue {
	
	public boolean enqueue(int value);
	public int dequeue();
	public int peek();
	public void clear();
	public int indexOf(int value);
	public int size();
	public boolean isEmpty();
	public int[] dump();
}
