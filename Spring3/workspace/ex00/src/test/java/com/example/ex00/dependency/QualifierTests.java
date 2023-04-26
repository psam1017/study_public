package com.example.ex00.dependency;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.ex00.dependency.qualifier.Computer;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class QualifierTests {
	
	@Autowired
	@Qualifier("desktop")
	private Computer desktop;
	
	@Autowired
	@Qualifier("laptop")
	private Computer laptop;
	
	@Autowired
	private Computer primary;

	// Qualifier를 지정하지 않은 상태에서는 오류가 발생한다.
	@Test
	public void testQualifier() {
		log.info("====================");
		log.info("desktop : " + desktop);
		log.info("desktop : " + desktop.getScreenWidth());
		log.info("====================");
		log.info("laptop : " + laptop);
		log.info("laptop : " + laptop.getScreenWidth());
		log.info("====================");
		log.info("primary : " + primary);
		log.info("primary : " + primary.getScreenWidth());
		log.info("====================");
	}
}
