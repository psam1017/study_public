<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.SQLException" %>
<%@ include file="02.conn_db.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
{ "listData" : [
<%
	request.setCharacterEncoding("UTF-8");
	
	String item = request.getParameter("item");
	String tableName = "todo_list";
	Statement statement = null;
	String sql = "SELECT * FROM " + tableName + " WHERE isChecked = 'false' ORDER BY num";
	
	try{
		statement = conn.createStatement();
	} catch(SQLException e){
		e.printStackTrace();
	}
	
	ResultSet resultSet = null;
	try{
		resultSet = statement.executeQuery(sql);
	} catch(SQLException e){
		e.printStackTrace();
	}
	
	while(resultSet.next()){
%>
{"item" : "<%=resultSet.getString("item")%>", "num" : <%=resultSet.getInt("num")%>}
<%
		if(!resultSet.isLast()){
			out.print(", ");
		}
	}

	if(resultSet != null){
		resultSet.close();
	}
	if(statement != null){
		statement.close();
	}
	if(conn != null){
		conn.close();
	}
%>
]}
