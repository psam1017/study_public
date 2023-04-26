package service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import dao.NewsDAO;
import vo.NewsVO;

@Path("/news")
public class NewsAPIService {
	
	NewsDAO dao;
	
	public NewsAPIService() {
		dao = new NewsDAO();
	}
	
	// Postman test 시 Body에 raw, json 설정 후 json 양식으로 값을 입력해야 한다.
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String addNews(NewsVO news) {
		try {
			dao.addNews(news);
		} catch (Exception e) {
			return "등록 실패";
		}
		return "등록 성공";
	}
	
	// /api/news/8 -> path에 aid가 추가된다는 뜻. param에는 path 말고도 query, bean, cookie, form 등이 있다.
	@GET
	@Path("{aid}")
	@Produces(MediaType.APPLICATION_JSON)
	public NewsVO readNews(@PathParam("aid") int aid) {
		NewsVO news = null;
		
		try {
			news = dao.getNews(aid);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return news;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<NewsVO> viewList(){
		List<NewsVO> list = new ArrayList<NewsVO>();
		
		try {
			list = dao.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	@DELETE
	@Path("{aid}")
	@Consumes(MediaType.APPLICATION_JSON)
	public String removeNews(@PathParam("aid") int aid) {
		try {
			dao.deleteNews(aid);
		} catch (Exception e) {
			return "삭제 실패";
		}
		return "삭제 성공";
	}
}
