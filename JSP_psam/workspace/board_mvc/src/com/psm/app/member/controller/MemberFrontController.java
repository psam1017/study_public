package com.psm.app.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.psm.app.action.ActionForward;

// servlet은 컨트롤러에서 사용하고, JSP는 뷰에서 사용한다.
@SuppressWarnings("serial")
public class MemberFrontController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = requestURI.substring(contextPath.length());

		ActionForward forward = null;
		
		// 아래의 경로는 src 패키지 경로와는 무관하다. controller를 생략할 수 있다.
		// Ok는 "연산 또는 완료"의 의미를 가진다. 단순 이동이라면 Ok를 붙이지 않는다.
		if(command.equals("/member/MemberCheckIdOk.me")) {
			try {
				forward = new MemberCheckIdOk().execute(req, resp);
			} catch (Exception e) {
				System.out.println("아이디 중복검사 오류" + e);
			}
		}
		else if(command.equals("/member/MemberJoinOk.me")) {
			try {
				forward = new MemberJoinOk().execute(req, resp);
			} catch (Exception e) {
				System.out.println("회원가입 오류" + e);
			}
		}
		else if(command.equals("/member/MemberLoginOk.me")) {
				try {
					forward = new MemberLoginOk().execute(req, resp);
				} catch (Exception e) {
					System.out.println("로그인 오류" + e);
				}
		}
		else if(command.equals("/member/MemberLogin.me")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/app/member/login.jsp");
		}
		else if(command.equals("/member/MemberJoin.me")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/app/member/join.jsp");
		}
		else if(command.equals("/member/MemberLogoutOk.me")) {
			try {
				forward = new MemberLogoutOk().execute(req, resp);
			} catch (Exception e) {
				System.out.println("로그아웃 오류" + e);
			}
		}
		else if(command.equals("/member/MemberFindIdOk.me")) {
			try {
				forward = new MemberFindIdOk().execute(req, resp);
			} catch (Exception e) {
				System.out.println("아이디 찾기 오류" + e);
			}
		}
		else if(command.equals("/member/MemberFindId.me")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/app/member/findId.jsp");
		}
		
		// 리다이렉트할 때는 ContextPath가 필요.
		// 포워드할 때는 불필요.
		if(forward != null) {
			if(forward.isRedirect()) {
				resp.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = req.getRequestDispatcher(forward.getPath());
				dispatcher.forward(req, resp);
			}
		}
	}
}
