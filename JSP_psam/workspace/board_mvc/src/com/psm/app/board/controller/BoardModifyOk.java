package com.psm.app.board.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.psm.app.action.Action;
import com.psm.app.action.ActionForward;
import com.psm.app.board.dao.BoardDAO;
import com.psm.app.board.vo.BoardVO;
import com.psm.app.files.dao.FilesDAO;
import com.psm.app.files.vo.FilesVO;

public class BoardModifyOk implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		String saveFolder = "C:\\Users\\HP\\Desktop\\Coding\\JSP_psam\\workspace\\board_mvc\\WebContent\\app\\upload";
		int fileSize = 1024 * 1024 * 5;
		BoardVO board = new BoardVO();
		BoardDAO bDao = new BoardDAO();
		FilesDAO fDao = new FilesDAO();
		ActionForward forward = new ActionForward();
		
		MultipartRequest multi;
		multi = new MultipartRequest(req, saveFolder, fileSize, "UTF-8", new DefaultFileRenamePolicy());
		int boardNum = Integer.parseInt(multi.getParameter("boardNum"));
		
		// folder에서 삭제
		for(FilesVO file : fDao.getFiles(boardNum)) {
			File f = new File(saveFolder, file.getFileName());
			
			if(f.exists()) {
				f.delete();
			}
		}
		
		// DB에서 삭제 후 다시 삽입.
		fDao.deleteFiles(boardNum);
		fDao.insertFiles(multi, boardNum);
		
		// 게시글 정보 수정
		board.setBoardNum(boardNum);
		board.setBoardTitle(multi.getParameter("boardTitle"));
		board.setBoardContent(multi.getParameter("boardContent"));
		bDao.updateBoard(board);
		
		forward.setRedirect(false);
		forward.setPath("/board/BoardViewOk.bo?boardNum=" + boardNum);
		
		return forward;
	}
}
