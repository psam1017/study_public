package com.example.ex01.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

// Mapper 인터페이스
// SQL를 작성하는 작업은 XML을 이용할 수도 있지만,
// 최소한의 코드를 작성하기 위해서는 Mapper 인터페이스를 사용한다.

@Mapper
public interface TimeMapper {

	// XML을 만들지 않고 여기에서 바로 쿼리를 실행!
	@Select("SELECT SYSDATE FROM DUAL")
	public String getTime();
	
	// annotation을 쓰지 않고 XML에서 쿼리를 작성!
	// 경로는 src/main/resources/com/example/ex01/mapper이며, 이는 현재 파일의 경로와 일치해야 한다.
	// + src/main/resources는 default 경로이다.
	public String getTime2();
}
