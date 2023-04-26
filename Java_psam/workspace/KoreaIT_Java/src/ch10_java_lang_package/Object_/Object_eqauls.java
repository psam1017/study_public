package ch10_java_lang_package.Object_;

public class Object_eqauls {
	@SuppressWarnings("removal")
	public static void main(String[] args) {
		
		/* 
		 * Object 클래스의 equals
		 * 
		 * public boolean equals(Object obj) {
     *     return (this == obj);
     * }
     * 
		 * */
		
		// 1. 재정의되지 않은 equals()는 주소값만을 비교한다. 즉, 비교연산자(==)와 동일하다.
		// 2. hash 값을 사용하지 않는 클래스에서 재정의된 equals()는 논리적으로 동일한 값(리터럴)을 가지고 있는지를 비교한다.
		// 3. hash 값을 사용하는 클래스에서 재정의된 equals()는 hash값과 리터럴이 논리적으로 동일한지를 비교한다.
		
		String str1 = new String("abc");
		String str2 = new String("abc");
		
		System.out.println(str1 == str2); // false
		System.out.println(str1.equals(str2)); // true
		
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		
		
		
		Integer i1 = new Integer(100);
		Integer i2 = new Integer(100);
		
		System.out.println(i1 == i2); // false
		System.out.println(i1.equals(i2)); // true
		
		// hashCode()와 equals()
		// 1. 자바에서는 인스턴스를 힙 메모리에 생성하여 관리할 때 해시 알고리즘을 사용한다.
		//    생성된 리터럴은 힙 공간의 상수 풀에 하나만 저장되며, 여러 개의 리터럴을 생성해도 (str1, str2처럼) 같은 해시코드를 가진다.
		// 2. hashCode()는 객체의 해시 코드 값을 출력한다. 언급했듯이 str1과 str2의 해시코드 값은 같다.
		//    한편, String 클래스의 equals()는 해시 값으로 비교를 하지 않으므로 동등성 비교에 영향을 주진 않는다.
		//    String 클래스의 equals()는 instanceof, 문자열 길이, 각 자리의 문자 등으로 비교하여 동등성을 비교한다.
		// 3. hash 값을 사용하는 Collection(HashMap, HashSet, HashTable 등)은 hashCode()와 equals()가 모두 같은지를 비교한다.
		//    따라서 hashCode()와 equals()를 모두 재정의하지 않으면 원하는 결과가 나오지 않을 수 있다.
	}
}
