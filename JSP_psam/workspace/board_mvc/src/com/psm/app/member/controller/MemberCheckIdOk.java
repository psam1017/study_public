package com.psm.app.member.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.psm.app.action.Action;
import com.psm.app.action.ActionForward;
import com.psm.app.member.dao.MemberDAO;

public class MemberCheckIdOk implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String memberId = req.getParameter("memberId");
		MemberDAO dao = new MemberDAO();
		JSONObject obj = new JSONObject();
		PrintWriter out = resp.getWriter();
		
		if(dao.checkId(memberId)) {
			obj.put("status", "not-ok");
		} else {
			obj.put("status", "ok");
		}
		
		out.print(obj.toJSONString());
		out.close();
		
		// Ajax로 비동기 통신을 하므로 return 값이 따로 필요하지 않다.
		return null;
	}
}
