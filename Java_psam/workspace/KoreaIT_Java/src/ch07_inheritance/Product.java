package ch07_inheritance;

public class Product {
	int price;
	int bonusPoint;
	
	Product(int price){
		this.price = price;
		this.bonusPoint = price / 10;
	}
}
