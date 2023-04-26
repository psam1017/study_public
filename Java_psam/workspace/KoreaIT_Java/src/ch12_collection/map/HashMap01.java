package ch12_collection.map;

import java.util.*;

public class HashMap01 {
	public static void main(String[] args) {
		
		Map<String, Integer> hashMap = new HashMap<String, Integer>();
		
		
		// 자료 추가
		hashMap.put("피카츄", 85);
		hashMap.put("이브이", 90);
		hashMap.put("조로아", 90);
		hashMap.put("이브이", 100); // Map의 key가 중복되면, value를 갱신한다.
		System.out.println("총 Entry 수 : " + hashMap.size());
		
		
		// get(K key)로 key의 값을 가져오기
		System.out.println("'이브이'의 value : " + hashMap.get("이브이"));
		System.out.println();
		
		
		// keySet()을 사용해서 Map을 출력
		Set<String> keySet = hashMap.keySet();
		Iterator<String> keyIterator = keySet.iterator();
		
		while(keyIterator.hasNext()) {
			String key = keyIterator.next();
			Integer value = hashMap.get(key);
			System.out.println(key + " : " + value);
		}
		System.out.println();
		
		
		// foreach를 사용해서 Map을 출력
		for(Map.Entry<String, Integer> entry : hashMap.entrySet()) {
			String strKey = entry.getKey();
			Integer intValue = entry.getValue();
			System.out.println(strKey + " : " + intValue);
		}
		System.out.println();
		
		
		// entrySet()을 사용해서 Map을 출력
		Set<Map.Entry<String, Integer>> entrySet = hashMap.entrySet();
		Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
		
		while(entryIterator.hasNext()) {
			Map.Entry<String, Integer> entry = entryIterator.next();
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println(key + " : " + value);
		}
		System.out.println();
		
		
		// remove(), clear()로 자료를 제거.
		hashMap.remove("피카츄");
		System.out.println("총 Entry 수 : " + hashMap.size());
		
		hashMap.clear();
		System.out.println("총 Entry 수 : " + hashMap.size());
	}
}
