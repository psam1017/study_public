<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>

	<jsp:include page="market_header.jsp"/>
	
	<div class="jumbotron">
		<div class="container text-center">
			<h1 class="display-3">상품목록</h1>
		</div>
	</div>
	
	<div class="container" align="center">
		<div class="col-md-4 col-md-offset-4">
			<h3 class="form-signin-heading">Please Sign in</h3>
			<%
				String error = request.getParameter("error");
				if(error != null){
			%>
					<%= "<div class='alert alert-danger'>" %>
					<%= "아이디와 비밀번호를 확인해주세요." %>
					<%= "</div>" %>
			<%
				}
			%>
			<form class="form-signin" action="j_security_check" method="post">
				<div class="form-group">
					<label for="inputUsername" class="sr-only">User Name</label>
					<input type="text" class="form-control" placeholder="ID" name="j_username" required autofocus>
				</div>
				<div>
					<label for="inputPassword" class="sr-only">Password</label>
					<input type="password" class="form-control" placeholder="Password" name="j_password" required>
				</div>
				<button class="btn btn-lg btn-success btn-block" type="submit">로그인</button>
			</form>
		</div>
	</div>

	<jsp:include page="market_footer.jsp"/>
</body>
</html>