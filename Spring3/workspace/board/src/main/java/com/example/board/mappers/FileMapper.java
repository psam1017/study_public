package com.example.board.mappers;

import org.apache.ibatis.annotations.Mapper;

import com.example.board.domain.vo.FileDTO;

@Mapper
public interface FileMapper {
	
	// 첨부파일 추가
	public void insert(FileDTO file);
}
