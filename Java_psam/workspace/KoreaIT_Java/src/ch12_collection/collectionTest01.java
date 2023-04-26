package ch12_collection;

import java.util.LinkedList;

public class collectionTest01 {
	public static void main(String[] args) {
		
		// ★업무에 적합한 컬렉션을 선정하고, 사용자가 원하는 이름으로 바꾸고, 원하는 기능만을 구현하는 작업.
		Bag myBag = new Bag();
		
		myBag.insert("휴대폰");
		myBag.insert("손수건");
		myBag.insert("손수건");
		myBag.insert("지갑");
		myBag.insert("빗");
		System.out.println("가방에 " + myBag.count() + "개의 물건이 있습니다."); // LinkedList는 중복을 허용한다.
		
		myBag.remove("빗");
		
		System.out.println("가방에 빗이 " + (myBag.contains("빗") ? "있습니다." : "없습니다."));
	}
}

class Bag{
	
	private LinkedList<String> items;
	
	Bag(){
		items = new LinkedList<String>();
	}
	
	void insert(String str) { items.add(str); }
	
	void remove(String str) { items.remove(str); }
	
	boolean contains(String str) { return items.contains(str); }
	
	int count() { return items.size(); }
}
