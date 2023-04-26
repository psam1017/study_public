<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>우편번호 검색 테스트</title>
</head>
<body>
	<form action="#" method="get">
		<p> 이름 <input type="text" name="name" maxlength="5">
		<p> 우편번호 <input type="text" name="zipcode" class="postcodify_postcode5">
		    <input type="button" id="postcodify_search_button" value="우편번호 검색">
		<p> 도로명주소 <input type="text" name="address" class="postcodify_address">
		<p> 상세주소 <input type="text" name="addressDetail" class="postcodify_details">
		<p> 이메일 <input type="email" name="email">
		<input type="submit" value="제출">
	</form>
	<%
		String name = request.getParameter("name");
		String zipcode = request.getParameter("zipcode");
		String address = request.getParameter("address");
		String addressDetail = request.getParameter("addressDetail");
		String email = request.getParameter("email");
	%>
	<hr>
	<p> 이름 <%= name %>
	<p> 우편번호 <%= zipcode %>
	<p> 도로명주소 <%= address %>
	<p> 상세주소 <%= addressDetail %>
	<p> 이메일 <%= email %>
</body>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
<script> $(function() { $("#postcodify_search_button").postcodifyPopUp(); }); </script>
</html>