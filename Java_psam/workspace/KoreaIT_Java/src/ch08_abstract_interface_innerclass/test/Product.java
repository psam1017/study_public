package ch08_abstract_interface_innerclass.test;

public class Product {
	private final int productID;
	private final String productName;
	private final int price;
	
	public Product(int productID, String productName, int price) {
		this.productID = productID;
		this.productName = productName;
		this.price = price;
	}
	public int getProductID() {
		return productID;
	}
	public String getProductName() {
		return productName;
	}
	public int getPrice() {
		return price;
	}
	
	@Override
	public String toString() {
		return "productID=" + productID + ", productName=" + productName + ", price=" + price;
	}
}
