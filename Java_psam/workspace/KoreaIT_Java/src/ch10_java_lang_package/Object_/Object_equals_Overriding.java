package ch10_java_lang_package.Object_;

public class Object_equals_Overriding {
	public static void main(String[] args) {
		
		Student lee1 = new Student(100, "이상원");
		Student lee2 = lee1;
		Student sang1 = new Student(100, "이상원");
		
		// 주소가 동일한 두 인스턴스를 비교.
		System.out.println("lee1 == lee2 ? " + (lee1 == lee2));
		System.out.println("lee1.equals(lee2) ? " + lee1.equals(lee2));
		System.out.println();
		
		
		
		// 주소가 다르지만, 학번이 같은 두 인스턴스를 비교
		System.out.println("lee1 == sang1 ? " + (lee1 == sang1));
		System.out.println("lee1.equals(sang1) ? " + lee1.equals(sang1));
		System.out.println();
		
		
		
		// hashCode와 실제 주소 값을 비교
		System.out.println("lee1 hash code : " + lee1.hashCode());
		System.out.println("sang1 hash code : " + sang1.hashCode());
		System.out.println("lee1 real address : " + System.identityHashCode(lee1));
		System.out.println("sang1 real address : " + System.identityHashCode(sang1));
	}
}

class Student{
	
	int studentId;
	String studentName;
	
	public Student(int studentId, String studentName) {
		this.studentId = studentId;
		this.studentName = studentName;
	}
	
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student) {
			Student std = (Student)obj;
			if(this.studentId == std.studentId) // 학번이 같으면 같은 학생으로 정의한다.
				return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() { // 해시코드 값으로 학번을 반환한다.
		return studentId;
	}
}