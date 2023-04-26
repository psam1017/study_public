<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>처리/연산 페이지</title>
</head>
<body>
	<%
		// jsp:param은 forward 또는 include 안에서 사용할 수 있다.
		// 스크립틀릿 태그 - 표현문을 쓴다면, 같은 페이지 내의 변수를 바로 쓸 수 있지만,
		// EL문을 쓴다면 스코프에 주의해야 한다. 이 예제의 경우 아래의 2가지를 EL 안에 사용할 수 있다.
		// 1. pageScope(즉, 쿼리스트링)에 있는 ${param.name}
		// 2. request headers에 만든 ${text}
		// 
		// java.net.URLEncoder.encode() 그리고 java.net.URLDecoder.decode()로 인코딩을 맞출 수도 있다.

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String text = request.getParameter("name");
		text = text + "님 안녕하세요!";
		request.setAttribute("text", text);
	%>
	<jsp:forward page="03_forward_result.jsp">
		<jsp:param value="${text}" name="text"/>
		<jsp:param value="${param.name}" name="name"/>
	</jsp:forward>
</body>
</html>