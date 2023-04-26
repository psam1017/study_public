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
	
	String sql = "INSERT INTO product VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, productID);
	pstmt.setString(2, pName);
	pstmt.setInt(3, price);
	pstmt.setString(4, description);
	pstmt.setString(5, category);
	pstmt.setString(6, manufacturer);
	pstmt.setLong(7, stock);
	pstmt.setString(8, condition);
	pstmt.setString(9, fileName);
	pstmt.execute();
	
	if(pstmt != null){
		pstmt.close();
	}
	if(conn != null){
		conn.close();
	}
	
	response.sendRedirect("market.jsp");
%>
