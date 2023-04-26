package ch34_database;

public class Database01 {
	
//	데이터베이스 : 여러 사람에 의해 공유되어 사용될 목적으로 통합하여 관리되는 데이터의 집합
//		-> 필요요건 : 대용량, 효율성, 무결성, 활용성, 공유성, 보안성
//		-> 단점 :
//			전문지식 필요
//			비용 부담
//			백업과 복구가 어려움
//			시스템이 복잡함
//			과부하 발생(Low Chaining, Low Migration)
//			복잡한 만큼 시스템 자원을 많이 차지함 -> 최근 하드웨어가 차지하는 용량을 훨씬 뛰어넘고 있어서 큰 문제가 되지 않음.
//	
//	DBMS : Data Base Management System
//		정보를 영구적으로 저장하려면 하드 디스크나 SSD에 파일 형태로 저장해야 함.
//		이러한 복잡한 저장장치를 논리적인 명령으로 조작하는 시스템이 DBMS이다.
//		DBMS를 이용해 별도로 데이터를 관리하면 데이터의 재사용성, 유연성이 올라가고, 종속성이 제거되어 다른 프로그램에서도 사용이 가능하다.
//	
//	RDBMS : 관계형 데이터베이스.
//	
//	빅 데이터 :
//		관계형 데이터베이스에 비해 일관성을 희생한 대신 성능과 용량을 극적으로 향상시켰으며, 생성 주기가 짧음.
//		자료형, 사진 및 영상 등도 데이터로 포함함.
//		(ex) NoSQL : Key - Value 형식으로 데이터를 관리하고 접근함.
//		소셜 관련 업무에서 적극적으로 사용.
//	
//	관계형 데이터베이스의 종류
//	Oracle, MS SQL Server, MySQL, MariaDB, PostgreSQL, SQLite, MongoDB, MSAccess
//		-> MariaDB : 오픈 소스, MySQL과 거의 유사, 리눅스에서 사용하는 추세, HeidiSQL(GUI)을 패키지에 포함
//		-> PostgreSQL : 관계 객체형 데이터베이스, 리눅스에서 많이 사용.
//		-> MongoDB : SQL을 사용하지 않는 RDBMS
//	
//	SQL : Structured Query Language, 구조화된 질의 언어
//		대화식 언어, 선언적 언어이다.
//		DML, DDL, DCL, TCL 등이 있다.
//	
//	DML : SELECT, INSERT, UPDATE, DELETE, MERGE 등
//	DDL : CREATE, ALTER, DROP, RENAME, TRUNCATE 등
//	DCL : GRANT, REVOKE
//	TCL : COMMIT, ROLLBACK, SAVEPOINT
//	
//	
//	
//	Java와 DB의 연동 -> Connection, Statement, PreparedStatement, ResultSet 등의 객체가 필요
//	1. 사용하고자 하는 RDBMS에서 제공하는 JDBC 드라이버 설치, 로딩(forName() 메소드 사용)
//	2. DBMS와 연결을 설정(JDBC URL로 연결한 DB 설정, Connection 객체 사용) -> URL 양식은 구글링하면 잘 나옴
//	3.1 Statement 생성 및 실행. executeQuery(), executeUpdate(), createStatement(), prepareStatement(), PreparedStatement 객체 등 사용
//		-> 문자열 연산자로 변수를 sql 안에 하나씩 넣어놓기
//		-> '?' 안에 값 집어넣기 : pstmt.setString(n, value), pstmt.executeUpdate();
//	3.2 필요한 경우 조회한 결과를 변수에 담아서 view로 전달하기(ResultSet 안에 담긴 정보를 하나씩 저장)
//		-> 예시
//		ResultSet rs = pstmt.executeQuery();
//		while(rs.next()) {
//			name = rs.getString("name"); // or rs.getString(1);
//			age = rs.getInt("age"); // or rs.getInt(2);
//		}
//		rs.close();
//	4. Statement.close() 수행
//	
//	ResultSet : DB의 조회 결과를 담는 객체
//		boolean next() : 커서를 다음 행으로 이동. 적어도 한 번은 호출해야 첫 번째 행을 가리키게 됨. 성공적으로 이동하면 true. 이동할 수 없거나 결과가 없다면 false.
//		boolean previous() : 커서를 이전 행으로 이동. next와 마찬가지로 boolean 타입으로 return한다.
//		Statement getStatement() : 현재 ResultSet을 생성한 Statement를 반환한다.
//		<자료형> get<자료형>(String name) 또는
//		<자료형> get<자료형>(int index) : name(index)에 해당하는 데이터를 return.
}
















