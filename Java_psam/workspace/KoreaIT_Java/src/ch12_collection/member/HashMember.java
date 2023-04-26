package ch12_collection.member;

public class HashMember {
	
	public String name;
	public int age;
	
	public HashMember(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int hashCode() {
		
		return name.hashCode() + age;
	}

	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof HashMember) {
			HashMember hm = (HashMember)obj;
			return hm.name.equals(name) && hm.age == age;
		}
		else
			return false;
	}
}
