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
	String sessionAdminId = (String) session.getAttribute("sessionAdminId");
	String sessionAdminName = (String) session.getAttribute("sessionAdminName");
	if(sessionAdminId == null){
		response.sendRedirect("loginAdmin.jsp");
	}
%>
<nav class="navbar navbar-expand navbar-dark bg-dark">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="../welcome.jsp">Home</a>
		</div>
		<div>
			<ul class="navbar-nav mr-auto">
				<c:choose>
					<c:when test="${ empty sessionId }">
						<li class="nav-item"><a class="nav-link" href="<c:url value="loginAdmin.jsp"/>">로그인</a></li>
					</c:when>
					<c:otherwise>
						<li style="padding-top: 7px; color: white;">[<%= sessionAdminId %>님]</li>
						<li class="nav-item"><a class="nav-link" href="<c:url value="/logoutAdmin.jsp"/>">로그아웃</a></li>
						<li class="nav-item"><a class="nav-link" href="<c:url value="/updateAdmin.jsp"/>">정보수정</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
		<div>
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link" href="<c:url value="logoutAdmin.jsp" />">로그아웃</a></li>
				<li class="nav-item"><a class="nav-link" href="<c:url value="updateAdmin.jsp" />">정보수정</a></li>
				<li class="nav-item"><a class="nav-link" href="<c:url value="memberList.jsp" />">회원목록</a></li>
				<li class="nav-item"><a class="nav-link" href="<c:url value="addProdct.jsp" />">상품등록</a></li>
				<li class="nav-item"><a class="nav-link" href="<c:url value="editProdct.jsp?edit=update" />">상품수정</a></li>
				<li class="nav-item"><a class="nav-link" href="<c:url value="editProdct.jsp?edit=delete" />">상품삭제</a></li>
			</ul>
		</div>
	</div>
</nav>
</body>
</html>