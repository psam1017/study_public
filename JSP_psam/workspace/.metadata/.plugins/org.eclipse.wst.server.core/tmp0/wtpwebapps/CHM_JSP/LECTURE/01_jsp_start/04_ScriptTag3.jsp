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
		// 선언문 태그 사용 예시 : 전역메소드를 선언한다.
		public int myMethod(int count){
			count++;
			return count;
		}
	%>
	<p>I put 5 into global method named "myMethod", which makes passed argument increased by 1. Then the result is ... 
	<%=myMethod(5)%>
	</p>
</body>
</html>
