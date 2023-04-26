package com.jspex.beans;

//NUM NUMBER PRIMARY KEY,
//NAME VARCHAR2(1000) NOT NULL,
//BRITHDAY DATE NOT NULL

public class MemberVO {
	private int num;
	private String name;
	private String birthday;
	
	public MemberVO(){
		this.name = "이름을 입력하세요.";
		this.birthday = "생일을 입력하세요.";
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
}
