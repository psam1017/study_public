package com.example.board.mappers;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TimeMapper {

	public String getTime();
}
