package com.example.board.service;

import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.board.domain.vo.Criteria;
import com.example.board.domain.vo.ReplyVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyServiceTests {
	
	private Long[] arBno = {1397L, 1396L, 1395L};
	
	@Autowired
	private ReplyService replyService;
	
	@Test
	public void daoTest() {
		log.info(replyService);
	}
	
//	@Test
	public void registerTest() {
		IntStream.range(1, 6).forEach(i -> {
			ReplyVO replyVO = new ReplyVO();
			replyVO.setBno(arBno[i % 3]);
			replyVO.setReply("service 테스트 " + i);
			replyVO.setReplier("service 작성자 " + i);
			
			replyService.register(replyVO);
		});
	}
	
//	@Test
	public void findByRNOTest() {
		log.info(replyService.findByRNO(30L));
	}

	// 개별 댓글 삭제
//	@Test
	public void removeTest() {
		log.info(replyService.findByRNO(37L));
		log.info(replyService.remove(37L));
	}
	
	// 게시글 아래의 댓글 모두 삭제
//	@Test
	public void deleteAllTest() {
		log.info("삭제? : " + replyService.removeAllByBNO(1397L));
	}
	
//	@Test
	public void modifyTest() {
		ReplyVO replyVO = replyService.findByRNO(40L);
		if(replyVO != null) {
			replyVO.setReply("service 수정 테스트");
		}
		log.info(replyVO == null ? "없는 댓글입니다." : replyService.modify(replyVO));
		log.info(replyVO);
	}
	
//	@Test
	public void findtAlByBNOlTest() {
		replyService.findAllByBNO(1398L, new Criteria()).forEach(log::info);
	}
}
