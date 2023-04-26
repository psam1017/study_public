<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>디렉티브 태그</title>
</head>
<body>
	<%--
		<jsp:include page="/LECTURE/05_tags/header.jsp"/>
		include를 사용할 때는 태그를 열고 닫아야 하며, 그 안에는 jsp:param이 들어갈 수 있다.
		만약 닫지 않으면 오류가 발생한다.
	--%>
	<%@ include file="header.jsp"%>
	<main>
		<section>
			<p>메인영역입니다.</p>
		</section>
	</main>
</body>
</html>