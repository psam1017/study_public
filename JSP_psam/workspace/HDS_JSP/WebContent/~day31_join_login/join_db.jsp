<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<jsp:useBean class="dao.UserDAO" id="dao"></jsp:useBean> 
<jsp:useBean class="vo.UserVO" id="vo"></jsp:useBean>
<jsp:setProperty property="*" name="vo"></jsp:setProperty> <!-- dao에서, 참조변수 vo로, 모든 변수에 값을 가져옴. -->

<%
dao.join(vo);
response.sendRedirect("login.jsp");
System.out.print(vo.getName());
%>
