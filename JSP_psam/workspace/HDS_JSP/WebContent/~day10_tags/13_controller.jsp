<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>컨트롤러</title>
</head>
<body>
	<%
		String site = request.getParameter("site");
		String url = null;
		
		switch(site){
		case "naver":
			url = "14_forward_naver.jsp";
			break;
		case "daum":
			url = "15_forward_daum.jsp";
			break;
		case "google":
			url = "16_forward_google.jsp";
			break;
		}
	%>
	<!-- 스크립트 태그 없이 변수명 url을 적으면, page의 값을 url로 인식한다.
		따라서, url이라는 변수를 상황에 맞게 선언하기 위해 스크립트 태그를 사용해야 한다! -->
	<jsp:forward page="<%= url %>"></jsp:forward>
</body>
</html>