package ch12_collection.stack_queue_;

import java.util.LinkedList;
import java.util.Queue;

public class Queue01 {
	public static void main(String[] args) {
		
		Queue<Message> msgQueue = new LinkedList<Message>();
		
		msgQueue.offer(new Message("sendMail", "홍길동"));
		msgQueue.offer(new Message("sendSMS", "신용권"));
		msgQueue.offer(new Message("sendLine", "홍두깨"));
		
		while(!msgQueue.isEmpty()){
			
			Message msg = msgQueue.poll();
			
			switch(msg.command) {
				case "sendMail":
					System.out.println(msg.to + " 님에게 메일을 보냅니다.");
					break;
				case "sendSMS": 
					System.out.println(msg.to + " 님에게 메시지를 보냅니다.");
					break;
				case "sendLine": 
					System.out.println(msg.to + " 님에게 라인을 보냅니다.");
					break;
			}
		}
	}
}

class Message{
	
	public String command;
	public String to;
	
	public Message(String command, String to) {
		this.command = command;
		this.to = to;
	}
}