<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>폼 태그 값 받기</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		
		// id를 배열로 가져오고, 첫 번째 인덱스의 값을 저장. 결국 같은 결과가 나온다.
		String id = request.getParameterValues("id")[0];
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		String sex = request.getParameter("sex");
		
		// 체크박스의 여러 값을 배열로 받을 때 아래와 같이 배열을 선언한다.
		// 만약 checkbox의 value가 없다면, 기본값으로 on이 전달된다.
		String[] hobby = request.getParameterValues("hobby");
		String comment = request.getParameter("comment");
	%>
	<p> 아이디	<%= id%>
	<p> 비밀번호	<%= pw%>
	<p> 이름	<%= name%>
	<p> 연락처	<%= phone1%> - <%= phone2 %> - <%= phone3 %>
	<p> 성별	<%= sex%>
	<p> 취미	
	<%
		if(hobby != null){
			for(int i = 0; i < hobby.length; i++){
				out.print(" " + hobby[i]);
			}
		}
	%>
	<p> 가입인사	<%= comment%>
</body>
</html>
