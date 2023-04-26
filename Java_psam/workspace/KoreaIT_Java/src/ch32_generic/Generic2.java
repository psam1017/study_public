package ch32_generic;



// 상세한 내용은 ch12_collection.generics를 참고!



public class Generic2 {
	public static void main(String[] args) {
		
		// 제네릭을 쓰는 경우 : 호출하는 쪽에서 타입을 지정하기 위해서
		
		CommonData<String> scd = new CommonData<String>();
		CommonData<Integer> icd = new CommonData<>(); // 타입에서 지정하면 객체에서는 생략해도 된다.
		
		scd.setData("abc");
		icd.setData(100);
		// icd.setData("100"); // Generic으로 Integer를 선언했으므로, 이외의 타입은 생성될 수 없다.
		
		System.out.println(scd.getData());
		System.out.println(icd.getData());
	}
}

class CommonData<T>{
	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
