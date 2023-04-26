package com.example.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.board.domain.dao.BoardDAO;
import com.example.board.domain.dao.FileDAO;
import com.example.board.domain.vo.BoardDTO;
import com.example.board.domain.vo.BoardVO;
import com.example.board.domain.vo.Criteria;
import com.example.board.domain.vo.FileDTO;

@Service
public class BoardServiceImpl implements BoardService {
	
	// 굳이 Interface를 사용하는 이유?
	// 1. Interface로 생성했다는 것은 재사용하겠다는 의미이다.
	// class로 생성한 Service는 최종적으로 사용하는 객체라는 뜻이며, 재사용되지 않는다.
	// 만약 최적화를 해야 한다면, 그때 Interface를 삭제하면 된다.
	// 2. 클래스 간의 관계를 조금 더 느슨하게 만드는 것이다.
	
	@Autowired
	private BoardDAO boardDAO;
	
	@Autowired
	private FileDAO fileDAO;
	
	@Override
	public void register(BoardDTO board) {
		boardDAO.register(board);
		for(FileDTO file : board.getFiles()) {
			FileDTO fileDTO = new FileDTO();
			fileDTO.setUuid(file.getUuid());
			fileDTO.setUploadPath(file.getUploadPath());
			fileDTO.setFileName(file.getFileName());
			fileDTO.setFileType(file.isFileType());
			fileDTO.setBno(board.getBno());
			fileDAO.register(fileDTO);
		}
	}

	@Override
	public BoardVO get(Long bno) {
		return boardDAO.get(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		return boardDAO.modify(board);
	}

	@Override
	public boolean remove(Long bno) {
		return boardDAO.remove(bno);
	}

	@Override
	public List<BoardVO> getList(Criteria criteria) {
		return boardDAO.getList(criteria);
	}
	
	@Override
	public int getTotal(Criteria criteria) {
		return boardDAO.getTotal(criteria);
	}

	@Override
	public List<FileDTO> getFiles(Long bno) {
		return boardDAO.getFiles(bno);
	}
}
