<%@ page import="java.sql.*"%>
<%
	Connection conn = null;

	try{
		String url = "jdbc:mariadb://localhost:12601/sample_jsp_todo_ajax";
		String user = "root";
		String password = "test1234";
		
		try{
			Class.forName("org.mariadb.jdbc.Driver");
		} catch(ClassNotFoundException e){
			out.print("드라이버 로딩이 실패했습니다.");
			out.print(e.getMessage());
		}
		conn = DriverManager.getConnection(url, user, password);
	} catch(SQLException e){
		out.print("쿼리를 실행하지 못 했습니다.");
		out.print(e.getMessage());
	}
%>