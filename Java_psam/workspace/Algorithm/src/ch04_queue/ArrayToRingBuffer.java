package ch04_queue;

public class ArrayToRingBuffer implements ToQueue {

	private int[] queue;
	private int front, rear;
	private int capacity;
	private int size;
	
	public ArrayToRingBuffer(int length) {
		if(length > 0) {
			this.capacity = length;
			this.queue = new int[this.capacity];
			this.front = 0;
			this.rear = 0;
			this.size = 0;
		}
		else {
			throw new OutOfMemoryError();
		}
	}
	
	@Override
	public boolean enqueue(int value) {
		
		// queue�� ���� á�� ���
		if(size == capacity) {
			System.out.println("�� �̻� ť�� ���� �� �����ϴ�.");
			System.out.println("��ü ���� : " + capacity);
			System.out.println("���� ���� : " + size);
			return false;
		}
		
		// queue�� �������� �ʾ��� ��� �ڿ� �ϳ��� ���
		queue[rear] = value;
		rear++;
		size++;
		
		// rear�� ������ �� ��� �ٽ� ó������ ���ư���(ring buffer)
		if(rear == capacity) {
			rear = 0;
		}
		return true;
	}

	@Override
	public int dequeue() {
		
		// queue�� ����ִ� ���
		if(size == 0) {
			System.out.println("ť�� ��� �ֽ��ϴ�.");
			System.out.println("0�� ��ȯ�մϴ�.");
			return 0;
		}
		
		// queue�� ������� �ʾ��� ��� �տ��� �ϳ��� ��������
		int value = queue[front];
		front++;
		size--;
		
		// front�� �ձ��� �� ��� �ٽ� ó������ ���ư���(ring buffer)
		if(front == capacity) {
			front = 0;
		}
		return value;
	}

	@Override
	public int peek() {
		
		if(size == 0) {
			System.out.println("ť�� ��� �ֽ��ϴ�.");
			System.out.println("0�� ��ȯ�մϴ�.");
			return 0;
		}
		
		return queue[front];
	}

	@Override
	public void clear() {
		this.front = 0;
		this.rear = 0;
		this.size = 0;
	}

	@Override
	public int indexOf(int value) {
		
		for(int i = 0; i < this.size; i++) {
			
			int temp = (i + this.front) % this.capacity;
			
			if(queue[temp] == value) {
				System.out.println(temp + "��°���� " + value + "��/�� �߰��߽��ϴ�.");
				return value;
			}
		}
		System.out.println(value + "��/�� ã�� �� �߽��ϴ�.");
		return -1;
	}

	public int getCapacity() {
		return this.capacity;
	}
	
	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	public boolean isFull() {
		return this.size == this.capacity;
	}
	
	@Override
	public int[] dump() {
		
		if(this.size != 0) {
			
			int[] dumpedQueue = new int[this.size];
			
			for(int i = 0; i < this.size; i++) {
				
				int temp = (i + front) % this.capacity;
				dumpedQueue[i] = this.queue[temp];
			}
			return dumpedQueue;
		}
		System.out.println("ť�� ����ֽ��ϴ�.");
		return null;
	}
}
