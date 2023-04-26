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
		
		// queue가 가득 찼을 경우
		if(size == capacity) {
			System.out.println("더 이상 큐에 담을 수 없습니다.");
			System.out.println("전체 길이 : " + capacity);
			System.out.println("현재 길이 : " + size);
			return false;
		}
		
		// queue가 가득차지 않았을 경우 뒤에 하나씩 담기
		queue[rear] = value;
		rear++;
		size++;
		
		// rear가 끝까지 돈 경우 다시 처음으로 돌아가기(ring buffer)
		if(rear == capacity) {
			rear = 0;
		}
		return true;
	}

	@Override
	public int dequeue() {
		
		// queue가 비어있는 경우
		if(size == 0) {
			System.out.println("큐가 비어 있습니다.");
			System.out.println("0을 반환합니다.");
			return 0;
		}
		
		// queue가 비어있지 않았을 경우 앞에서 하나씩 가져오기
		int value = queue[front];
		front++;
		size--;
		
		// front가 앞까지 돈 경우 다시 처음으로 돌아가기(ring buffer)
		if(front == capacity) {
			front = 0;
		}
		return value;
	}

	@Override
	public int peek() {
		
		if(size == 0) {
			System.out.println("큐가 비어 있습니다.");
			System.out.println("0을 반환합니다.");
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
				System.out.println(temp + "번째에서 " + value + "을/를 발견했습니다.");
				return value;
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
		System.out.println("큐가 비어있습니다.");
		return null;
	}
}
