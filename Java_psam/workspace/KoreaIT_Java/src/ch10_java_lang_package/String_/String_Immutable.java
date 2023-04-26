package ch10_java_lang_package.String_;

public class String_Immutable {
	public static void main(String[] args) {
		
		String hello = new String("hello");
		String world = new String("world");
		
		System.out.println(hello);
		System.out.println("hello의 첫 주소 값 : " + System.identityHashCode(hello));
		// 이때 hello는 heap에 생성된 인스턴스의 주소를 가르킨다.
		
		
		hello = "hello";
		System.out.println(hello);
		System.out.println("hello에 hello를 저장한 경우 : " + System.identityHashCode(hello));
		// 이때 hello는 hello 상수의 주소를 가르킨다.
		
		
		hello = hello.concat(" " + world);
		System.out.println(hello);
		System.out.println("hello world를 저장한 경우 : " + System.identityHashCode(hello));
		// 이때 hello는 heap의 또 다른 저장공간을 가르킨다.
		// 또한 첫번째로 생성했던 인스턴스의 저장공간을 아직도 사용하고 있다. -> 메모리 과소모
		
		
		hello = "hello world";
		System.out.println(hello);
		System.out.println("hello world를 저장한 경우 : " + System.identityHashCode(hello));
		// 이때 hello는 hello world 상수의 주소를 가르킨다.
	}
}
