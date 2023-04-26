<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Include Tag</title>
</head>
<body>
	<%--
		include 속성에 flush는 false로 하는 게 좋다.
		인클루드 태그에서는 pageScope의 자원을 사용할 수 있다.
		하지만, 액션태그의 include에서는 pageScope의 자원을 사용할 수 없다. requestScope부터 사용할 수 있다.
	--%>
	<p> jsp:include로 다른 파일의 내용 가져오기! </p>
	<jsp:include page="date.jsp" flush="false"/>
</body>
</html>