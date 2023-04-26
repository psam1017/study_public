<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
final String driver = "org.mariadb.jdbc.Driver";
final String DB_HOST = "127.0.0.1";
final String DB_PORT = "12601";
final String DB_NAME = "sample";

final String DB_URL = "jdbc:mariadb://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME;
final String DB_USER = "root";
final String DB_PASS = "test1234";

Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

try{
	Class.forName(driver);
	conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
} catch(ClassNotFoundException e){
	System.out.println("드라이버 연결 실패!");
	e.printStackTrace();
} catch(SQLException e){
	System.out.println("SQL 구문 오류!");
	e.printStackTrace();
}
%>