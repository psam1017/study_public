package ch06_class;

// Class3���� ���
public class Student {
	
	int studentID;
	String studentName;
	int grade;
	String address;
	
	public void showStudentInfo() { // �̸�, �ּ� ���
		System.out.println(studentName + ", " + address);
	}
	
	
	
	// ��Ŭ�� - Source - Getters�� Setters ���� 
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
