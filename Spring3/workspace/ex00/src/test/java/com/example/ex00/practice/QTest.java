package com.example.ex00.practice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class QTest {

	@Autowired
	@Qualifier("Outback")
	SteakHouse outback;
	
	@Autowired
	@Qualifier("Vips")
	SteakHouse vips;
	
	@Autowired
	SteakHouse primary;
	
	@SuppressWarnings("static-access")
	@Test
	public void testQualifier() {
		log.info("Qualifier 테스트");
		log.info("vips : " + vips.steak);
		log.info("vips : " + vips.hasSaladBar());
		log.info("Outback : " + outback.steak);
		log.info("Outback : " + outback.hasSaladBar());
		log.info("primary : " + primary.steak);
		log.info("primary : " + primary.hasSaladBar());
	}
}
