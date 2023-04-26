<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL, EL 실습 1</title>
</head>
<body>
<!-- 
	사용자에게 이름을 입력 받고 확인 버튼을 눌렀을 때
	admin인 경우 "관리자", member인 경우 "일반회원"으로 분류.
	param 객체를 사용해야 함.
	그 외에는 "비회원"으로 분류.
	
	1. 다른 페이지 없이 현재 페이지에서만 처리하고,
	결과가 출력될 때는 input 태그와 submit 버튼이 나와서는 안 된다.
	2. form 태그 속성은 action을 생략하면 현재 페이지로 이동된다.
	3. EL, JSTL만 사용하고, JS는 사용하지 않기
 -->
 	<c:choose>
		<c:when test="${ empty param.name }">
		  <form>
				<input type="text" name="name">
				<input type="submit" value="확인">
		  </form>
		</c:when>
 		<c:when test="${param.name == 'admin' }">
 			<h1>관리자</h1>
 		</c:when>
 		<c:when test="${param.name == 'member' }">
 			<h1>일반회원 : <c:out value="${param.name }"></c:out> </h1>
		</c:when>
 		<c:otherwise>
 			<h1>비회원</h1>
		</c:otherwise>
 	</c:choose>
</body>
</html>