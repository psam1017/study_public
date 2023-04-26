package ch12_collection.stack_queue_;

import java.util.Stack;

public class Stack01 {
	public static void main(String[] args) {
		
		Stack<Coin> coinBox = new Stack<Coin>();
		
		coinBox.push(new Coin(500));
		coinBox.push(new Coin(500));
		coinBox.push(new Coin(100));
		coinBox.push(new Coin(100));
		
		while(!coinBox.isEmpty()) {
			Coin coin = coinBox.pop();
			System.out.println("꺼낸 동전 : " + coin.getCoin());
		}
		
		System.out.println("동전함이 비었습니다.");
	}
}

class Coin{
	
	private int value;
	
	public Coin(int value) {
		this.value = value;
	}
	
	public int getCoin() {
		return this.value;
	}
}