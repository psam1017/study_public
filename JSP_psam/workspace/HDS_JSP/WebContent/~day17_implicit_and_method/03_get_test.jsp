<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GET 방식의 요청</title>
</head>
<body>
	<h1>Get 방식의 요청</h1>
	<form action="04_post_test.jsp">
		<!-- target 생략 시 _self, method 생략 시 get -->
		<input type="text" value="Seoul" name="city" readonly>
		<input type="text" value="12345" name="zipcode" readonly>
		<button>GET 방식으로 요청 보내기</button>
	</form>
	
	<%
		String city = request.getParameter("city");
		String zipcode = request.getParameter("zipcode");
		
		if(city == null || zipcode == null){
			response.sendRedirect("04_post_test.jsp");
		}
		else{
			out.print("<p>");
			out.print(city + "<br>");
			out.print(zipcode);
			out.print("</p>");
		}
	%>
</body>
</html>