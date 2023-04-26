package ch12_collection.map;

public class Map01 {

//	Map : Key와 Value 쌍으로 자료를 관리하는 인터페이스. 이때 Key 값은 중복될 수 없다.
//		-> 검색을 위한 자료구조이다. Key 값으로 Value를 찾을 때 사용.
//	
//	주요 메소드 :
//		V put(K key, V value), V get(K key), V remove(Object key), boolean remove(Object key, Object value), void clear()
//		boolean isEmpty(), boolean containsKey(Object key), boolean containsValue(Object value), int size(),
//		Set<Map.Entry<K, V>> entrySet(), Set keyset(), Collection values()
//	
//	
//	
//	HashMap : Map 인터페이스를 구현한 컬렉션.
//		-> Key가 같으려면 (해시코드가 같아야 한다) && (값이 같아야 한다).
//		-> 키 타입에 String을 많이 사용한다. String은 해시코드와 값이 같으면 동일한 객체로 판단하기 때문이다.
//	
//	HashTable : HashMap + Synchronized. 멀티 스레드에서 사용하기 적합하다.
//	
//	TreeMap : HashMap + Tree 정렬 구조. Key 값으로 자료를 정렬한다.
//		-> Key에 해당하는 클래스에 Comparable이나 Comparator 인터페이스를 구현할 수 있다.
}
