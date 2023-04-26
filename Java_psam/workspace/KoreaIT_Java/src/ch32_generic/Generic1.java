package ch32_generic;

public class Generic1 {
	public static void main(String[] args) {
		
		// 제네릭을 쓰지 않은 경우
		
		ObjectData stringCommonData = new ObjectData();
		ObjectData integerCommonData = new ObjectData();
		
		stringCommonData.setData("abc");
		integerCommonData.setData(100);
		
		System.out.println(stringCommonData.getData());
		System.out.println(integerCommonData.getData());
	}
}

class ObjectData{
	private Object data;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}