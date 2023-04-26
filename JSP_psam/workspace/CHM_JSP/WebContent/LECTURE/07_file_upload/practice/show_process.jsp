<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.DiskFileUpload"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>
	<meta charset="UTF-8">
	<title>File Upload</title>
</head>
<%
	request.setCharacterEncoding("UTF-8");

	// String path = request.getServletContext().getRealPath("/LECTURE/upload");
	String path = "C:\\Users\\HP\\Desktop\\Coding\\JSP_psam\\workspace\\CHM_JSP\\WebContent\\LECTURE\\upload";
	File dir = new File(path);
	if(!dir.exists()){
		dir.mkdirs();
	}

	DiskFileUpload upload = new DiskFileUpload();
	List items = upload.parseRequest(request);
	Iterator params = items.iterator();
	String fileName = null;
	
	while(params.hasNext()){
		FileItem item = (FileItem)params.next();
		
		if(!item.isFormField()){
			fileName = item.getName();
			File file = new File(path + "/" + fileName);
			item.write(file);
		}
	}
%>
<body>
	<img src="${pageContext.request.contextPath}/LECTURE/upload/<%=fileName%>">
</body>
