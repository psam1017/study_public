package ch12_collection.stack_queue_;

import java.util.LinkedList;

public class LinkedListToQueue {
	public static void main(String[] args) {
		
		MyQueue queue = new MyQueue();
		queue.enQueue("A");
		queue.enQueue("B");
		queue.enQueue("C");
		
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
	}
}

class MyQueue{
	
	private LinkedList<String> linkedList = new LinkedList<String>();
	
	public void enQueue(String data) {
		linkedList.add(data);
	}
	
	public String deQueue() {
		int len = linkedList.size();
		
		if(len == 0) {
			return "큐가 비었습니다.";
		}
		return linkedList.remove(0);
	}
}