<%@ page contentType="application/msword"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>디렉티브 태그</title>
</head>
<body>
	<!--
		콘텐츠 유형이 마이크로소프트 워드이다.
		브라우저에서는 실행할 수 없고
		1. word에서 실행되거나
		2. 메모장에서 볼 수 있도록 파일을 저장한다.
	-->
	<!-- 
		import 속성으로 패키지, 클래스 가져와서 사용하기
	 -->
	<%@page import="java.util.Date"%>
	<p> Today : <%= new Date() %> </p>
</body>
</html>