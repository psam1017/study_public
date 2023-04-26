package com.psm.app.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.psm.app.action.Action;
import com.psm.app.action.ActionForward;
import com.psm.app.board.dao.BoardDAO;
import com.psm.app.board.vo.BoardVO;
import com.psm.app.files.dao.FilesDAO;

public class BoardWriteOk implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// request를 MultipartRequest에 담아서 전달할 것이기 때문에 req, resp는 인코딩을 할 필요가 없다.
		// req.setCharacterEncoding("UTF-8");
		// resp.setCharacterEncoding("UTF-8");
		
		// upload의 경로
		String saveFolder = "C:\\Users\\HP\\Desktop\\Coding\\JSP_psam\\workspace\\board_mvc\\WebContent\\app\\upload";

		// byte 단위의 크기 : 5Mb
		int fileSize = 1024 * 1024 * 5;
		
		BoardDAO bDao = new BoardDAO();
		FilesDAO fDao = new FilesDAO();
		BoardVO vo = new BoardVO();
		ActionForward forward = new ActionForward();
		
		// 게시글 내용을 전달 받기 위해 MultipartRequest라는 객체를 선언. cos.jar가 필요함.
		// multi = new MultipartRequest(req, 경로, 파일크기, 인코딩방식, 정책 -> 사용자들의 파일명을 서버가 바꿔서 저장할 수 있도록)
		// 앞으로 게시글 내용은 HttpServletRequest에서 파라미터를 받지 말고 MultipartRequest에서 받아야 한다.
		MultipartRequest multi = null;
		
		// 이 객체를 생성하는 순간 req를 통해 사진이 바로 svaFolder에 업로드된다.
		multi = new MultipartRequest(req, saveFolder, fileSize, "UTF-8", new DefaultFileRenamePolicy());
		
		vo.setBoardTitle(multi.getParameter("boardTitle"));
		vo.setBoardContent(multi.getParameter("boardContent"));
		vo.setBoardId(multi.getParameter("boardId"));
		
		// seqeunce는 NEXTVAL이 CURRVAL보다 먼저 SELECT되어야 한다.
		// 즉, 아래의 실행 순서를 유지하고 있어야 한다.
		// 단, file에만 오류가 발생한다면, 게시글은 올라갔는데, 파일은 올라가지 않을 수 있다.
		// file에 오류가 생긴다면 article도 작성을 취소(삭제)시키는 방법도 괜찮겠다. -> FilesDAO에서 deleteBoard를 실행하도록
		bDao.insertBoard(vo);
		fDao.insertFiles(multi, bDao.getSeq());
		
		forward.setRedirect(true);
		forward.setPath(req.getContextPath() + "/board/BoardListOk.bo");
		
		return forward;
	}
}
