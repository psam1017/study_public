<%@page import="java.util.ArrayList"%>
<%@page import="mvc.dao.AddressBookDAO"%>
<%@page import="mvc.dto.AddressBookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String action = request.getParameter("action");
	
	AddressBookDTO dto = new AddressBookDTO();
	AddressBookDAO dao = new AddressBookDAO();
	
	if(action.equals("list")){
		ArrayList<AddressBookDTO> datas = dao.getDBList();
		request.setAttribute("datas", datas);
		pageContext.forward("address_book_list.jsp");
	}
	else if(action.equals("insert")){
		dto.setName(request.getParameter("name"));
		dto.setEmail(request.getParameter("email"));
		dto.setTel(request.getParameter("tel"));
		dto.setBirth(request.getParameter("birth"));
		dto.setComdept(request.getParameter("comdept"));
		dto.setMemo(request.getParameter("memo"));
		
		if(dao.insertDB(dto)){
			response.sendRedirect("address_book_control.jsp?action=list");
		}
		else{
			throw new Exception("DB 입력 오류");
		}
	}
	else if(action.equals("edit")){
		if(request.getParameter("password").equals("1234")){
			dto = dao.getDB(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("dto", dto);
			pageContext.forward("address_book_edit_form.jsp");
		}
		else{
			out.print("<script>alert('비밀번호는 1234입니다.'); history.go(-1);</script>");
		}
	}
	else if(action.equals("update")){
		dto.setId(Integer.parseInt(request.getParameter("id")));
		dto.setName(request.getParameter("name"));
		dto.setEmail(request.getParameter("email"));
		dto.setTel(request.getParameter("tel"));
		dto.setBirth(request.getParameter("birth"));
		dto.setComdept(request.getParameter("comdept"));
		dto.setMemo(request.getParameter("memo"));
		
		if(dao.updateDB(dto)){
			response.sendRedirect("address_book_control.jsp?action=list");
		}
		else{
			throw new Exception("DB 입력 오류");
		}
	}
	else if(action.equals("delete")){
		if(dao.deleteDB(Integer.parseInt(request.getParameter("id")))){
			response.sendRedirect("address_book_control.jsp?action=list");
		}
		else{
			throw new Exception("DB 입력 오류");
		}
	}
	else{
		response.sendRedirect("address_book_error.jsp");
	}
%>