package com.example.board.service;

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
public class BoardServiceTests {
	
	@Autowired
	private BoardService boardService;
	
//	@Test
	public void serviceTest() {
		log.info("boardService를 bean으로 등록하지 않았지만, 구현 객체인 boardServiceImpl을 bean으로 등록한 상태");
		log.info("하지만 둘 다 boardService 타입이므로 boardService도 의존성 주입이 가능함.");
		log.info(boardService.toString());
	}
	
//	@Test
	public void registerTest() {
		BoardDTO board = new BoardDTO();
		board.setTitle("테스트 제목");
		board.setContent("테스트 작성글 내용");
		board.setWriter("psm1234");
		
		boardService.register(board);
		log.info("생성된 게시글 번호 : " + board.getBno());
	}
	
	// 아래와 같은 경고 발생. 경고 내용에 따라 출시 시점에는 적절한 조치가 필요할 수 있음.
	// WARNING: An illegal reflective access operation has occurred
	// WARNING: All illegal access operations will be denied in a future release
//	@Test
	public void getTest() {
		BoardVO boardVO = boardService.get(284L);
		if(boardVO != null) {
			log.info(boardVO);
		}
		else {
			log.info("해당 게시글이 존재하지 않습니다.");
		}
	}
	
//	@Test
	public void modifyTest() {
		BoardVO boardVO = boardService.get(284L);
		
		if(boardVO == null) {
			log.info("해당 게시글이 없습니다.");
			return;
		}
		boardVO.setContent("Service 테스트로 변경된 내용");
		
		if(boardService.modify(boardVO)) {
			log.info("게시글이 수정되었습니다.");
		}
		else {
			log.info("게시글 수정을 실패했습니다.");
		}
	}
	
//	@Test
	public void removeTest() {
		BoardVO boardVO = boardService.get(286L);
		
		if(boardVO == null) {
			log.info("해당 게시글이 없습니다.");
			return;
		}
		
		if(boardService.remove(boardVO.getBno())) {
			log.info("게시글이 삭제되었습니다.");
		}
		else {
			log.info("게시글 삭제를 실패했습니다.");
		}
	}
	
//	@Test
	public void getListTest() {
		boardService.getList(new Criteria()).forEach(log::info);
	}
}
