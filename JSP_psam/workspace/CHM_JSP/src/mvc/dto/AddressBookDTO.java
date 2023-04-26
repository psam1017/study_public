package mvc.dto;

//id		INT(11)			NOT NULL	PRIMARY KEY	AUTO_INCREMENT,
//name	VARCHAR(100)	NOT NULL,
//email 	VARCHAR(100)	NULL,
//comdept	VARCHAR(100)	NOT NULL,
//birth	VARCHAR(100)	NOT NULL,
//tel		VARCHAR(100)	NULL,
//memo	VARCHAR(100)	NULL

public class AddressBookDTO {
	
	private int id;
	private String name;
	private String email;
	private String comdept;
	private String birth;
	private String tel;
	private String memo;
	
	public AddressBookDTO() {;}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getComdept() {
		return comdept;
	}
	public void setComdept(String comdept) {
		this.comdept = comdept;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	
}
