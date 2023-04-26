package mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.service.BoardService;

@WebServlet("/CHMBoardController")
public class CHMBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int LIST_COUNT = 5;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		BoardService service = new BoardService();
		String path = null;
		
		if(command.contains("/BoardListAction.do")) {
			try {
				service.requestBoardList(req, resp, LIST_COUNT);
				path = "../board/list.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.contains("/BoardWriteForm.do")) {
			try {
				service.requestLoginName(req);
				path = "../board/writeForm.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.contains("/BoardWriteAction.do")) {
			try {
				service.requestBoardWrite(req);
				path = "../board/BoardListAction.do";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.contains("/BoardViewAction.do")) {
			try {
				service.requestBoardView(req);
				path = "../board/BoardView.do";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.contains("/BoardView.do")) {
			try {
				path = "../board/view.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.contains("/BoardUpdateAction.do")) {
			try {
				service.requestBoardUpdate(req);
				path = "../board/BoardListAction.do";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.contains("/BoardDeleteAction.do")) {
			try {
				service.requestBoardDelete(req);
				path = "../board/BoardListAction.do";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		RequestDispatcher rd = req.getRequestDispatcher(path);
		rd.forward(req, resp);
	}
}
