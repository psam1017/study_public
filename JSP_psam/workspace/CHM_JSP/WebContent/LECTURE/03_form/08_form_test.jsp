<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>폼 태그 테스트</title>
</head>
<body>
	<form action="#">
		사과 <input type="checkbox" name="fruit" value="apple">
		오렌지 <input type="checkbox" name="fruit" value="orange">
		바나나 <input type="checkbox" name="fruit" value="banana">
		<input type="submit">
	</form>
	<hr>
	<p>
	<%
		String[] fruit = request.getParameterValues("fruit");
		if(fruit != null){
			out.print("과일 : ");
			for(int i = 0; i < fruit.length; i++){
				out.print(" " + fruit[i]);
			}
		}
	%>
</body>
</html>