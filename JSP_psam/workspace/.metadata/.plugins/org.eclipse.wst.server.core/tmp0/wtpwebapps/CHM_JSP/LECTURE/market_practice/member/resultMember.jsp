<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>

	<jsp:include page="../market_header.jsp"/>

	<div class="jumbotron">
		<div class="container text-center">
			<h1 class="display-3">회원정보</h1>
		</div>
	</div>
	<div class="container" align="center">
		<%
			String msg = request.getParameter("msg");
		
		if(msg != null){
			if(msg.equals("0")){
				out.print("<h2 class='alert alert-danger'>회원정보가 수정되었습니다.</h2>");
			}
			else if(msg.equals("1")){
				out.print("<h2 class='alert alert-danger'>회원가입을 축하드립니다.</h2>");
			}
			else if(msg.equals("2")){
				String loginId = (String)session.getAttribute("sessionId");
				out.print("<h2 class='alert alert-danger'>" + loginId + "님 환영합니다.</h2>");
			}
		}
		else{
			out.print("<h2 class='alert alert-danger'>회원정보가 삭제되었습니다.</h2>");
		}
		%>
	</div>
	
	<jsp:include page="../market_footer.jsp"/>
	
</body>
</html>