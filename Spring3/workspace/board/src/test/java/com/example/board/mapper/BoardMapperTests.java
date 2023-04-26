package com.example.board.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.board.domain.vo.BoardDTO;
import com.example.board.domain.vo.BoardVO;
import com.example.board.domain.vo.Criteria;
import com.example.board.mappers.BoardMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	@Autowired
	private BoardMapper boardMapper;
	
	// 기존 JSP에서는 sqlSession.selectList 메소드를 사용해야 했다.
	// Spring에서는 selectList, selectOne 구분 없이 사용 가능한 것으로 보인다.

	@Test
	public void getListTest() {
		boardMapper.getList(new Criteria()).forEach(log::info);
	}
	
//	@Test
	public void insertTest() {
		BoardDTO board = new BoardDTO();
		board.setTitle("new title5");
		board.setContent("new content5");
		board.setWriter("user04");
		
		boardMapper.insert(board);
		
		// n번째로 등록된 게시글임을 알려주는 기능
		log.info(board);
	}
	
//	@Test
	public void readTest() {
		long bno = 285;
		boardMapper.read(bno);
	}
	
//	@Test
	public void deleteTest() {
		long bno = 285;
		if(boardMapper.read(bno) != null) {
			log.info("삭제된 건 수 : " + boardMapper.delete(bno));
		}
		else {
			log.info("이미 삭제된 게시글입니다.");
		}
	}
	
//	@Test
	public void updateTest() {
		BoardVO boardVO = boardMapper.read(284L);
		if(boardVO != null) {
			boardVO.setTitle("수정된 제목");
			boardVO.setTitle("수정된 내용");
			log.info("수정된 건 수 : " + boardMapper.update(boardVO));
		}
		else {
			log.info("해당 게시글은 존재하지 않습니다.");
		}
	}
}
