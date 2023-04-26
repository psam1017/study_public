package com.psm.app.board.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.psm.app.action.Action;
import com.psm.app.action.ActionForward;
import com.psm.app.board.dao.BoardDAO;
import com.psm.app.files.dao.FilesDAO;
import com.psm.app.files.vo.FilesVO;

public class BoardDeleteOk implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		String saveFolder = "C:\\Users\\HP\\Desktop\\Coding\\JSP_psam\\workspace\\board_mvc\\WebContent\\app\\upload";
		FilesDAO fDao = new FilesDAO();
		BoardDAO bDao = new BoardDAO();
		ActionForward forward = new ActionForward();
		
		int boardNum = Integer.parseInt(req.getParameter("boardNum"));
		
		// 첨부파일이 하나가 아니라 여러 개이므로 반복하여 첨부파일을 삭제해야 함.
		for(FilesVO file : fDao.getFiles(boardNum)) {
			// 업로드 경로에 있는 첨부 파일을 삭제
			File f = new File(saveFolder, file.getFileName());
			if(f.exists()) {
				f.delete();
			}
		}
		
		// 첨부파일을 먼저 삭제
		fDao.deleteFiles(boardNum);
		bDao.deleteBoard(boardNum);
		
		forward.setRedirect(false);
		forward.setPath("/board/BoardListOk.bo");
		
		return forward;
	}

}
