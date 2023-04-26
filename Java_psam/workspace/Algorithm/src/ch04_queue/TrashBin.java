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
				System.out.println(i + "��° �� : " + element);
				isEmpty = false;
			}
			i++;
		}
		if(isEmpty) {
			System.out.println("�������� ��� �ֽ��ϴ�.");
		}
	}
	
	public E restore(int key) {
		System.out.println(key + "��°�� �ִ� ���� �����մϴ�.");
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
