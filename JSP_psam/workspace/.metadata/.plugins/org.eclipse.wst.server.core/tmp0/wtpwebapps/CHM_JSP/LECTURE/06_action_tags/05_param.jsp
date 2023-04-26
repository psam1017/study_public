<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파라미터 태그</title>
</head>
<body>
	<%
		// jsp:param은 forward 또는 include 안에서 사용할 수 있다.
		// 스크립틀릿 태그 - 표현문을 쓴다면, 같은 페이지 내의 변수를 바로 쓸 수 있지만,
		// EL문을 쓴다면 스코프에 주의해야 한다. 02_forward_process.jsp 참고.
		// java.net.URLEncoder.encode() 또는 java.net.URLDecoder.decode()로 인코딩을 맞출 수도 있다.
	%>
	<jsp:include page="calculation.jsp">
		<jsp:param value="111" name="num1"/>
	</jsp:include>
</body>
</html>