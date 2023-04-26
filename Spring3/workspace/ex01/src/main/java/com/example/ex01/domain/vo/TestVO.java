package com.example.ex01.domain.vo;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

@Data
public class TestVO {
	
	@Autowired
	private String id;
	private String name;
}
