package ch12_collection.list;

import java.util.ArrayList;
import java.util.List;

public class ArrayList01 {
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		
		list.add("JAVA");
		list.add("JDBC");
		list.add("Serverlet/JSP");
		list.add(2, "DBMS"); // DBMS를 2번 index로 지정하여 저장한다.
		list.add("iBATIS");
		
		for(String str : list) {
			System.out.println(str);
		}
		
		list.remove(2); // 2번 index의 DBMS를 삭제. -> 3번 index의 값이 자동으로 2번 index로 변경됨.
		list.remove("iBATIS"); // iBATIS라는 값을 삭제.
		list.set(0, "PYTHON"); // 0번 index의 값을 PYTHON으로 변경.
		
		for(int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			System.out.println(i + "번째 값 : " + str);
		}
		
		list.clear(); // list의 모든 값을 삭제.
		System.out.println(list.isEmpty()); // list가 비어있으므로 true를 반환.
	}
}
