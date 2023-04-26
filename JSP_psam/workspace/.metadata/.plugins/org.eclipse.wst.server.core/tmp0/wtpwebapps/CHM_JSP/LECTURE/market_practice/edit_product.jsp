<%@page import="_06_action_tags.market.dao.ProductDAO"%>
<%@page import="_06_action_tags.market.dto.ProductDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="dbconn.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 편집</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
	<%
		String edit = request.getParameter("edit");
	%>
	<jsp:include page="market_header.jsp"/>
	
	<div class="jumbotron">
		<div class="container text-center">
			<h1 class="display-3">상품편집</h1>
		</div>
	</div>
	<div class="container">
		<div class="row" align="center">
			<%
				String sql = "SELECT * FROM product";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()){
			%>
			<div class="col-md-4">
				<img src="${pageContext.request.contextPath}/LECTURE/resources/images/<%=rs.getString("p_fileName")%>" style="width : 100%;"/>
				<h3><%= rs.getString("p_name") %></h3>
				<p> <%= rs.getString("p_description") %>
				<p> <%= rs.getString("p_unitPrice") %>원
				<br>
				<p>
				<%
					if(edit.equals("update")){
				%>
				<a class="btn btn-success" role="button" href="update_product.jsp?productID=<%=rs.getString("p_id")%>">수정 &raquo;</a>
				<%
					} else if(edit.equals("delete")){
				%>
				<a onclick="deleteConfirm('<%= rs.getString("p_id") %>')" class="btn btn-danger" role="button" href="#">삭제 &raquo;</a>
				<%
					}
				%>
			</div>
			<%
				}
				
				if(rs != null){
					rs.close();
				}
				if(pstmt != null){
					pstmt.close();
				}
				if(conn != null){
					conn.close();
				}
			%>
		</div>
	</div>
	<div class="container">
		<div class="btn btn-primary">
			<a href="add_product.jsp" style="color: black;">상품 등록하기</a>
		</div>
	</div>
	<jsp:include page="market_footer.jsp"/>
</body>
<script>
function deleteConfirm(id){
	if(confirm("해당 상품을 삭제합니다!") == true){
		location.href = "delete_product.jsp?productID=" + id;
	}
	else{
		return;
	}
}
</script>
</html>