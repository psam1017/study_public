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

try {
	Class.forName(driver);
	conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
	if(conn != null) {
		System.out.println("DB 연결 성공!");
	}
} catch(ClassNotFoundException e) {
		e.printStackTrace();
} catch(SQLException e) {
		e.printStackTrace();
} finally{
	if(conn != null){
		conn.close();
	}
}
%>