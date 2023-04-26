<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>국영수 점수 받기</title>
</head>
<body>
	<form>
		국어점수 <input type="text" name="kor"  value=""></input><br>
		수학점수 <input type="text" name="math" value=""></input><br>
		영어점수 <input type="text" name="eng"  value=""></input><br>
		<button>전송</button>
	</form>
	<c:if test="${not empty param.kor}">
		<c:set var="total" value="${param.kor + param.math + param.eng}"></c:set>
		<c:set var="avg" value="${total / 3}"></c:set>
		총점 : <c:out value="${total}"></c:out><br>
		<c:choose>
			<c:when test="${avg >= 60}">
				참 잘 했어요!
			</c:when>
			<c:otherwise>
				분발하세요!
			</c:otherwise>
		</c:choose>
	</c:if>
</body>
</html>