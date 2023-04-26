<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스크립트 태그</title>
</head>
<body>
	<%!
		// 선언문 태그를 사용하여 자바 변수와 메소드 정의
		int count = 3;
		String lower(String data){
			return data.toLowerCase();
		}
	%>
	<%
		// 스크립틀릿 태그로 자바 로직 코드 작성. 작성내용은 메소드 안에서 실행된다.
		for(int i = 1; i < count; i++){
			out.print("Java Server Page, for test" + i + "<br>");
		}
	%>
	<%-- 표현문 태그로 변수, 계산식, 메소드 호출 결과를 문자열 형태로 출력 --%>
	<%=lower("Hello World")%>
</body>
</html>
