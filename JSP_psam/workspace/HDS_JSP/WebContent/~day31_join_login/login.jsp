<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<input type="hidden" name="type" value="<%= request.getParameter("type") %>">
	<form action="login_ok.jsp" name="loginForm" method="post">
		<div>
			<label>
				아이디 : <input type="text" name="id">
			</label>
			<label>
				비밀번호 : <input type="password" name="password">
			</label>
		</div>
		<p>
			<input type="button" value="로그인" onclick="login()">
		</p>
	</form>
</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/3.1.2/rollups/aes.js"></script>
<script>
	if(document.getElementById("type").value == false){
		alert("로그인 실패");
	}

	function login(){
		var form = document.loginForm;
		if(!form.id.value){
			alert("아이디를 입력해주세요.");
			return;
		}
		if(!form.password.value){
			alert("비밀번호를 입력해주세요.");
			return;
		}
		
		// 이후 연습할 때에는 암호화를 회원가입할 때 만들어보자. -> 회원가입 때도 암호화가 필요하다.
		form.password.value = btoa(form.password.value);
		
		form.submit();
	}
</script>
</html>