package myBatis.config;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisConfig {
	private static SqlSessionFactory sqlSession_f;
	
	// static 바디에 선언한 내용은 오직 한 번만 실행하게 된다.
	static {
		try {
			String resource = "./myBatis/config/config.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			sqlSession_f = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("초기화 문제 발생, MybatisConfig.java");
		}
	}

	public static SqlSessionFactory getSqlsession_f() {
		return sqlSession_f;
	}
}
