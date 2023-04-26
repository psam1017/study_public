package sns.member;

import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	
	public boolean addMember(Member member) throws Exception{
		int flag = 0;
		String sql = "INSERT INTO s_member(name, uid, passwd, email, date) VALUES (?, ?, ?, ?, now())";
		
		return flag == 1;
	}
	
	public boolean login(String uid, String passwd) throws Exception{
		String sql = "SELECT count(uid) FROM s_member WHERE uid = ?";
		boolean flag = false;
		
//	@Cleanup Connection connection = DBManager.INSTANCE.getConnection();
//	@Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
//	preparedStatement.setString(1, uid);
//	@Cleanup ResultSet resultSet = preparedStatement.executeQuery();
		
//	resultSet.next();
//	if(resultSet.getString("passwd")).equals(passwd){
//		flag = true;
//	}
		
		return flag;
	}
	
	public List<String> getNewMembers() throws Exception{
		
		String sql = "SELECT * FROM s_member ORDER BY DATE DESC LIMIT 0, 7";
		List<String> members = new ArrayList<String>();
		
//		@Cleanup Connection connection = DBManager.INSTANCE.getConnection();
//		@Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
//		@Cleanup ResultSet resultSet = preparedStatement.executeQuery();
//		while(resultSet.next()) {
//			members.add(resultSet.getString("id"));
//		}
		
		return members;
	}
}
