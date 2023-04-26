<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="mvc.dto.AddressBookDTO"%>
<%@ page import="mvc.dao.AddressBookDAO"%> 
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>주소록:목록화면</title>
	<link rel="stylesheet" href="../resources/css/address_book.css" type="text/css" media="screen" />
	<script type="text/javascript">
		function check(ID) {
			pwd = prompt('수정/삭제 하려면 비밀번호를 넣으세요');
			document.location.href="address_book_control.jsp?action=edit&id=" + ID + "&password=" + pwd;
		}
	</script>
</head>
<body>
	<div align="center">
		<h2>주소록:목록화면</h2>
		<hr>
		<form>
		<a href="./address_book_form.jsp">주소록 등록</a><br>

		<table border="1">
			<tr>
				<th>번호</th>
				<th>이 름</th>
				<th>전화번호</th>
				<th>생 일</th>
				<th>회 사</th>
				<th>메 모</th></tr>
			<%
				@SuppressWarnings("unchecked")
				ArrayList<AddressBookDTO> datas = (ArrayList<AddressBookDTO>)request.getAttribute("datas");
				for(AddressBookDTO addressBookDTO : datas) {
			%>
			<tr>
				<td><a href="javascript:check(<%=addressBookDTO.getId()%>)"><%=addressBookDTO.getId() %></a></td>
				<td><%=addressBookDTO.getName()%></td>
				<td><%=addressBookDTO.getTel()%></td>
				<td><%=addressBookDTO.getBirth()%></td>
				<td><%=addressBookDTO.getComdept()%></td>
				<td><%=addressBookDTO.getMemo()%></td></tr>
			 <%
				}
			 %>
		</table>
		</form>
	</div>
</body>
</html>