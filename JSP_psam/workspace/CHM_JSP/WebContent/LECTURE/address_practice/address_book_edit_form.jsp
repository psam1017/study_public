<%@page import="mvc.dto.AddressBookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="./address_book_error.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>주소록:수정화면</title>
	<link rel="stylesheet" href="../resources/css/address_book.css" type="text/css" media="screen" />
</head>
<body>
	<%
		AddressBookDTO dto = (AddressBookDTO) request.getAttribute("dto");
	%>
	<div align="center">
		<h2>주소록:수정화면</h2>
		<hr>
		[<a href="./address_book_control.jsp?action=list">주소록 목록</a>]으로<br>
		<form name="frmUpdate" method="post" action="./address_book_control.jsp">
			<input type="hidden" name="id" value="<%=dto.getId()%>">
			<input type="hidden" name="action" value="update">
			<table border="1">
				<tr>
					<th>이름</th>
					<th>이메일</th>
					<th>전화번호</th>
					<th>생일</th>
					<th>회사</th>
					<th>메모</th>
				</tr>
				<tr>
					<td><input value="<%=dto.getName()%>" type="text" name="name" maxlength="100"></td>
					<td><input value="<%=dto.getEmail()%>" type="email" name="email" maxlength="100"></td>
					<td><input value="<%=dto.getTel()%>" type="text" name="tel" maxlength="100"></td>
					<td><input value="<%=dto.getBirth()%>" type="date" name="birth" maxlength="100"></td>
					<td><input value="<%=dto.getComdept()%>" type="text" name="comdept" maxlength="100"></td>
					<td><input value="<%=dto.getMemo()%>" type="text" name="memo" maxlength="100"></td>
				</tr>
			</table>
			<br>
			<input type="submit" value="수정">
			<button type="button" id="deleteButton">삭제</button>
		</form>
	</div>
</body>
<script>
	document.getElementById("deleteButton").addEventListener("click", function(){
		delCheck();
	});

	function delCheck(){
		let result = confirm("정말로 삭제하시겠습니까?");
		
		if(result){
			document.frmUpdate.action.value="delete";
			document.frmUpdate.submit();
		}
	}
</script>
</html>