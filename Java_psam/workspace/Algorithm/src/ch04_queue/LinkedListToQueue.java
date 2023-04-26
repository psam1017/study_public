package ch04_queue;

import java.util.LinkedList;
import java.util.List;

public class LinkedListToQueue implements ToQueue {

	private List<Integer> list;
	
	public LinkedListToQueue() {
		list = new LinkedList<>();
	}
	
	@Override
	public boolean enqueue(int value) {
		list.add(value);
		return true;
	}

	@Override
	public int dequeue() {
		if(!list.isEmpty()) {
			return list.remove(0);
		}
		System.out.println("ť�� ��� �ֽ��ϴ�.");
		System.out.println("0�� ��ȯ�մϴ�.");
		return 0;
	}
	
	@Override
	public int peek() {
		if(!list.isEmpty()) {
			return list.get(0);
		}
		System.out.println("ť�� ��� �ֽ��ϴ�.");
		System.out.println("0�� ��ȯ�մϴ�.");
		return 0;
	}

	@Override
	public void clear() {
		list.clear();
	}

	@Override
	public int indexOf(int value) {
		if(!list.isEmpty()) {
			return list.indexOf(value);
		}
		System.out.println("ť�� ��� �ֽ��ϴ�.");
		System.out.println("-1�� ��ȯ�մϴ�.");
		return -1;
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public int[] dump() {
		if(!list.isEmpty()) {
			int[] array = new int[list.size()];
			for(int i = 0; i < list.size(); i++) {
				array[i] = list.get(i);
			}
			list.clear();
			return array;
		}
		else {
			System.out.println("ť�� ����ֽ��ϴ�.");
			return null;
		}
	}
}
