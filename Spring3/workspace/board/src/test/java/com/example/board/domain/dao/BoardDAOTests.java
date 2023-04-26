package com.example.board.domain.dao;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.board.domain.vo.BoardDTO;
import com.example.board.domain.vo.BoardVO;
import com.example.board.domain.vo.Criteria;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardDAOTests {
	
	@Autowired
	BoardDAO boardDAO;
	
	@Test
	public void daoTest() {
		log.info(boardDAO);
	}
	
//	@Before
	public void registerTest() {
		BoardDTO board = new BoardDTO();
		board.setTitle("테스트 제목");
		board.setContent("테스트 작성글 내용");
		board.setWriter("psm1234");
		
		boardDAO.register(board);
		log.info("생성된 게시글 번호 : " + board.getBno());
	}
	
//	@Test
	public void getTest() {
		BoardVO boardVO = boardDAO.get(284L);
		if(boardVO != null) {
			log.info(boardVO);
		}
		else {
			log.info("해당 게시글이 존재하지 않습니다.");
		}
	}
	
//	@Test
	public void modifyTest() {
		BoardVO boardVO = boardDAO.get(284L);
		
		if(boardVO == null) {
			log.info("해당 게시글이 없습니다.");
			return;
		}
		boardVO.setContent("Service 테스트로 변경된 내용");
		
		if(boardDAO.modify(boardVO)) {
			log.info("게시글이 수정되었습니다.");
		}
		else {
			log.info("게시글 수정을 실패했습니다.");
		}
	}
	
//	@Test
	public void removeTest() {
		BoardVO boardVO = boardDAO.get(286L);
		
		if(boardVO == null) {
			log.info("해당 게시글이 없습니다.");
			return;
		}
		
		if(boardDAO.remove(boardVO.getBno())) {
			log.info("게시글이 삭제되었습니다.");
		}
		else {
			log.info("게시글 삭제를 실패했습니다.");
		}
	}
	
	@After
	public void getListTest() {
		boardDAO.getList(new Criteria()).forEach(log::info);
	}
}
