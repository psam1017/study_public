<%@page import="java.io.File"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드 실습</title>
</head>
<body>
	<form name="cosForm" id="cosForm" action="cos_process.jsp" method="post" enctype="multipart/form-data">
		<input type="file" name="file">
		<input type="submit">
	</form>
</body>
<script>
	function checkForm(){
		const checkForm = document.getElementById("uploadForm");
		const mb = 1024 * 1024;
		const max = 5;
		const checkFileSize = max * mb;
	}
</script>
</html>