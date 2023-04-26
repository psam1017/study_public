<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.io.File"%>
<%@include file="dbconn.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String path = request.getServletContext().getRealPath("LECTURE/resources/images");
	File dir = new File(path);
	if(!dir.exists()){
		dir.mkdirs();
	}
	
	String filename = "";
	String encType = "utf-8";
	int maxSize = 5 * 1024 * 1024;
	
	MultipartRequest multi = new MultipartRequest(
			request,
			path,
			maxSize,
			encType,
			new DefaultFileRenamePolicy()
			);

	String productID = multi.getParameter("productID");
	String pName = multi.getParameter("pName");
	String unitPrice = multi.getParameter("unitPrice");
	String description = multi.getParameter("description");
	String manufacturer = multi.getParameter("manufacturer");
	String category = multi.getParameter("category");
	String unitsInStock = multi.getParameter("unitsInStock");
	String condition = multi.getParameter("condition");
	
	Integer price;
	
	if(unitPrice.isEmpty()){
		price = 0;
	}
	else{
		price = Integer.valueOf(unitPrice);
	}
	
	long stock;
	
	if(unitsInStock.isEmpty()){
		stock = 0;
	}
	else{
		stock = Long.valueOf(unitsInStock);
	}
	
	@SuppressWarnings("rawtypes")
	Enumeration files = multi.getFileNames();
	String fName = (String)files.nextElement();
	String fileName = multi.getFilesystemName(fName);
	
	String sql = "SELECT * FROM product WHERE p_id = ?";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, productID);
	rs = pstmt.executeQuery();
	
	if(rs.next()){
		if(fileName != null){
			sql = "UPDATE product SET p_name = ?, p_unitPrice = ?, p_description = ?, p_manufacturer = ?, p_category = ?, p_unitsInStock = ?, p_condition = ?, p_fileName = ? WHERE p_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pName);
			pstmt.setInt(2, price);
			pstmt.setString(3, description);
			pstmt.setString(4, manufacturer);
			pstmt.setString(5, category);
			pstmt.setLong(6, stock);
			pstmt.setString(7, condition);
			pstmt.setString(8, fileName);
			pstmt.setString(9, productID);
			pstmt.executeUpdate();
		}
		else{
			sql = "UPDATE product SET p_name = ?, p_unitPrice = ?, p_description = ?, p_manufacturer = ?, p_category = ?, p_unitsInStock = ?, p_condition = ? WHERE p_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pName);
			pstmt.setInt(2, price);
			pstmt.setString(3, description);
			pstmt.setString(4, manufacturer);
			pstmt.setString(5, category);
			pstmt.setLong(6, stock);
			pstmt.setString(7, condition);
			pstmt.setString(8, productID);
			pstmt.executeUpdate();
		}
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
	
	response.sendRedirect("edit_product.jsp?edit=update");
%>
