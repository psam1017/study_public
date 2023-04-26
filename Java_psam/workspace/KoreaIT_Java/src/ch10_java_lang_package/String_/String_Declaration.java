package ch10_java_lang_package.String_;

public class String_Declaration {
	public static void main(String[] args) {
		
		String str1 = new String("abc");
		String str2 = new String("abc");
		
		System.out.println(str1 == str2); // 서로 다른 인스턴스를 각각 가르키고 있음.
		System.out.println(str1.equals(str2));
		
		String str3 = "abc"; // str3, str4 둘 다 같은 상수 풀에 저장된 "abc"의 주소 값을 가르키고 있음.
		String str4 = "abc";
		
		System.out.println(str3 == str4);
		System.out.println(str3.equals(str4));
	}
}
