package ch12_collection.stack_queue_;

import java.util.ArrayList;

public class ArrayListToStack {
	public static void main(String[] args) {
		
		MyStack stack = new MyStack();
		
		stack.push("A");
		stack.push("B");
		stack.push("C");
		
		System.out.print("현재 스택의 마지막 자료 : ");
		System.out.println(stack.peek());
		
		System.out.println("\n---스택에서 자료들을 하나씩 제거---");
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		System.out.println("\n---스택에서 자료들 모두 제거 완료한 후 다시 제거---");
		System.out.println(stack.pop());
	}
}

class MyStack{
	
	private ArrayList<String> arrayStack = new ArrayList<String>();
	
	public void push(String data) {
		arrayStack.add(data);
	}
	
	public String pop() {
		int len = arrayStack.size();
		if(len == 0) {
			return "스택이 비었습니다.";
		}
		return arrayStack.remove(len - 1);
	}
	
	public String peek() {
		int len = arrayStack.size();
		if(len == 0) {
			return "스택이 비었습니다.";
		}
		return arrayStack.get(len - 1);
	}
}