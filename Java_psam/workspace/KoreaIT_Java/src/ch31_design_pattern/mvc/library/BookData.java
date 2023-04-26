package ch31_design_pattern.mvc.library;

public class BookData {

	private String code;
	private String title;
	private String author;
	private int stockOrigin;
	private int stockCurrent;
	
	public BookData() { ; }

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getStockOrigin() {
		return stockOrigin;
	}

	public void setStockOrigin(int stockOrigin) {
		this.stockOrigin = stockOrigin;
	}

	public int getStockCurrent() {
		return stockCurrent;
	}

	public void setStockCurrent(int stockCurrent) {
		this.stockCurrent = stockCurrent;
	}

	@Override
	public String toString() {
		System.out.println("==============================");
		System.out.println("코드 : " + getCode());
		System.out.println("제목 : " + getTitle());
		System.out.println("저자 : " + getAuthor());
		System.out.println("원 재고 : " + getStockOrigin());
		System.out.println("현재 재고 : " + getStockCurrent());
		return null;
	}
}
