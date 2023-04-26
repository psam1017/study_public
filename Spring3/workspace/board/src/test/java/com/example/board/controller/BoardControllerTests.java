package com.example.board.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration // WAS가 해당 파일을 참조하게 함.
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@Log4j
public class BoardControllerTests {
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
//	@Test
	public void listTest() throws Exception{
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/list")
				.param("pageNum", "1")
				.param("amount", "10")
				.param("type", "TC")
				.param("keyword", "데레")
				).andReturn().getModelAndView().getModelMap());
	}
	
//	@Test
	public void registerTest() throws Exception{
		log.info(mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
				.param("title", "컨트롤러 테스트 새 글 제목")
				.param("content", "컨트롤러 테스트 새 글 내용")
				.param("writer", "hds2000")
				).andReturn().getFlashMap());
	}
	
//	@Test
	public void readTest() throws Exception{
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/read")
				.param("bno", "284") // 이때는 문자열로 써야 하고, 가능하면 자료형이 아니라 클래스로 사용해주는 게 좋다.
				// ).andReturn().getModelAndView().getViewName()); // View 경로를 반환
				).andReturn().getModelAndView().getModelMap());
	}
	
//	@Test
	public void removeTest() throws Exception{
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/remove")
				.param("bno", "287")
				).andReturn().getFlashMap());
	}
	
//	@Test
	public void modifyTest() throws Exception{
		log.info(mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
				.param("bno", "290")
				.param("title", "컨트롤러 수정 제목")
				.param("content", "컨트롤러 수정 내용")
				).andReturn().getFlashMap());
	}
	
//	@Test
	public void goModifyTest() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/board/modify").param("bno", "284"));
	}
}
