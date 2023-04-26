<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean class="dao.UserDAO" id="dao"></jsp:useBean>
<%
if(dao.checkId(request.getParameter("id"))){
	out.print("중복된 아이디입니다.");
} else{
	out.print("사용가능한 아이디입니다.");
}
%>