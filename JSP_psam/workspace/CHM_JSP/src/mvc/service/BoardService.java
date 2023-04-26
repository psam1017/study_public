package mvc.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.dao.BoardDAO;
import mvc.dto.BoardDTO;

public class BoardService {
	
	BoardDAO dao = BoardDAO.getInstance();
	
	public void requestBoardList(HttpServletRequest req, HttpServletResponse resp, int listCount) throws Exception {
		
		List<BoardDTO> boardList = new ArrayList<BoardDTO>();
		
		int pageNum = 1;
		int limit = listCount;
		
		if(req.getParameter("pageNum") != null) {
			pageNum = Integer.parseInt(req.getParameter("pageNum"));
		}
		
		String items = req.getParameter("items"); // 검색 필드
		String text = req.getParameter("text"); // 검색어
		
		int totalRecord = dao.getListCount(items, text); // 전체 게시물 개수
		boardList = dao.getBoardList(pageNum, limit, items, text); // 현재 페이지의 목록
		
		int totalPage;
		
		totalPage = totalRecord / limit;
		Math.floor(totalPage);
		if(totalRecord % limit != 0) {
			totalPage++;
		}
		
		req.setAttribute("pageNum", pageNum);
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("totalRecord", totalRecord);
		req.setAttribute("boardList", boardList);
	}
	
	public void requestLoginName(HttpServletRequest req) throws Exception {
		
		String id = req.getParameter("id");
		String name = dao.getLoginNameById(id);
		req.setAttribute("name", name);
	}
	
	public void requestBoardWrite(HttpServletRequest req) throws Exception {
		
		BoardDTO dto = new BoardDTO();
		dto.setId(req.getParameter("id"));
		dto.setName(req.getParameter("name"));
		dto.setSubject(req.getParameter("subject"));
		dto.setContent(req.getParameter("content"));
		dto.setIp(req.getRemoteAddr());
		
		dao.insertBoard(dto);
	}
	
	public void requestBoardView(HttpServletRequest req) throws Exception {
		
		int num = Integer.parseInt(req.getParameter("num"));
		int pageNum = Integer.parseInt(req.getParameter("pageNum"));
		
		BoardDTO dto = new BoardDTO();
		dto = dao.getBoardByNum(num);
		
		req.setAttribute("num", num);
		req.setAttribute("pageNum", pageNum);
		req.setAttribute("board", dto);
	}
	
	public void requestBoardUpdate(HttpServletRequest req) throws Exception{
		
		BoardDTO dto = new BoardDTO();
		dto.setName(req.getParameter("name"));
		dto.setSubject(req.getParameter("subject"));
		dto.setContent(req.getParameter("content"));
		dto.setIp(req.getRemoteAddr());
		dto.setNum(Integer.parseInt(req.getParameter("num")));
		
		dao.updateBoard(dto);
	}
	
	public void requestBoardDelete(HttpServletRequest req) throws Exception{
		
		int num = Integer.parseInt(req.getParameter("num"));
		int pageNum = Integer.parseInt(req.getParameter("pageNum"));
		dao.deleteBoard(num);
		
		req.setAttribute("pageNum", pageNum);
	}
}
