package com.psm.app.board.vo;

//boardNum NUMBER(38),
//boardTitle VARCHAR2(1000),
//boardContent VARCHAR2(2000),
//boardId VARCHAR2(1000),
//boardDate DATE,
//readCount Number(38),

public class BoardVO {
	private int boardNum;
	private String boardTitle;
	private String boardContent;
	private String boardId;
	private String boardDate;
	private int readCount;
	
	public BoardVO() {}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getBoardId() {
		return boardId;
	}

	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}

	public String getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
}
