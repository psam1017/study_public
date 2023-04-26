package com.psm.app.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.psm.app.action.Action;
import com.psm.app.action.ActionForward;
import com.psm.app.board.dao.BoardDAO;
import com.psm.app.files.dao.FilesDAO;

public class BoardViewOk implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		BoardDAO bDao = new BoardDAO();
		FilesDAO fDao = new FilesDAO();
		ActionForward forward = new ActionForward();
		
		int boardNum = Integer.parseInt(req.getParameter("boardNum"));
		
		req.setAttribute("board", bDao.getDetail(boardNum));
		req.setAttribute("files", fDao.getFiles(boardNum));
		
		// 추가 작업 내용
		// 접근한 주소의 IP 정보를 가져와서 비교한 후 처음 접근한 IP라면 조회수를 상승시키기
		
		bDao.updateReadCount(boardNum);
		
		forward.setRedirect(false);
		forward.setPath("/app/board/boardView.jsp");
		
		return forward;
	}
}
