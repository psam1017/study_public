package vo;

//aid		INT UNSIGNED	NOT NULL	AUTO_INCREMENT	PRIMARY KEY,
//title	VARCHAR(255)	NOT NULL,
//img		VARCHAR(255)	NOT NULL,
//date	DATETIME		NOT NULL	DEFAULT CURRENT_TIMESTAMP(),	
//content	VARCHAR(2000)	NOT NULL

public class NewsVO {
	
	private int aid;
	private String title;
	private String img;
	private String date;
	private String content;
	
	public NewsVO() { ; }
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
