<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>EX04</title>
</head>
<body>
<h1>EX04 페이지입니다</h1>
<p>
	객체의 타입에서 앞글자만 소문자로 바뀐 값이 key 값이 되어 view에서 사용할 수 있다.<br>
	이 경우 존재하는 객체 타입은 InfoDTO이다. 이를 view에서 사용하려면 infoDTO로 사용해야 한다.<br>
	따라서, FrontController에서 선언한 참조변수의 이름이랑은 상관 없이 객체 타입의 이름이 중요하다.<br>
	또한, private으로 선언된 필드더라도 직접 접근하는 것처럼 사용하면 알아서 getter를 실행하여 가져온다.
</p>
<p> 이름 : <c:out value="${infoDTO.name}"/></p>
<p> 나이 : <c:out value="${infoDTO.age}"/></p>
<hr>
<p>
	만약, default key를 사용하고 싶지 않다면,<br>
	실행 메소드에서 parameter 앞에 @ModelAttribute("키값")을 선언하면 된다.
</p>
<p> 이름 : <c:out value="${info.name}"/></p>
<p> 나이 : <c:out value="${info.age}"/></p>
</body>
</html>
