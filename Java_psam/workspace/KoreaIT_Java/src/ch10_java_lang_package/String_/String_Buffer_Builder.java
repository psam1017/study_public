package ch10_java_lang_package.String_;

public class String_Buffer_Builder {
	public static void main(String[] args) {
		
		String s = new String("Java");
		StringBuilder sb = new StringBuilder(s);
		
		System.out.println("String의 첫 주소 : " + System.identityHashCode(s));
		System.out.println("StringBuilder의 첫 주소 : " + System.identityHashCode(sb));
		
		// String과 StringBuilder의 값을 변경
		sb.append(" and");
		sb.append(" Android");
		sb.append(" is fun!");
		s = sb.toString();
		
		System.out.println();
		System.out.println("String 값 변경 후 주소 : " + System.identityHashCode(s));
		System.out.println("StringBuilder 값 변경 후 주소 : " + System.identityHashCode(sb));
	}
}
