<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>뉴스 목록</h2>
	<c:if test="${ newslist eq null }">
		<script>
			location.replace("news.nhn?action=listNews");
		</script>
	</c:if>
		<div style="width:100%; display:flex; justify-content: space-around;">
			<span style="display:block; width:50%; text-align:center;">제목</span>
			<span style="display:block; width:50%; text-align:center;">삭제버튼</span>
		</div>
	<c:forEach var="var" items="${newslist}">
		<div style="width:100%; display:flex; justify-content: space-around;">
			<a style="display:block; width:50%; text-align:center;" href="news.nhn?action=getNews&aid=${var.aid}"><c:out value="${var.title}" /></a>
			<a style="display:block; width:50%; text-align:center;" href="news.nhn?action=deleteNews&aid=${var.aid}">삭제</a>
		</div>
	</c:forEach>	
	<br><br>
	<form method="post" action="news.nhn?action=addNews" enctype="multipart/form-data">
		<input name="title" type="text">
		<input name="file" type="file">
		<input name="content" type="text">
		<input type="submit" value="전송">
	</form>
</body>
</html>