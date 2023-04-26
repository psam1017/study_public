package com.example.board.domain.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.board.domain.vo.Criteria;
import com.example.board.domain.vo.ReplyVO;
import com.example.board.mappers.ReplyMapper;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ReplyDAO {
	
	private final ReplyMapper replyMapper;
	
	public boolean register(ReplyVO replyVO) {
		return replyMapper.insert(replyVO) == 1;
	};

	public ReplyVO findByRNO(Long rno) {
		return replyMapper.select(rno);
	};

	public boolean remove(Long rno) {
		return replyMapper.delete(rno) == 1;
	};

	public boolean removeAllByBNO(Long bno) {
		return replyMapper.deleteAll(bno) != 0;
	};

	public boolean modify(ReplyVO replyVO) {
		return replyMapper.update(replyVO) == 1;
	};
	
	public List<ReplyVO> findAllByBNO(Long bno, Criteria criteria){
		return replyMapper.selectAll(bno, criteria);
	};
	
	public int getTotal(Long bno) {
		return replyMapper.getTotal(bno);
	}
}
