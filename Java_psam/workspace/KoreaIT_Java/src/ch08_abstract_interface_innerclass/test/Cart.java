package ch08_abstract_interface_innerclass.test;

public class Cart {
	int productID, cnt;

	public Cart(int productID, int cnt) {
		this.productID = productID;
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		return "상품번호 : " + productID + ", 개수 : " + cnt;
	}
	
}
