<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오류발생</title>
</head>
<body>
	<form name="redirectForm" action="./address_book_control.jsp">
		<input type="hidden" name="action" value="list">
	</form>
</body>
<script>
	alert("잘못된 요청입니다.");
	document.redirectForm.submit();
</script>
</html>