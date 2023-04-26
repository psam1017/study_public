package ch31_design_pattern.mvc.school;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagerUpdate {
	
	Scanner sc = new Scanner(System.in);
	ArrayList<Student> students = new ArrayList<Student>();
	ArrayList<String> className = new ArrayList<String>();
	String[] msg = {
			"해당 학번의 학생이 존재하지 않습니다.",
			"이미 존재하는 학생입니다.",
			"성적 범위가 올바르지 않습니다.",
			null
	};
	
	private StudentManagerUpdate() {
		
		className.add("JAVA");
		className.add("PYTHON");
		className.add("C++");
		className.add("C#");
	}
	
	private static StudentManagerUpdate instance = new StudentManagerUpdate();
	
	public static StudentManagerUpdate getInstance() {
		if(instance == null) {
			instance = new StudentManagerUpdate();
		}
		return instance;
	}
	
	void showClass() {
		
		for(int i = 0; i < className.size(); i++) {
			System.out.print((i + 1) + ". " + className.get(i) + " / ");
		}
	}
	
	Student findStudentInformation(int studentNumber) {
		
		for(Student s : students) {
			if(s.getStudentNumber() == studentNumber) {
				System.out.println("해당 학생의 정보는 다음과 같습니다.");
				System.out.println("이름 : " + s.getName() + "\n전화번호 : " + s.getPhoneNumber() + "\n메모 : " + s.getMemo());
				return s;
			}
		}
		return null;
	}
	
	Student checkStudentNumber() {
		
		System.out.print("학번을 입력하세요 : ");
		int studentNumber = sc.nextInt();
		
		Student newStudent = findStudentInformation(studentNumber);
		if(newStudent == null) {
			System.out.println(msg[0]);
			return null;
		}
		return newStudent;
	}
	
	void addStudent() {
		
		System.out.print("학번을 입력하세요 : ");
		int studentNumber = sc.nextInt();
		
		Student newStudent = findStudentInformation(studentNumber);
		if(newStudent == null) {
			newStudent = new Student(studentNumber);
			students.add(newStudent);
		}
		else {
			System.out.println(msg[1]);
			return;
		}
		
		System.out.print("이름 : ");
		newStudent.setName(sc.next());
		System.out.print("전화번호 : ");
		newStudent.setPhoneNumber(sc.next());
		System.out.print("특이사항 : ");
		newStudent.setMemo(sc.next());
		
		newStudent.makeClassCheckLength(className.size());
		newStudent.makeClassScoreLength(className.size());
		
		System.out.println("학생 추가가 완료되었습니다." + "\n");
	}
	
	void removeStudent() {
		
		Student newStudent = checkStudentNumber();
		if(newStudent == null) {
			return;
		}
		
		students.remove(newStudent);
		System.out.println("학생 삭제가 완료되었습니다.");
	}
	
	void addClass() {
		
		Student newStudent = checkStudentNumber();
		if(newStudent == null) {
			return;
		}
		
		while(true) {
			
			System.out.println("메뉴를 선택하세요 : 1. 수강신청 / 2. 수강철회 / 3. 종료");
			int classMenu = sc.nextInt();
			switch(classMenu) {
			case 1:
				setClass("수강신청할 과목을 선택하세요.", newStudent, true);
				break;
			case 2:
				setClass("수강철회할 과목을 선택하세요.", newStudent, true);
				break;
			case 3:
				return;
			default:
				System.out.println("잘못된 입력입니다.");
			}
		}
	}
	
	void setClass(String msg, Student student, boolean check) {
		
		System.out.println(msg);
		showClass();
		System.out.println();
		int index = sc.nextInt() - 1;
		student.setClassCheck(index, check);
		
		if(!check) {
			student.setClassScore(index, 0);
		}
	}
	
	void setScore() {
		
		Student newStudent = checkStudentNumber();
		if(newStudent == null) {
			return;
		}
		
		while(true) {
			
			try {
				System.out.println("성적을 입력/수정할 과목을 선택하세요 : ");
				showClass();
				System.out.println("종료는 0번");
				int classMenu = sc.nextInt();
				
				if(classMenu == 0) {
					break;
				}
				
				if(!newStudent.getClassCheck()[classMenu - 1]) {
					System.out.println(className.get(classMenu - 1) + "과목은 미신청 과목입니다.");
					continue;
				}
				
				System.out.print("성적을 입력하세요 : ");
				int score = sc.nextInt();
				
				if(score < 0 || score > 100) {
					System.out.println(msg[2]);
					continue;
				}
				
				newStudent.setClassScore(classMenu - 1, score);
				System.out.println(className.get(classMenu - 1) + "성적 입력이 완료되었습니다.");
			}
			catch(IndexOutOfBoundsException ie) {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}
	
	void informStudent() {
		
		System.out.println("메뉴를 선택해주세요 : 1. 특정 학생만 / 2. 모든 학생");
		int menu = sc.nextInt();
		
		switch(menu) {
		case 1:
			one();
			break;
		case 2:
			all();
			break;
		default:
			System.out.println("잘못된 입력입니다.");
			return;
		}
	}
	
	void one() {
		
		Student newStudent = checkStudentNumber();
		
		System.out.println("학번 : " + newStudent.getStudentNumber());
		System.out.println("이름 : " + newStudent.getName());
		System.out.println("전화번호 : " + newStudent.getPhoneNumber());
		System.out.println("특이사항 : " + newStudent.getMemo());
		
		System.out.println("===현재 수강 중인 과목과 성적===");
		boolean[] classCheck = newStudent.getClassCheck();
		int[] classScore = newStudent.getClassScore();
		for(int i = 0; i < classCheck.length; i++) {
			if(classCheck[i]) {
				System.out.println("과목명 : " + className.get(i) + " / 성적 : " + classScore[i]);
			}
		}
	}
	
	void all() {
		
		for(Student s : students) {
			System.out.println("학번 : " + s.getStudentNumber());
			System.out.println("이름 : " + s.getName());
			System.out.println("전화번호 : " + s.getPhoneNumber());
			System.out.println("특이사항 : " + s.getMemo());
			
			System.out.println("===현재 수강 중인 과목과 성적===");
			boolean[] classCheck = s.getClassCheck();
			int[] classScore = s.getClassScore();
			for(int i = 0; i < classCheck.length; i++) {
				if(classCheck[i]) {
					System.out.println("과목명 : " + className.get(i) + " / 성적 : " + classScore[i]);
				}
			}
		}
	}
}
