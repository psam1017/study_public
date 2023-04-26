package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.NewsVO;

public class NewsDAO {
	
	private final String driver = "org.mariadb.jdbc.Driver";
	private final String DB_HOST = "127.0.0.1";
	private final String DB_PORT = "12601";
	private final String DB_NAME = "sample";
	
	private final String DB_URL = "jdbc:mariadb://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME;
	private final String DB_USER = "root";
	private final String DB_PASS = "test1234";


	private Connection open() {
		
		Connection conn = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	private void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		try {
			if(rs != null) {
				rs.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void close(PreparedStatement pstmt, Connection conn) {
		try {
			if(pstmt != null) {
				pstmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addNews(NewsVO news) throws Exception{
		
		Connection conn = open();
		
		String sql = "INSERT INTO news(title, img, date, content) VALUES (?, ?, NOW(), ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		try {
			pstmt.setString(1, news.getTitle());
			pstmt.setString(2, news.getImg());
			pstmt.setString(3, news.getContent());
			pstmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		close(pstmt, conn);
	}
	
	public List<NewsVO> getList() throws Exception {
		
		Connection conn = open();
		List<NewsVO> newsList = new ArrayList<NewsVO>();
		
		String sql = "SELECT aid, title, date FROM news";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		try {
			while(rs.next()) {
				NewsVO vo = new NewsVO();
				vo.setAid(rs.getInt("aid"));
				vo.setTitle(rs.getString("title"));
				vo.setDate(rs.getString("date"));
				newsList.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		close(rs, pstmt, conn);
		
		return newsList;
	}
	
	public NewsVO getNews(int aid) throws Exception{
		
		Connection conn = open();
		
		NewsVO vo = new NewsVO();
		String sql = "SELECT * FROM news WHERE aid = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, aid);
		ResultSet rs = pstmt.executeQuery();
		
		try {
			if(rs.next()) {
				vo.setAid(rs.getInt("aid"));
				vo.setTitle(rs.getString("title"));
				vo.setImg(rs.getString("img"));
				vo.setDate(rs.getString("date"));
				vo.setContent(rs.getString("content"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs, pstmt, conn);
		}
		
		return vo;
	}
	
	public void deleteNews(int aid) throws Exception{
		
		Connection conn = open();
		String sql = "DELETE FROM news WHERE aid = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		try {
			pstmt.setInt(1, aid);
			if(pstmt.executeUpdate() == 0) {
				throw new SQLException("존재하지 않는 index");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt, conn);
		}
	}
}
