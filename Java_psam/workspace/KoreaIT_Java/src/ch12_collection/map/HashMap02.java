package ch12_collection.map;

import java.util.*;

public class HashMap02 {
	public static void main(String[] args) {
		
		Map<Student, Integer> hashMap = new HashMap<Student, Integer>();
		
		hashMap.put(new Student(1, "홍길동"), 95);
		hashMap.put(new Student(1, "홍길동"), 95); // 번호와 이름이 같아서 입력되지 않는다.
		hashMap.put(new Student(1, "박유신"), 100); // 번호가 같아서 입력되지 않는다.
		hashMap.put(new Student(2, "박유신"), 90);
		
		System.out.println("총 Entry 수 : " + hashMap.size());
	}
}

class Student{
	
	public int sNo;
	public String sName;
	
	public Student(int sNo, String sName) {
		this.sNo = sNo;
		this.sName = sName;
	}
	
	@Override
	public int hashCode() {
		return this.sNo;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student std = (Student)obj;
			return this.sNo == std.sNo;
		}
		return false;
	}
}