<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File Upload</title>
</head>
<body>
	<form name="fileForm" method="post" enctype="multipart/form-data" action="02_cos2_process.jsp">
		<p> 이 름1 : <input type="text" name="name1">
		<p> 제 목1 : <input type="text" name="subject1"> 
		<p> 파 일1 : <input type="file" name="filename1">
		<p> 이 름2 : <input type="text" name="name2">
		<p> 제 목2 : <input type="text" name="subject2"> 
		<p> 파 일2 : <input type="file" name="filename2">
		<p> 이 름3 : <input type="text" name="name3">
		<p> 제 목3 : <input type="text" name="subject3"> 
		<p> 파 일3 : <input type="file" name="filename3">
		<p> <input type="submit" name="파일 올리기">
	</form>
</body>
</html>