package ch10_java_lang_package.String_;

public class String_ {
	
//	String 클래스
//	
//	String 클래스 선언 방법
//	1. 생성자의 매개변수로 문자열을 생성.
//		-> String str = new String("abc");
//	2. 문자열 상수를 가르키는 방식.
//		-> String str = "abc";
//			-> 상수 풀(Constant Pool)에 저장된 주소 값을 참조하므로, 서로 다른 참조변수라고 하더라도 같은 주소를 가르키게 된다.
//	
//	
//	
//	String 클래스는 문자열을 private final char value[]에 char 배열로 저장한다.
//		-> 배열이 final로 선언되어 상수이기 때문에 값 자체를 변경할 수 없다(Immutable).
//			-> 참조변수에 다른 값을 저장하면, 문자열 저장 공간 안에서 값을 바꾸는 방식이 아니라 다른 문자열 저장 공간을 참조하는 방식으로 작동한다.
//				-> 문자열을 프로그램 내에서 변경할수록 메모리 소모가 심해진다.
//	
//	String 클래스의 메모리 과소모를 보완하는 클래스로 StringBuffer, StringBuilder가 있다.
//	- StringBuffer : 스레드 작업 시 문자열이 안전하게 변경되도록 보장. 속도가 비교적 느림.	-> 멀티스레드 프로그램에서 사용
//	- StringBuilder : 문자열이 안전하게 변경되는 걸 보장하진 않지만, 속도가 비교적 빠름.		-> 멀티스레드가 아닐 때 사용
//	
//	charAt(int i) : 인덱스 i에 있는 문자를 리턴.
//		-> 인데스는 0부터 시작함에 유의.
//	indexOf(String s) : 주어진 인수의 문자열이 시작되는 인덱스 값을 리턴.
//		->문자열이 포함되어 있지 않다면 -1을 반환.
//		-> 인수가 완벽하게 일치하지 않아도 인덱스를 반환.
//		-> 인덱스는 0부터 시작함에 유의.
//	length() : 문자열의 길이를 리턴.
//	replace(String a, String b) : "a"를 "b"로 변환.
//	substring(int begin, int end) : 주어진 시작과 끝 인덱스 사이의 문자열을 추출.
//	substring(int begin) : 주어진 인덱스부터 끝까지 문자열을 추출.
//	toLowerCase() : 문자열을 모두 소문자로 변환.
//	toUpperCase() : 문자열을 모두 대문자로 변환.
//	equalsIgnoreCase() : 대소문자를 무시하고 문자열이 같은지 비교.
//	trim() : 문자열 앞뒤로 공백을 제거.
//	valueOf(variable) : 주어진 기본 자료형 값을 문자열로 변환.
}
