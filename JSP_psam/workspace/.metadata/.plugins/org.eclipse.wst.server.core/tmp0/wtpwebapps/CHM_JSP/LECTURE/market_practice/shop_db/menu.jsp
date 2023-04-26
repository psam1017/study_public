<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<%
	String sessionId = (String) session.getAttribute("sessionId");
%>
<nav class="navbar navbar-expand navbar-dark bg-dark">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="./welcome.jsp">Home</a>
		</div>
		<div>
			<ul class="navbar-nav mr-auto">
				<c:choose>
					<c:when test="${ empty sessionId }">
						<li class="nav-item"><a class="nav-link" href="<c:url value="/member/loginMember.jsp"/>">로그인</a></li>
						<li class="nav-item"><a class="nav-link" href="<c:url value="/member/addMember.jsp"/>">회원가입</a></li>
					</c:when>
					<c:otherwise>
						<li style="padding-top: 7px; color: white;">[<%= sessionId %>님]</li>
						<li class="nav-item"><a class="nav-link" href="<c:url value="/member/logoutMember.jsp"/>">로그아웃</a></li>
						<li class="nav-item"><a class="nav-link" href="<c:url value="/member/updateMember.jsp"/>">정보수정</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
		<div>
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link" href="./market2.jsp">상품목록</a></li>
				<li class="nav-item"><a class="nav-link" href="./add_product2.jsp">상품등록</a></li>
				<li class="nav-item"><a class="nav-link" href="./edit_product.jsp?edit=update">상품변경</a></li>
				<li class="nav-item"><a class="nav-link" href="./edit_product.jsp?edit=delete">상품삭제</a></li>
				<li class="nav-item"><a class="nav-link" href="./BoardListAction.do?pageNum=1">게시판</a></li>
			</ul>
		</div>
	</div>
</nav>
</body>
</html>