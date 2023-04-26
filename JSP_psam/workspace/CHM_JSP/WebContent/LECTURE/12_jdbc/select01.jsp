<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="dbconn.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Database SQL</title>
</head>
<body>
	<table style="width : 300px;" border="1">
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
		</tr>
<%
	ResultSet rs = null;
	Statement stmt = null;
	
	try{
		String sql = "SELECT * FROM `member`";
		stmt = conn.createStatement();
		
		rs = stmt.executeQuery(sql);
		
		while(rs.next()){
			String id = rs.getString("id");
			String password = rs.getString("password");
			String name = rs.getString("name");
%>
		<tr>
			<td><%= id %></td>
			<td><%= password %></td>
			<td><%= name %></td>
		</tr>
<%
		}
	} catch(SQLException e){
		e.printStackTrace();
	} finally{
		if(rs != null){
			rs.close();
		}
		if(stmt != null){
			stmt.close();
		}
		if(conn != null){
			conn.close();
		}
	}
%>
	</table>
</body>
</html>