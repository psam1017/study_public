package com.online.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Oper")
public class Oper extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Oper() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		String input = request.getParameter("input");
		String opers = "+-*/";
		String[] arTemp = null;
		int temp = 0, result = 0, count = 0;
		Calc c = null;
		
		PrintWriter out = response.getWriter();
		
		input = input.replaceAll(" ", "");
		
		for(int i = 0; i < opers.length(); i++) {
			for(int j = 0; j < input.length(); j++) {
				if(opers.charAt(i) == input.charAt(j)) {
					temp = i;
					count++;
				}
			}
		}
		
		out.print("<p>");
		if(count == 1) {
			// 0 : 첫 번째 정수.
			// 1 : 두 번째 정수.
			arTemp = input.split("\\" + opers.charAt(temp));
			
			try {
				c = new Calc(Integer.parseInt(arTemp[0]), Integer.parseInt(arTemp[1]));
				
				switch(temp) {
				case 0:
					result = c.add();
					break;
				case 1:
					result = c.sub();
					break;
				case 2:
					result = c.multi();
					break;
				case 3:
					result = c.div();
					break;
				}
				out.print("결과 : " + result);
			} catch (NumberFormatException e) {
				out.print("정수만 입력하시오.");
			} catch (ArithmeticException e) {
				out.print("0으로 나눌 수 없음.");
			} 
		} else if(count == 0){
			// 연산자를 찾을 수 없음.
			out.print("연산자를 찾을 수 없음.");
		} else {
			// 두 정수의 연산만 가능함.
			out.print("두 정수의 연산만 가능함.");
		}
		out.print("</p>");
		
		out.print("<a href='calc'>JSP 페이지로 이동</a>");
		
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
