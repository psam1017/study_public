package ch08_abstract_interface_innerclass.test;

public class ShopProduct{
	
	Product p1 = new Product(1, "블렌딩 커피", 5000);
	Product p2 = new Product(2, "파나마 게이샤", 15000);
	Product p3 = new Product(3, "에티오피아", 10000);
	Product[] pArray = {p1, p2, p3};
	
	public void printProduct() {
		for(Product p : pArray) {
		System.out.println(p.toString());
		}
	}
}
