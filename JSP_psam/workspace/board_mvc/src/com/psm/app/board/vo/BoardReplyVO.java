package com.psm.app.board.vo;

//replyNum NUMBER(38),
//boardNum NUMBER(38),
//memberId VARCHAR2(1000),
//replyContent VARCHAR2(2000),

public class BoardReplyVO {
	
	private int replyNum;
	private int boardNum;
	private String memberId;
	private String replyContent;

	public BoardReplyVO() {}

	public int getReplyNum() {
		return replyNum;
	}
	public void setReplyNum(int replyNum) {
		this.replyNum = replyNum;
	}
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
}
