package ch12_collection.map;

import java.util.*;

public class TreeMap01 {
	public static void main(String[] args) {
		
		Map<Integer, String> treeMap = new TreeMap<Integer, String>();
		
		treeMap.put(1, "가");
		treeMap.put(3, "다");
		treeMap.put(4, "라");
		treeMap.put(2, "나"); // 무작위로 값을 삽입.
		
		
		
		// Iterator로 출력
		Set<Integer> keySet = treeMap.keySet();
		Iterator<Integer> keyIterator = keySet.iterator();
		
		while(keyIterator.hasNext()) {
			Integer key = keyIterator.next();
			String value = treeMap.get(key);
			System.out.println(key + " : " + value);
		}
		System.out.println();
		
		
		
		// foreach로 출력
		for(Map.Entry<Integer, String> ir : treeMap.entrySet()) {
			Integer strKey = ir.getKey();
			String intValue = ir.getValue();
			System.out.println(strKey + " : " + intValue);
		}
		System.out.println();
	}
}
