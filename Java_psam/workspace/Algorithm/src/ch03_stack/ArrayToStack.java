package ch03_stack;

public class ArrayToStack implements ToStack{
	
	private int ptr;
	private int capacity;
	private int[] stack;
	
	public ArrayToStack(int length) {
		this.ptr = 0;
		if(length > 0) {
			this.capacity = length;
			stack = new int[this.capacity];
		}
		else {
			throw new OutOfMemoryError();
		}
	}

	@Override
	public boolean push(int value) {
		if(ptr < capacity) {
			stack[ptr] = value;
			ptr++;
			return true;
		}
		else {
			System.out.println("stack에 더 이상 넣을 수 없습니다.");
			System.out.println("전체 길이 : " + capacity);
			System.out.println("현재 길이 : " + ptr);
			return false;
		}
	}

	@Override
	public int pop() {
		if(ptr > 0) {
			ptr--;
			return stack[ptr];
		}
		else {
			// 0을 반환하는 대신 예외를 던져도 된다.
			System.out.println("스택이 비어 있습니다.");
			System.out.println("0을 반환합니다.");
			return 0;
		}
	}

	@Override
	public int peek() {
		if(ptr > 0) {
			return stack[ptr - 1];
		}
		else {
			System.out.println("스택이 비어있습니다.");
			System.out.println("0을 반환합니다.");
			return 0;
		}
	}

	@Override
	public void clear() {
		ptr = 0;
	}

	@Override
	public int indexOf(int value) {
		
		for(int i = 0; i < stack.length; i++) {
			if(stack[i] == value) {
				System.out.println(i + "번째에서 " + value + "을/를 발견했습니다.");
				return i;
			}
		}
		System.out.println(value + "을/를 찾지 못 했습니다.");
		return -1;
	}

	public int getCapacity() {
		return this.capacity;
	}

	@Override
	public int size() {
		return this.ptr;
	}

	@Override
	public boolean isEmpty() {
		return this.ptr == 0;
	}

	public boolean isFull() {
		return ptr == capacity;
	}

	@Override
	public int[] dump() {
		
		if(ptr != 0) {
			int[] dumpedStack = new int[ptr];
			
			for(int i = 0; i < ptr; i++) {
				System.out.println(i + " : " + dumpedStack[i]);
			}
			
			ptr = 0;
			
			return dumpedStack;
		}
		else {
			System.out.println("스택이 비어있습니다.");
			return null;
		}
	}
}
