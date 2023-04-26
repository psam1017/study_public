package ch07_inheritance;

public class Modifier2 {

	public static void main(String[] args) {
		
		User user1 = new User("철수", 20);
		User user2 = new User("영희", 22);
		
		// private 수준의 인스턴스 변수에는 getter와 setter로만 접근이 가능.
		
		System.out.println(user1.getName() + "의 나이 : " + user1.getAge());
		user2.setAge(2022);
		System.out.println(user2.getName() + "의 나이 : " + user2.getAge());
	}
}

class User{
	private String name;
	private int age;
	
	public User(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public int getAge() { return age; }

	public void setAge(int age) { this.age = age; }
}