package ch03_stack;

import java.util.ArrayList;
import java.util.List;

public class ArrayListToStack implements ToStack {

	private List<Integer> list;
	
	public ArrayListToStack() {
		this.list = new ArrayList<>();
	}
	
	@Override
	public boolean push(int value) {
		list.add(value);
		return true;
	}

	@Override
	public int pop() {
		if(!list.isEmpty()) {
			return list.remove(list.size() - 1);
		}
		System.out.println("큐가 비어 있습니다.");
		System.out.println("0을 반환합니다.");
		return 0;
	}

	@Override
	public int peek() {
		if(!list.isEmpty()) {
			return list.get(list.size() - 1);
		}
		System.out.println("큐가 비어 있습니다.");
		System.out.println("0을 반환합니다.");
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
		System.out.println("큐가 비어 있습니다.");
		System.out.println("-1을 반환합니다.");
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
			System.out.println("스택이 비어있습니다.");
			return null;
		}
	}
}
