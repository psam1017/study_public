<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.DiskFileUpload"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>
	<meta charset="UTF-8">
	<title>File Upload</title>
</head>
<%
	String path = "C:\\Users\\HP\\Desktop\\Coding\\JSP_psam\\workspace\\CHM_JSP\\WebContent\\LECTURE\\upload";
	
	@SuppressWarnings("deprecation")
	DiskFileUpload upload = new DiskFileUpload();
	
	@SuppressWarnings({"rawtypes", "deprecation"})
	List items = upload.parseRequest(request);
	
	@SuppressWarnings("rawtypes")
	Iterator params = items.iterator();
	
	while(params.hasNext()){
		FileItem fileItem = (FileItem)params.next();
		
		if(!fileItem.isFormField()){
			String fileName = fileItem.getName();
			out.print(fileName);
			fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
			File file = new File(path + "\\" + fileName);
			fileItem.write(file);
		}
	}
%>
