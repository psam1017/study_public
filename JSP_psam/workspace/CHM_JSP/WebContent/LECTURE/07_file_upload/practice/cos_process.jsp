<%@page import="java.io.File"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MultipartRequest multi = new MultipartRequest(request,
			"C:\\Users\\HP\\Desktop\\Coding\\JSP_psam\\workspace\\CHM_JSP\\WebContent\\LECTURE\\upload",
			5 * 1024 * 1024,
			"UTF-8",
			new DefaultFileRenamePolicy());

	@SuppressWarnings("rawtypes")
	Enumeration files = multi.getFileNames();
	
	while(files.hasMoreElements()){
		String name = (String)files.nextElement();
		String filename = multi.getFilesystemName(name);
		String original = multi.getOriginalFileName(name);
		String type = multi.getContentType(name);
		File file = multi.getFile(name);
		
		out.print("요청 파라미터 이름 : " + name + "<br>");
		out.print("실제 파일 이름 : " + original + "<br>");
		out.print("저장 파일 이름 : " + filename + "<br>");
		out.print("파일 콘텐츠 타입 : " + type + "<br>");
		
		if(file != null){
			out.print("파일 크기 : " + file.length());
			out.print("<br>");
		}
	}
%>