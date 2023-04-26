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
	
	upload.setSizeMax(5 * 1024 * 1024);
	upload.setSizeThreshold(4 * 1024);
	upload.setRepositoryPath(path);
	
	@SuppressWarnings({"rawtypes", "deprecation"})
	List items = upload.parseRequest(request);
	
	@SuppressWarnings("rawtypes")
	Iterator params = items.iterator();
	
	while(params.hasNext()){
		FileItem item = (FileItem)params.next();
		
		if(item.isFormField()){
			String name = item.getFieldName();
			String value = item.getString("UTF-8");
			out.print(name + " : " + value + "<br>");
		}
		else{
			String fileFieldName = item.getFieldName();
			String fileName = item.getName();
			String contentType = item.getContentType();
			
			fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
			long fileSize = item.getSize();
			
			File file = new File(path + "\\" + fileName);
			item.write(file);
			
			out.print("요청 파라미터 이름 : " + fileFieldName + "<br>");
			out.print("저장 파일 이름 : " + fileName + "<br>");
			out.print("파일 콘텐츠 이름 : " + contentType + "<br>");
			out.print("파일 크기 : " + fileSize + "<br>");
		}
	}
%>
