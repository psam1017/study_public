<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File Upload</title>
</head>
<body>
	<form method="post" enctype="multipart/form-data" action="04_commons2_process.jsp">
		<p> 이름 : <input type="text" name="name">
		<p> 제목 : <input type="text" name="subject">
		<p> 파일 : <input type="file" name="filename">
		<p> <input type="submit" name="파일 올리기">
	</form>
</body>
</html>
