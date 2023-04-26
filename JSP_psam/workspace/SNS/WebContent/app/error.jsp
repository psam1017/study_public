<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<jsp:useBean id="now" class="java.util.Date" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SNS 오류 페이지</title>
</head>
<body>
	<p> 현재 : ${now}
	<p> 요청 실패 URI : ${pageContext.errorData.requestURI}
	<p> 상태코드 : ${pageContext.errorData.statusCode}
	<p> 예외유형 : ${pageContext.errorData.throwable}
</body>
</html>