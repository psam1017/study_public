package ch10_java_lang_package.Object_;

public class Object_ {
	
//	Object 클래스 : 모든 클래스의 최상위 클래스. 모든 클래스는 Object를 상속받는다.
//	
//	
//	
//	주요 메소드
//	- String toString()
//		-> 기본적으로 패키지명, 클래스명, 메모리 주소값을 반환한다.
//		-> source를 이용하여 오버라이딩할 수 있다. 이 경우 클래스명과 필드 멤버를 반환한다.
//	
//	- boolean equals(Object obj)
//		-> 객체의 주소값을 비교하는 메소드(물리적, 동일성).
//			-> 필드의 값이 같은 서로 다른 두 객체를 비교하면 false를 반환한다.
//		-> 하지만 String, Integer 등 값을 저장하는 내장객체는 이를 오버라이딩하여 값을 비교한다(논리적, 동등성).
//			-> Object 클래스 자체에는 값을 저장할 일이 없으므로 비교할 일도 없다.
//	
//	- Object clone()
//		-> 객체를 복제하여 동일한 멤버 변수를 가진 인스턴스를 생성. 배열, 리스트 객체를 복사하는 경우가 많음.
//		-> 원본을 유지하고 복사본을 사용하거나, 기본 틀(prototype)의 복사본을 사용하는 경우 사용.
//		-> Cloneable 인터페이스를 구현하고, 메소드를 오버라이딩 및 예외 던지기(throws)를 해야 한다.
//		-> 복사한 객체는 원본이 바뀌면 같이 바뀐다.
}
