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
<title>Welcome</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>

	<jsp:include page="../market_header.jsp"/>
	
	<div class="jumbotron">
		<div class="container text-center">
			<h1 class="display-3">상품목록</h1>
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
				<a href="product.jsp?productID=<%=rs.getString("p_id")%>">
					<span class="btn btn-secondary" role="button">
						상세정보 보기
					</span>
				</a>
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
	<jsp:include page="../market_footer.jsp"/>
</body>
</html>