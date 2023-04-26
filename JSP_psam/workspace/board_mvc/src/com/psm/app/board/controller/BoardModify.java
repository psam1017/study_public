package com.psm.app.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.psm.app.action.Action;
import com.psm.app.action.ActionForward;
import com.psm.app.board.dao.BoardDAO;

public class BoardModify implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		ActionForward forward = new ActionForward();
		int boardNum = Integer.parseInt(req.getParameter("boardNum"));
		BoardDAO bDao = new BoardDAO();
		
		req.setAttribute("board", bDao.getDetail(boardNum));
		
		forward.setRedirect(false);
		forward.setPath("/app/board/boardModify.jsp");
		
		return forward;
	}
}
