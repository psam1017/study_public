package com.example.ex00.dependency;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

// test 폴더에서는 WAS가 아니라 JUnit이 실행한다.
// 아래와 같은 annotation을 선언.

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DependencyTests {
	@Autowired
	private Coding coding;
	
	@Test
	public void checkDependencyInjection() {
		log.info("====================");
		log.info("coding : " + coding);
		log.info("computer : " + coding.getComputer());
		log.info("====================");
	}
	
	// root-context.xml에서 Namespaces -> context -> ok
	// root-context.xml에서 component-scan을 설정
	
	// -> JUnit 탭에서 실행 여부, 오류 등을 확인할 수 있다.
}
