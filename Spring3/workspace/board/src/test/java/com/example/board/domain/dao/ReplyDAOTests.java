package com.example.board.domain.dao;

import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.board.domain.vo.Criteria;
import com.example.board.domain.vo.ReplyVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyDAOTests {
	
	private Long[] arBno = {1397L, 1396L, 1395L};
	
	@Autowired
	private ReplyDAO replyDAO;
	
	@Test
	public void daoTest() {
		log.info(replyDAO);
	}
	
//	@Test
	public void registerTest() {
		IntStream.range(1, 6).forEach(i -> {
			ReplyVO replyVO = new ReplyVO();
			replyVO.setBno(arBno[i % 3]);
			replyVO.setReply("dao 테스트 " + i);
			replyVO.setReplier("dao 작성자 " + i);
			
			replyDAO.register(replyVO);
		});
	}
	
//	@Test
	public void findByRNOTest() {
		log.info(replyDAO.findByRNO(30L));
	}

	// 개별 댓글 삭제
//	@Test
	public void removeTest() {
		log.info(replyDAO.findByRNO(35L));
		log.info(replyDAO.remove(35L));
	}
	
	// 게시글 아래의 댓글 모두 삭제
//	@Test
	public void deleteAllTest() {
		log.info("삭제? : " + replyDAO.removeAllByBNO(1399L));
	}
	
//	@Test
	public void modifyTest() {
		ReplyVO replyVO = replyDAO.findByRNO(27L);
		if(replyVO != null) {
			replyVO.setReply("dao 수정 테스트");
		}
		log.info(replyVO == null ? "없는 댓글입니다." : replyDAO.modify(replyVO));
		log.info(replyVO);
	}
	
//	@Test
	public void findtAlByBNOlTest() {
		replyDAO.findAllByBNO(1398L, new Criteria()).forEach(log::info);
	}
}
