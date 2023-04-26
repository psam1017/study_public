package com.example.board.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.board.domain.vo.BoardDTO;
import com.example.board.domain.vo.BoardVO;
import com.example.board.domain.vo.Criteria;
import com.example.board.domain.vo.FileDTO;

@Mapper
public interface BoardMapper {
	
	public List<BoardVO> getList(Criteria criteria);
	public void insert(BoardDTO boardVO);
	public BoardVO read(Long bno);
	public int delete(Long bno);
	public int update(BoardVO boardVO);
	public int getTotal(Criteria criteria);
	public List<FileDTO> getFiles(Long bno);
}
