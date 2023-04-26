package com.psm.app.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.psm.app.action.Action;
import com.psm.app.action.ActionForward;
import com.psm.app.member.dao.MemberDAO;

public class MemberLoginOk implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		MemberDAO dao = new MemberDAO();
		ActionForward forward = new ActionForward();
		String memberId = req.getParameter("memberId");
		String memberPw = req.getParameter("memberPw");
		HttpSession session = req.getSession();
		
		forward.setRedirect(true);
		
		if(dao.login(memberId, memberPw)) {
			session.setAttribute("sessionId", memberId);
			forward.setPath(req.getContextPath() + "/board/BoardListOk.bo");
		} else {
			forward.setPath(req.getContextPath() + "/member/MemberLogin.me?code=false");
		}
		
		return forward;
	}

}
