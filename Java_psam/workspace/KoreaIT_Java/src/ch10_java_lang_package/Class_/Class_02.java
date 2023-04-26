package ch10_java_lang_package.Class_;

import java.lang.reflect.*;

public class Class_02 {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws ClassNotFoundException {
		
		Class strClass = Class.forName("java.lang.String");
		
		Constructor[] constructors = strClass.getConstructors();
		System.out.println("모든 생성자 가져오기");
		for(Constructor c : constructors)
			System.out.println(c);
		
		System.out.println("\n모든 멤버 변수(필드) 가져오기");
		Field[] fields = strClass.getFields();
		for(Field f : fields)
			System.out.println(f);
		
		System.out.println("\n모든 메소드 가져오기");
		Method[] methods = strClass.getMethods();
		for(Method m : methods)
			System.out.println(m);
	}
}
