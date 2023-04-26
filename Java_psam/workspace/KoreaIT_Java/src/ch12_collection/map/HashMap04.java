package ch12_collection.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMap04 {
	public static void main(String[] args) {
		
		Map<String, Integer> map = new HashMap<>();
		map.put("blue", 96);
		map.put("red", 86);
		map.put("white", 92);
		
		String name = null;
		int maxScore = 0;
		int totalScore = 0;
		
		Iterator<String> ir = map.keySet().iterator();
		
		while(ir.hasNext()) {
			String key = ir.next();
			int newScore = map.get(key);
			if(newScore > maxScore) {
				maxScore = newScore;
				name = key;
			}
			totalScore += map.get(key);
		}
		
		System.out.println("총점 : " + totalScore);
		System.out.println("평균 : " + (int)(100.0 * totalScore / map.size()) / 100.0);
		System.out.println("최고 점수 : " + maxScore);
		System.out.println("최고 점수의 아이디 : " + name);
	}
}
