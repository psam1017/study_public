package sns.message;

import sns.reply.Reply;

public class MessageDAO {
	
	public boolean newMsg(Message msg) throws Exception{
		
		int flag = 0;
		String sql = "INSERT INTO s_message(uid, msg, date) VALUES (?, ?, now())";
		
		return flag == 1;
	}
	
	public boolean delMsg(int mid) throws Exception{
		
		int flag = 0;
		String sql = "DELETE FROM s_message WHERE mid = ?";
		
		return flag == 1;
	}
	
	public boolean newReply(Reply reply) throws Exception{
		
		int flag = 0;
		String sql = "INSERT INTO s_reply(mid, uid, rmsg, date) VALUES (?, ?, ?, now())";
		
		return flag == 1;
	}
	
	public boolean delReply(int rid) throws Exception{
		
		int flag = 0;
		String sql = "DELETE FROM s_reply WHERE rid = ?";
		
		return flag == 1;
	}
}
