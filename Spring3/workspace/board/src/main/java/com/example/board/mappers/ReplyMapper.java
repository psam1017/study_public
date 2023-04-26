package com.example.board.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.board.domain.vo.Criteria;
import com.example.board.domain.vo.ReplyVO;

@Mapper
public interface ReplyMapper {
	
	public int insert(ReplyVO replyVO);
	public ReplyVO select(Long rno);
	public int delete(Long rno);
	public int deleteAll(Long bno);
	public int update(ReplyVO replyVO);
	public List<ReplyVO> selectAll(@Param("bno") Long bno, @Param("criteria") Criteria criteria);
	public int getTotal(Long bno);
}
