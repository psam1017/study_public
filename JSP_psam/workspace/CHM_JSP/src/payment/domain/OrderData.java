package payment.domain;

//num			INT(11)			NOT NULL	AUTO_INCREMENT	PRIMARY KEY,
//orderNo		VARCHAR(50),
//cartId		INT(11),
//bookId		VARCHAR(50),
//bookName	VARCHAR(50),
//unitPrice	INT(11)			NOT NULL	DEFAULT 0,
//cnt			TINYINT(4)		NOT NULL	DEFAULT 0,
//sumPrice	INT(11)			NOT NULL	DEFAULT 0,
//INDEX		`orderNo`(`orderNo`)

public class OrderData {

	private int num;
	private String orderNo;
	private int cartId;
	private String bookId;
	private String bookName;
	private int unitPrice;
	private int cnt;
	private int sumPrice;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getSumPrice() {
		return sumPrice;
	}
	public void setSumPrice(int sumPrice) {
		this.sumPrice = sumPrice;
	}
}
