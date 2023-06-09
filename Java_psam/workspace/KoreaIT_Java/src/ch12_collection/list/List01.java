package ch12_collection.list;

public class List01 {

//	Array와 List의 차이 : Array는 입력받는 자료의 길이에 제한을 둘 때 사용하고, List는 자료의 길이를 알 수 없기 때문에 사용한다.

//	List : 
//	배열과 비슷하게 객체를 인덱스로 관리한다.
//	배열과는 다르게 저장 용량이 자동으로 증가한다.
//	추가, 삭제, 검색 등의 메소드가 제공된다.
//		-> add(), set() / remove(), clear() / contains(Object o), get(int index), isEmpty(), size()
//	객체 자체를 저장하는 것이 아니라 객체의 주소를 참조한다.
//		-> 동일한 객체를 중복 저장할 수 있고, 이 경우 동일한 번지를 참조한다.
//	
//	
//	
//	1. ArrayList
//	기본 생성자로 ArrayList 객체를 생성하면 내부에 default로 10개의 저장공간을 가지게 된다.
//	나열된 주소를 사용하기 때문에 값들이 물리적으로 가깝게 저장된다.
//		-> 값을 검색할 때는 포인터 연산이 가능한 ArrayList가 LinkedList보다 효율적이다.
//			-> ArrayList 자료가 10,000개가 있는 상태에서 10,000번째 값을 지우면 값들의 이동이 없지만,
//				 1번째 값을 지운다면 index를 맞추기 위해 9,999개의 값들이 이동해야 한다.
//	
//	2. LinkedList
//	LinkedList는 요소를 추가할 때마다 동적으로 메모리를 생성하기 때문에
//	ArrayList처럼 용량을 늘리거나(추가) 값을 복사(중간에 값을 삭제하는 경우)해야 하는 번거로움이 없다.
//		-> 자료를 추가하거나 삭제할 때 자료의 이동이 ArrayList보다 적게 발생한다.
//			-> 각 값들이 노드로 서로 연결되어 있어서 n번째 index가 n+1번째 index의 주소값을 가지고 있는 방식이다.
//			-> 만약 10,000개의 자료 중에서 2번째 값을 지운다면, 1번째 값이 3번째 값을 가리키게만 하면 끝난다.
//	
//	-> ArrayList : 순차적인 추가/삭제가 빠름. 검색이 빠름.
//	-> LinkedList : 중간에 추가/삭제가 빠름. 검색이 느림.
//	
//	3. Vector
//	동기화된(Synchronized) 메소드로 구성되어 있다.
//		-> 멀티 스레드에서 메소드를 동시에 실행할 수 없어서 안전하게 사용이 가능하다.
}
