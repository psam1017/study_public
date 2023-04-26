package com.example.board.domain.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.board.domain.vo.BoardDTO;
import com.example.board.domain.vo.BoardVO;
import com.example.board.domain.vo.Criteria;
import com.example.board.domain.vo.FileDTO;

@Repository
public interface BoardDAO {
	
	public void register(BoardDTO board);
	public BoardVO get(Long bno);
	public boolean modify(BoardVO board);
	public boolean remove(Long bno);
	public List<BoardVO> getList(Criteria criteria);
	public int getTotal(Criteria criteria);
	public List<FileDTO> getFiles(Long bno);
}
