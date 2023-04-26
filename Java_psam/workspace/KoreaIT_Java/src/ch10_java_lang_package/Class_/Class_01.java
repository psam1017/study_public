package ch10_java_lang_package.Class_;

public class Class_01 {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws ClassNotFoundException{
		
		// Class 클래스를 선언하고 상속하는 클래스 경로 가져오기
		
		// 1번 방법 : 참조변수.getClass() 메소드 사용
		Person person = new Person();
		Class pClass1 = person.getClass();
		System.out.println(pClass1.getName());
		
		// 2번 방법 : 클래스 타입(Class명.class)을 Class 변수에 직접 대입하기
		Class pClass2 = Person.class;
		System.out.println(pClass2.getName());
		
		// 3번 방법 : Class.forName("클래스 이름") 메소드 사용 -> 경로에 클래스가 있는지 확인하기 위해
		Class pClass3 = Class.forName("ch10_java_lang_package.Class_.Person");
		System.out.println(pClass3);
	}
}

class Person{
	
	private String name;
	private int age;
	
	// Constructors
	public Person() {}

	public Person(String name) {
		this.name = name;
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	// Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}