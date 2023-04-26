<%@page import="jdk.management.resource.internal.TotalResourceContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../dbconn.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
	<div class="jumbotron">
		<div class="container text-center">
			<h1 class="display-3">회원목록</h1>
		</div>
	</div>
	
	<div class="container">
		<table class="table table-hover table-striped text-center">
			<tr>
				<th>아이디</th>
				<th>이름</th>
			</tr>
		<%
		
		// 한 페이지에 2개만
		int cntListPerPage = 2;
		
		// 페이지 번호가 없으면 기본값은 1
		int pageNum = 1;
		if(request.getParameter("pageNum") != null){
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}
		
		// 1페이지 0, 2페이지 : 2, 3페이지 : 4, ...
		int startNum = (pageNum - 1) * cntListPerPage;
		String sql = "SELECT * FROM member ORDER BY id ASC LIMIT ? OFFSET ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, cntListPerPage);
		pstmt.setInt(2, startNum);
		rs = pstmt.executeQuery();
		while(rs.next()){
		%>
			<tr>
				<td><%= rs.getString("id") %></td>
				<td><%= rs.getString("name") %></td>
			</tr>
		<%
		}
		%>
		</table>
	</div>
	<%
	sql = "SELECT COUNT(1) FROM `member`";
	pstmt = conn.prepareStatement(sql);
	rs = pstmt.executeQuery();
	rs.next();
	int totalRecord = rs.getInt(1);
	int totalPage = (totalRecord % cntListPerPage == 0) ? totalRecord / cntListPerPage : (totalRecord / cntListPerPage) + 1;
	
	int block = 3;
	int blockTotal = totalPage % block == 0 ? totalPage / block : (totalPage / block) + 1;
	int blockThis = (pageNum - 1) / block + 1;
	int blockThisFirstPage = (blockThis - 1) * block + 1;
	int blockThisLastPage = blockThis * block;
	blockThisLastPage = (blockThisLastPage > totalPage) ? totalPage : blockThisLastPage;
	%>
	<p> totalPage : <%= totalPage %>
	<p> totalBlock : <%= blockTotal %>
	<p> thisBlock : <%= blockThis %>
	<p> firstPage : <%= blockThisFirstPage %>
	<p> lastPage : <%= blockThisLastPage %>
	<br>
	
	<a href="memberList.jsp?pageNum=1">첫 페이지</a> | 
	
	<% if(blockThis > 1){ %>
	<a href="memberList.jsp?pageNum=<%=(blockThisFirstPage - 1)%>">이전</a> | 
	<% } %>
	
	<% for(int i = blockThisFirstPage; i <= blockThisLastPage; i++){ %>
	<a href="memberList.jsp?pageNum=<%=i%>"><%= i %></a> | 
	<% } %>
	
	<% if(blockThis < blockTotal){ %>
	<a href="memberList.jsp?pageNum=<%=(blockThisLastPage + 1)%>">다음</a> | 
	<% } %>
	
	<a href="memberList.jsp?pageNum=<%=totalPage%>">마지막 페이지</a>
	
	<%
		if(rs != null){
			rs.close();
		}
		if(pstmt != null){
			pstmt.close();
		}
		if(conn != null){
			conn.close();
		}
	%>
</body>
</html>