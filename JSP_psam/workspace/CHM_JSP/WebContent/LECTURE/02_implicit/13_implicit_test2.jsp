<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Implicit Objects - response</title>
</head>
<body>
	<%
		response.setHeader("Refresh", "5");
	%>
	<%
		Calendar cal = Calendar.getInstance();
		String am_pm;
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int min = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);
		
		if(hour < 12){
			am_pm = "AM";
		}
		else{
			am_pm = "PM";
			hour -= 12;
		}
		
		String CT = hour + " : " + min + " : " + sec + " " + am_pm;
	%>
	<p>현재 시간은 ... <%= CT %></p>
	<form action="14_implicit_test2_process.jsp">
		<input type="submit" value="구글로 이동하기">
	</form>
</body>
</html>