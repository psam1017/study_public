<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.io.File"%>
<%@page import="_06_action_tags.market.dto.ProductDTO"%>
<%@page import="_06_action_tags.market.dao.ProductDAO"%>
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
	
	ProductDAO dao = ProductDAO.getInstance();
	
	ProductDTO dto = new ProductDTO();
	
	dto.setProductID(productID);
	dto.setpName(pName);
	dto.setUnitPrice(price);
	dto.setDescription(description);
	dto.setManufacturer(manufacturer);
	dto.setCategory(category);
	dto.setUnitsInStock(stock);
	dto.setCondition(condition);
	dto.setFilename(fileName);
	
	dao.addProduct(dto);
	
	response.sendRedirect("market.jsp");
%>
