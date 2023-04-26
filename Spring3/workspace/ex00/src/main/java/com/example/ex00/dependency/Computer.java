package com.example.ex00.dependency;

import org.springframework.stereotype.Component;

import lombok.Data;

// 의존성 주입 시작
// 의존성 주입을 위한 준비 : spring한테 맡길 객체를 알려주기

// 클래스 이름 위에서 annotation을 자동 완성
// @Component	: 해당 객체를 Spring에서 관리하도록 설정한다.
// @Data		: lombok이 메소드들을 만들어준다. 만약 특정 메소드만 필요하다면 @Getter처럼 사용해도 된다.

@Component
@Data
public class Computer {
	// lombok이 있다면 outline에서 기본적인 메소드들을 빠르게 만들 수 있다.
	int data;
}
