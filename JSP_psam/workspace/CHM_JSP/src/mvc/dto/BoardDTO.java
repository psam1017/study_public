package mvc.dto;

//num				INT				NOT NULL	AUTO_INCREMENT	PRIMARY KEY,
//id				VARCHAR(10)	NOT NULL,
//name			VARCHAR(10)	NOT NULL,
//subject		VARCHAR(100)	NOT NULL,
//content			TEXT			NOT NULL,
//register_day	VARCHAR(30)	NOT NULL,
//hit				INT				NULL,
//ip				VARCHAR(48)	NULL

public class BoardDTO {
	
	private int num;
	private String id;
	private String name;
	private String subject;
	private String content;
	private String registerDay;
	private int hit;
	private String ip;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegisterDay() {
		return registerDay;
	}
	public void setRegisterDay(String registerDay) {
		this.registerDay = registerDay;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
