package new_ch14_io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//	직렬화 : 객체를 데이터 스트림(연속적인 데이터)으로 만드는 것.
//	*객체를 읽을 때는 출력한 순서와 일치해야 한다.

public class Serialization {
	
	public static String fileName = "userinfo.ser"; // 관례상 ser을 확장자 이름으로 사용하지만 이에 대한 제약은 없다.
	public static String fileSrc = ".\\sample_file\\" + fileName;
	
	public static void main(String[] args) {
		
		marshalling();
		unmarshalling();
	}
	
	public static void marshalling() {
		
		try {
			FileOutputStream fos = new FileOutputStream(fileSrc);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream out = new ObjectOutputStream(bos);
			
			UserInfo u1 = new UserInfo("u1", "1234", "Florian");
			UserInfo u2 = new UserInfo("u2", "1234", "Juliana");
			
			out.writeObject(u1);
			out.writeObject(u2);
			out.close();
			System.out.println("객체 직렬화 완료");
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void unmarshalling() {
		
		try {
			FileInputStream fis = new FileInputStream(fileSrc);
			BufferedInputStream bis = new BufferedInputStream(fis);
			ObjectInputStream in = new ObjectInputStream(bis);
			
			// 객체를 읽을 때는 출력한 순서와 일치해야 한다.
			UserInfo u1 = (UserInfo)in.readObject();
			UserInfo u2 = (UserInfo)in.readObject();
			
			System.out.println(u1);
			System.out.println(u2);
			in.close();
			System.out.println("객체 복원 완료");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

@SuppressWarnings("serial")
class UserInfo implements Serializable{
	
	private String id;
	private String pw;
	private String name;
	
	public UserInfo(String id, String pw, String name) {
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "User [id = " + id + ", pw = " + pw + ", name = " + name + "]";
	}
}