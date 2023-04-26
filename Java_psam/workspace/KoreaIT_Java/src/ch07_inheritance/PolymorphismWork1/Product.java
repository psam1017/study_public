package ch07_inheritance.PolymorphismWork1;

public class Product {
	
	int price;
	int bonusPoint;
	
	Product(int price){
		this.price = price;
		this.bonusPoint = price / 10;
	}
}
