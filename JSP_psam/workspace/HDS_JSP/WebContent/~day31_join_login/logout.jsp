<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
session.invalidate(); // 세션 전체 삭제

//특정 세션 값 삭제
// session.removeAttribute("id");
%>
<script>
	location.href="login.jsp";
</script>