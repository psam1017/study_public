package com.example.ex01.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class JdbcTests {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConnection() {
		
		// 자동으로 close를 실행
		try(Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr")){
			log.info(connection);
		} catch(Exception e) {
			// JUnit의 메소드. 무조건 실패로 처리한 뒤 실행을 중지한다.
			fail(e.getMessage());
		}
	}
	
	// ???
	// 히카리 config 사용 - dbcp 구성 - connection pool을 만들었으니, connection 객체가 들어감. 핵심은 데이터 소스 객체. 이를 통해 username, pw 등을 찾아서 자바에서 실행할 수 있음.
	// ...??? 이론적인 내용은 좀 어렵다?
}
