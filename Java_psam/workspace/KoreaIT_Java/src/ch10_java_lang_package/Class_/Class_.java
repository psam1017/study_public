package ch10_java_lang_package.Class_;

public class Class_ {
	
//	자바의 클래스와 인터페이스를 컴파일하면 class파일로 생성되고, 이 안에 변수, 메소드, 생성자 등이 포함된다.
//	Class 클래스는 컴파일된 class 파일의 정보를 가져온다.
//		-> Java는 공동작업이 핵심. 내가 작업하지 않은 클래스의 정보를 파악하기 위해 사용한다.
//	
//	1. class 경로 가져오기
//	2. class 내부의 public 변수, 메소드, 생성자 가져오기(리플렉션 사용)
//		-> private은 접근할 수 없고, 접근해서는 안 되기 때문에 반환하지 않는다.
//		-> 리플렉션 Reflection : 클래스의 자료형을 모르는 상태에서 Class 클래스를 활용하여 그 클래스의 정보를 가져오고,
//			이 정보를 활용하여 인스턴스를 생성하거나 메소드를 호출하는 방식
//		
//	new 연산자로 생성한 객체는 힙에 생성.
//	메모리는 무한하지 않으므로 다 사용한 객체는 제거해야 함.
//	자바에는 가비지 컬렉터가 주기적으로 미사용 객체를 찾아 메모리를 회수하기 때문에 객체를 삭제하는 별도의 명령이 없음.
//	메모리 회수가 자동으로 수행되서 메모리 누수를 걱정할 필요가 없으며 객체를 생성하고 사용하기만 하면 됨.
//	
//	하지만 가비지 컬렉터 기능은 메모리에만 국한되며, 그 이외의 자원은 수동으로 해제해야 함.
//	그렇지 않으면 연결이 계속 유지되고, 터미널이 계속 열려 있게 됨.
//	
//	finalize 메소드는 객체가 사라질 때 호출되며 정리하는 메소드이다.
//	메모리 관련 정리는 할 필요가 없지만, 통신, 연결, DB 오픈 등을 했다면 객체가 소멸하기 전에 사용된다.
//	하지만 가비지 컬렉터가 언제 수거할지 모르기 때문에 예외 처리 방식으로 하는 것이 더 좋다.
//	가비지 컬렉터의 호출 시점은 가상 머신이 결정하며 한가할 때 정리하기 때문이다.
//	
//	System.gc 메소드
//	메모리가 지극히 부족하거나 프로그램이 한가할 때 가비지 컬렉터를 기동하여 쓰레기를 수집한다.
//	가비지 컬렉터는 시스템이 한가한 시간에 알아서 시행하도록 되어 있으므로 특수한 상황이 아닌 한 직접 메소드는 호출하지 말아야 한다.
//	자동으로 수집되도록 설정된 메소드를 강제로 실행하면 오히려 성능이 떨어진다.
//	가비지 컬렉터가 작동하면 당장 수행해야 할 다른 작업이 늦어지기 때문.
//	
//	System.runFinalization 메소드
//	가비지 컬렉터에 의해 객체를 제거할 때 finalize 메소드를 호출하는데,
//	메모리 회수가 아니라 정리만 하고 싶을 때 호출한다.
//	메소드를 호출하면 예정된 finalize 메소드를 즉시 실행한다.
}
