<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ include file="dbconn.jsp" %>
<%
	String productID = request.getParameter("productID");
	
	String sql = "SELECT * FROM product WHERE p_id = ?";
	
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, productID);
	
	rs = pstmt.executeQuery();
	
	if(rs.next()){
		sql = "DELETE FROM product WHERE p_id = ?";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, productID);
		
		pstmt.executeUpdate();
	}
	else{
		out.print("해당 상품이 존재하지 않습니다.");
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
	
	response.sendRedirect("edit_product.jsp?edit=delete");
%>