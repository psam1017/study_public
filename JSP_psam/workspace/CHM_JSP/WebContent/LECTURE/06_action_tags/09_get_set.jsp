<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>setProperty 태그</title>
</head>
<body>
	<jsp:useBean id="person" class="_06_action_tags.Person" scope="request"/>
	<jsp:setProperty property="id" name="person" value="101"/>
	<jsp:setProperty property="name" name="person" value="어드민"/>
	<p> 아이디 : <jsp:getProperty property="id" name="person"/>
	<p> 이름 : <jsp:getProperty property="name" name="person"/>
</body>
</html>