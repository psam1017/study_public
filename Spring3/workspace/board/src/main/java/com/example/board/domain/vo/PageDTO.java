package com.example.board.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PageDTO {
	
	private int startPage;
	private int endPage;
	private int realEndPage;
	private boolean prev, next;
	
	// 연관관계
	private int total;
	private Criteria criteria;
	
	public PageDTO(int total, Criteria criteria) {
		this.total = total;
		this.criteria = criteria;
		
		this.endPage = (int)(Math.ceil(criteria.getPageNum()/(double)criteria.getAmount()) * criteria.getAmount());
		this.startPage = endPage - (criteria.getAmount() - 1);
		this.realEndPage = (int)Math.ceil(1.0 * total / criteria.getAmount());
		
		if(this.realEndPage < this.endPage) {
			this.endPage = this.realEndPage;
		}
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < this.realEndPage;
	}
}
