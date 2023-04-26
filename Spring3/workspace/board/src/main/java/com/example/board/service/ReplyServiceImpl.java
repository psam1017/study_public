package com.example.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.board.domain.dao.ReplyDAO;
import com.example.board.domain.vo.Criteria;
import com.example.board.domain.vo.ReplyVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyDAO replyDAO;
	
	@Override
	public boolean register(ReplyVO replyVO) {
		return replyDAO.register(replyVO);
	}

	@Override
	public ReplyVO findByRNO(Long rno) {
		return replyDAO.findByRNO(rno);
	}

	@Override
	public boolean remove(Long rno) {
		return replyDAO.remove(rno);
	}

	@Override
	public boolean removeAllByBNO(Long bno) {
		return replyDAO.removeAllByBNO(bno);
	}

	@Override
	public boolean modify(ReplyVO replyVO) {
		return replyDAO.modify(replyVO);
	}

	@Override
	public List<ReplyVO> findAllByBNO(Long bno, Criteria criteria) {
		return replyDAO.findAllByBNO(bno, criteria);
	}

	@Override
	public int getTotal(Long bno) {
		return replyDAO.getTotal(bno);
	}
}
