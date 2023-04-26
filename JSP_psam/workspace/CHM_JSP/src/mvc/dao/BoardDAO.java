package mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mvc.database.DBConnection;
import mvc.dto.BoardDTO;

public class BoardDAO {
	
	private static BoardDAO instance;
	
	private BoardDAO() { ; }
	
	public static BoardDAO getInstance() {
		if(instance == null) {
			instance = new BoardDAO();
		}
		return instance;
	}
	
	public int getListCount(String items, String text) {
		
		DBConnection db = new DBConnection();
		db.connect();
		
		int count = 0;
		
		String sql;
		
		if(items == null && text == null) {
			sql = "SELECT COUNT(*) FROM board";
		}
		else {
			sql = "SELECT COUNT(*) FROM board WHERE " + items + " LIKE '%" + text + "%'";
		}
		
		try {
			db.pstmt = db.conn.prepareStatement(sql);
			db.rs = db.pstmt.executeQuery();
			
			if(db.rs.next()) {
				count = db.rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		db.disconnect();
		return count;
	}
	
	public ArrayList<BoardDTO> getBoardList(int page, int limit, String items, String text){
		
		int totalRecord = getListCount(items, text);
		int start = (page - 1) * limit;
		int index = start + 1;
		ArrayList<BoardDTO> list = new ArrayList<>();
		
		Connection conn = new DBConnection().getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql;
		
		if(items == null && text == null) {
			sql = "SELECT * FROM board ORDER BY num DESC";
		}
		else {
			sql = "SELECT * FROM board WHERE " + items + " LIKE '%" + text + "%' ORDER BY num DESC LIMIT " + limit;
		}
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setNum(rs.getInt("num"));
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setRegisterDay(rs.getString("register_day"));
				dto.setHit(rs.getInt("hit"));
				dto.setIp(rs.getString("ip"));
				
				list.add(dto);
				
				if(index < (start + limit) && index <= totalRecord) {
					index++;
				}
				else {
					break;
				}
			}
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
			disconnect(conn, pstmt, rs);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disconnect(conn, pstmt, rs);
		return null;
	}
	
	public String getLoginNameById(String id) {
		
		String name = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT name FROM member WHERE id = ?";
		try {
			conn = new DBConnection().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				name = rs.getString(1);
			}
			disconnect(conn, pstmt, rs);
			return name;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disconnect(conn, pstmt, rs);
		return null;
	}
	
	public void insertBoard(BoardDTO dto) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = new DBConnection().getConnection();
			
			String sql = "INSERT INTO board(id, name, subject, content, ip) VALUES(?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getSubject());
			pstmt.setString(4, dto.getContent());
			pstmt.setString(5, dto.getIp());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect(conn, pstmt);
		}
	}
	
	public BoardDTO getBoardByNum(int num) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardDTO board = null;
		
		updateHit(num);
		
		try {
			conn = new DBConnection().getConnection();
			
			String sql = "SELECT * FROM board WHERE num = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				board = new BoardDTO();
				board.setNum(rs.getInt("num"));
				board.setId(rs.getString("id"));
				board.setName(rs.getString("name"));
				board.setSubject(rs.getString("subject"));
				board.setContent(rs.getString("content"));
				board.setRegisterDay(rs.getString("register_day"));
				board.setHit(rs.getInt("hit"));
				board.setIp(rs.getString("ip"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect(conn, pstmt, rs);
		}
		return board;
	}
	
	public void updateBoard(BoardDTO board) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = new DBConnection().getConnection();
			
			String sql = "UPDATE board SET name = ?, subject = ?, content = ?, ip = ? WHERE num = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getName());
			pstmt.setString(2, board.getSubject());
			pstmt.setString(3, board.getContent());
			pstmt.setString(4, board.getIp());
			pstmt.setInt(5, board.getNum());
			pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect(conn, pstmt);
		}
	}
	
	public void deleteBoard(int num) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = new DBConnection().getConnection();
			String sql = "DELETE FROM board WHERE num = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect(conn, pstmt);
		}
	}
	
	private void updateHit(int num) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = new DBConnection().getConnection();
			
			String sql = "UPDATE board SET hit = hit + 1 WHERE num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disconnect(conn, pstmt);
	}
	
	private void disconnect(Connection conn, PreparedStatement pstmt) {
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
	
	private void disconnect(Connection conn, PreparedStatement pstmt, ResultSet rs) {
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
}
