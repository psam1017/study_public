<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GET 방식의 요청</title>
</head>
<body>
	<h1>GET 방식의 요청</h1>
	<button onclick="sendRequest()">GET 방식으로 요청 보내기</button>
	<p id="text"></p>
</body>
<script>
	function sendRequest(){
		var xhr = new XMLHttpRequest();
		xhr.open("GET", "02_request_ajax_get.jsp?city=Seoul&zipcode=12345", true);
		xhr.send();
		
		// xhr.onreadystatechange : XMLHttpRequest의 상태가 변할 때마다 실행되는 프로퍼티
		xhr.onreadystatechange = function(){
			if(xhr.readyState == XMLHttpRequest.DONE && xhr.status == 200){
				document.getElementById("text").innerHTML = xhr.responseText;
			}
		}
	}
</script>
</html>