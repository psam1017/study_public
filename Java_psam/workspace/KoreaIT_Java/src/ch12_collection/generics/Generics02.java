package ch12_collection.generics;

public class Generics02 {
	public static void main(String[] args) {
		
		Box<String> myBox = new Box<String>();
		myBox.setItem("Test");
		System.out.println(myBox.getItem());
	}
}

class Box<T> {
	
	private T item;
	
	public T getItem(){
		return item;
	}

	public void setItem(T item){
		this.item = item;
	}
}