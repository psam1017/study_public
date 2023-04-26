package com.example.board.mapper;

import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.board.domain.vo.Criteria;
import com.example.board.domain.vo.ReplyVO;
import com.example.board.mappers.ReplyMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {
	
	private Long[] arBno = {1400L, 1399L, 1398L};
	
	@Autowired
	ReplyMapper replyMapper;
	
	@Test
	public void mapperTest() {
		log.info(replyMapper);
	}
	
//	@Test
	public void insertTest() {
		IntStream.range(1, 6).forEach(i -> {
			ReplyVO replyVO = new ReplyVO();
			replyVO.setBno(arBno[i % 3]);
			replyVO.setReply("댓글 테스트 " + i);
			replyVO.setReplier("댓글 작성자 " + i);
			
			replyMapper.insert(replyVO);
		});
	}
	
//	@Test
	public void selectTest() {
		log.info(replyMapper.select(23L));
	}

	// 개별 댓글 삭제
//	@Test
	public void deleteTest() {
		log.info(replyMapper.delete(23L) == 1);
	}
	
	// 게시글 아래의 댓글 모두 삭제
//	@Test
	public void deleteAllTest() {
		log.info("삭제된 수 : " + replyMapper.deleteAll(1399L));
	}
	
//	@Test
	public void updateTest() {
		ReplyVO replyVO = replyMapper.select(51L);
		if(replyVO != null) {
			replyVO.setReply("mapper 수정 테스트");
		}
		log.info(replyVO == null ? "없는 댓글입니다." : replyMapper.update(replyVO));
		log.info(replyVO);
	}
	
//	@Test
	public void selectAllTest() {
		replyMapper.selectAll(1400L, new Criteria()).forEach(log::info);
	}
}
