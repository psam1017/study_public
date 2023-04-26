package ch07_inheritance.PolymorphismWork2;

public class Pet {
	
	private String name;
	private String masterName;
	
	public Pet(String name, String masterName) {
		super();
		this.name = name;
		this.masterName = masterName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMasterName() {
		return masterName;
	}

	public void introduce() {
		System.out.println("멍멍! 내 이름은 " + name + "입니다.");
		System.out.println("멍멍! 내 주인 이름은 " + masterName + "입니다.");
	}
	
}
