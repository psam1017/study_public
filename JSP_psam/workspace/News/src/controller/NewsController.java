package controller;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.servlet.jsp.PageContext;

import org.apache.commons.beanutils.BeanUtils;

import dao.NewsDAO;
import vo.NewsVO;

@WebServlet("*.nhn")
@MultipartConfig(maxFileSize = 1024 * 1024 * 2, location = "C:/Users/HP/Desktop/Coding/JSP_psam/workspace/News/WebContent/app/upload")
public class NewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private NewsDAO dao;
	private ServletContext ctx;
  private final String START_PAGE = "/app/ver01/newsList.jsp";
  
  public void init(ServletConfig config) throws ServletException{
  	super.init(config);
  	dao = new NewsDAO();
  	ctx = getServletContext();
  }
  
  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
  	
  	req.setCharacterEncoding("UTF-8");
  	String action = req.getParameter("action");
  	
  	dao = new NewsDAO();
  	
  	Method method;
  	String view = null;
  	
  	if(action == null) {
  		action = "listNews";
  	}
  	
  	try {
  		method = this.getClass().getMethod(action, HttpServletRequest.class);
  		view = (String)method.invoke(this, req);
  	} catch(NoSuchMethodException e) {
  		e.printStackTrace();
  		ctx.log("요청 action이 없음.");
  		req.setAttribute("error", "action 파라미터가 잘못되었습니다.");
  		view = START_PAGE;
  	} catch (Exception e) {
			e.printStackTrace();
  	}
  	
  	if(view.startsWith("redirect:/")) {
  		String redirect = view.substring("redirect:/".length());
  		resp.sendRedirect(redirect);
  	}
  	else {
  		RequestDispatcher dispatcher = req.getRequestDispatcher(view);
  		dispatcher.forward(req, resp);
  	}
  }
  
  private String getFilename(Part part) {
  	String fileName = null;
  	String header = part.getHeader("content-disposition");
  	ctx.log("File Header : " + header);
  	
  	int start = header.indexOf("filename=");
  	fileName = header.substring(start + 10, header.length() - 1);
  	ctx.log("파일명 : " + fileName);
  	return fileName;
  }
  
  public String addNews(HttpServletRequest req) {
  	NewsVO vo = new NewsVO();
  	
  	try {
  		Part part = req.getPart("file");
  		String fileName = getFilename(part);
  		if(fileName != null && !fileName.isEmpty()) {
  			part.write(fileName);
  		}
  		BeanUtils.populate(vo, req.getParameterMap());
  		vo.setImg(req.getContextPath() + "/app/upload/" + fileName);
  		dao.addNews(vo);
  	} catch(Exception e) {
  		e.printStackTrace();
  		ctx.log("뉴스 추가 오류");
  		req.setAttribute("error", "뉴스가 정상적으로 등록되지 않았습니다.");
  		return listNews(req);
  	}
  	return "redirect:/news.nhn?action=listNews";
  }
  
  public String listNews(HttpServletRequest req) {
  	List<NewsVO> list;
  	
  	try {
  		list = dao.getList();
  		req.setAttribute("newslist", list);
  	}
  	catch(Exception e) {
  		e.printStackTrace();
  		req.setAttribute("error", "뉴스 목록 출력 오류");
  	}
  	return "./newsList.jsp";
  }
  
  public String getNews(HttpServletRequest req) {
  	int aid = Integer.parseInt(req.getParameter("aid"));
  	
  	try {
  		NewsVO vo = dao.getNews(aid);
  		req.setAttribute("news", vo);
  	} catch(Exception e) {
  		e.printStackTrace();
  		req.setAttribute("error", "뉴스 상세보기 오류");
  	}
  	
  	return "./newsView.jsp";
  }
  
  public String deleteNews(HttpServletRequest req) {
  	int aid = Integer.parseInt(req.getParameter("aid"));
  	try {
  		dao.deleteNews(aid);
  	} catch(Exception e) {
  		e.printStackTrace();
  		req.setAttribute("error", "뉴스 삭제 실패");
  	}
  	
  	return "redirect:/news.nhn?action=listNews";
  }
}
