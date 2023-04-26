<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL, EL 실습 2</title>
</head>
<body>
<!-- 
	사용자에게 입력 받은 정수로 구구단 출력
	값을 입력했는지 판단
	입력 받은 값이 정수인지 아닌지 판단
	다른 페이지 이동 없이 현재 페이지에서 구현
 -->
 <!--
	form 태그에서 action을 생략하면 현재 페이지로 전송되고,
 	method를 생략하면 get 방식으로 전달한다.
-->
 	<form name="gugudan">
 		<input type="text" name="number">
 		<button type="button" onclick="send()">전송</button>
 	</form>
 	
<!-- 
	외부에서 전달 받은 파라미터가 requestScope에 저장되지 않고
	쿼리 스트링을 통해 URL로 전달한다면 param 객체로 접근해야 한다.
 -->
 	<c:set var="dan" value="${param.number}"></c:set>

 	<c:if test="${not empty dan}">
	 	<c:forEach var="i" begin="1" end="9">
	 		<c:out value="${dan}"/> X <c:out value="${i}"/>
	 		 = <c:out value="${dan*i}"/>
	 		<br>
	 	</c:forEach>
 	</c:if>
</body>
<script>
	function send(){
		let frm = document.gugudan;
		let input = frm.number.value;
		let check = input % 1 == 0;
		if(!check || !Number.isInteger(parseInt(input)) || isNaN(input)){
			alert("정수만 입력해주세요.");
			return;
		}
		frm.number.value = parseInt(input);
		frm.submit();
	}
</script>
</html>