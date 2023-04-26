package ch31_design_pattern.mvc.school;

public class Student extends Person{
	
	private int studentNumber;
	private boolean[] classCheck;
	private int[] classScore;
	
	public Student(int studentNumber) {
		this.studentNumber = studentNumber;
	}

	public int getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}

	public boolean[] getClassCheck() {
		return classCheck;
	}

	public void setClassCheck(int index, boolean classCheck) {
		this.classCheck[index] = classCheck;
	}

	public void makeClassCheckLength(int index) {
		this.classCheck = new boolean[index];
	}
	
	public int[] getClassScore() {
		return classScore;
	}

	public void setClassScore(int index, int classScore) {
		this.classScore[index] = classScore;
	}

	public void makeClassScoreLength(int index) {
		this.classScore = new int[index];
	}
}
