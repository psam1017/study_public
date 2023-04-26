package ch04_queue;

public class TrashBin<E> {
	
	private E[] bin;
	private int index;
	
	@SuppressWarnings("unchecked")
	public TrashBin(int length) {
		try {
			this.index = 0;
			this.bin = (E[])new Object[length];
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void put(E value) {
		bin[index] = value;
		index++;
		index %= bin.length;
	}
	
	public void show() {
		int i = 0;
		boolean isEmpty = true;
		for(E element : bin) {
			if(element != null) {
				System.out.println(i + "번째 값 : " + element);
				isEmpty = false;
			}
			i++;
		}
		if(isEmpty) {
			System.out.println("휴지통이 비어 있습니다.");
		}
	}
	
	public E restore(int key) {
		System.out.println(key + "번째에 있는 값을 복구합니다.");
		E value = bin[key];
		bin[key] = null;
		return value;
	}
	
	public void clear() {
		for(int i = 0; i < bin.length; i++) {
			bin[i] = null;
		}
	}
}
