package com.psm.app.board.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.psm.app.action.Action;
import com.psm.app.action.ActionForward;
import com.psm.app.board.dao.BoardReplyDAO;
import com.psm.app.board.vo.BoardReplyVO;

public class BoardReplListOk implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		BoardReplyDAO rDao = new BoardReplyDAO();
		int boardNum = Integer.parseInt(req.getParameter("boardNum"));
		List<BoardReplyVO> replyList = rDao.getReplyList(boardNum);
		PrintWriter out = resp.getWriter();
		
		JSONArray replies = new JSONArray();
		
		for(BoardReplyVO reply : replyList) {
			JSONObject obj = new JSONObject();
			obj.put("replyNum", reply.getReplyNum());
			obj.put("memberId", reply.getMemberId());
			obj.put("replyContent", reply.getReplyContent());
			replies.add(obj);
		}
		
		out.println(replies.toJSONString());
		out.close();
		
		return null;
	}

}
