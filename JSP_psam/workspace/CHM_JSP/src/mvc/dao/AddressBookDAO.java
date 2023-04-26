package mvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mvc.dto.AddressBookDTO;

public class AddressBookDAO {
	
	private final String driver = "org.mariadb.jdbc.Driver";
	private final String DB_HOST = "127.0.0.1";
	private final String DB_PORT = "12601";
	private final String DB_NAME = "sample";
	
	private final String DB_URL = "jdbc:mariadb://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME;
	private final String DB_USER = "root";
	private final String DB_PASS = "test1234";

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private void connect() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void disconnect() {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<AddressBookDTO> getDBList(){
		
		connect();
		ArrayList<AddressBookDTO> datas = new ArrayList<>();
		
		String sql = "SELECT * FROM address_book ORDER BY id DESC";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				AddressBookDTO dto = new AddressBookDTO();
				
				dto.setId(rs.getInt("id"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				dto.setComdept(rs.getString("comdept"));
				dto.setBirth(rs.getString("birth"));
				dto.setTel(rs.getString("tel"));
				dto.setMemo(rs.getString("memo"));
				
				datas.add(dto);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			disconnect();
		}
		
		return datas;
	}
	
	public boolean insertDB(AddressBookDTO dto) {
		
		connect();
		
		// AUTO_INCREMENT는 NULL을 대입했을 때 자동으로 숫자가 증가한다.
		String sql = "INSERT INTO address_book(name, email, birth, tel, comdept, memo)";
		sql += "VALUES (?, ?, ?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getBirth());
			pstmt.setString(4, dto.getTel());
			pstmt.setString(5, dto.getComdept());
			pstmt.setString(6, dto.getMemo());
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			disconnect();
		}
		return true;
	}
	
	// 전달 받는 id는 이미 select된 결과에 대해서만 요청이 가능하므로 반드시 존재하는 값이다.
	// 단, 개발자 도구 등으로 위변조하여 요청하는 경우를 막을 수는 없다.
	public AddressBookDTO getDB(int id) {
		
		connect();
		
		String sql = "SELECT * FROM address_book WHERE id = ?";
		AddressBookDTO dto = new AddressBookDTO();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setId(rs.getInt("id"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				dto.setComdept(rs.getString("comdept"));
				dto.setBirth(rs.getString("birth"));
				dto.setTel(rs.getString("tel"));
				dto.setMemo(rs.getString("memo"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			disconnect();
		}
		
		return dto;
	}
	
	public boolean updateDB(AddressBookDTO dto) {
		
		connect();
		
		String sql = "UPDATE address_book SET name = ?, email = ?, birth = ?, tel = ?, comdept = ?, memo = ? WHERE id = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getBirth());
			pstmt.setString(4, dto.getTel());
			pstmt.setString(5, dto.getComdept());
			pstmt.setString(6, dto.getMemo());
			pstmt.setInt(7, dto.getId());
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			disconnect();
		}
		return true;
	}
	
	public boolean deleteDB(int id) {
		
		connect();
		
		String sql = "DELETE FROM address_book WHERE id = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			disconnect();
		}
		return true;
	}
}
