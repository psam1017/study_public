package com.example.ex00.practice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DITest {
	
	@Autowired
	Restaurant rest;
	
	@Test
	public void checkDependencyInjection() {
		log.info("의존성 주입 테스트");
		log.info("레스토랑 : " + rest);
		log.info("셰프 : " + rest.getChef());
	}
}
