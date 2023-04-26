package payment.repository;

import java.sql.SQLException;
import java.util.List;

import mvc.database.DBConnection;
import payment.domain.OrderData;
import payment.domain.OrderInfo;

public class OrderRepository {
	
	private static OrderRepository instance;
	
	private final String TABLE_DATA = "order_data";
	
	private OrderRepository() { ; }
	
	DBConnection dbc = new DBConnection();
	
	public static OrderRepository getInstance() {
		if(instance == null) {
			instance = new OrderRepository();
		}
		return instance;
	}
	
	public void clearOrderData(String orderNo) {
		
		String sql = "DELETE FROM " + TABLE_DATA + " WHERE orderNo = ?";
		try {
			dbc.connect();
			dbc.pstmt = dbc.conn.prepareStatement(sql);
			dbc.pstmt.setString(1, orderNo);
			dbc.pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbc.disconnect();
		}
	}
	
	public boolean insertOrderData(OrderData data) {
		int flag = 0;
		String sql = "INSERT INTO " + TABLE_DATA + " VALUES(null, ?, ?, ?, ?, ?, ?, ?";
		
		try {
			dbc.connect();
			dbc.pstmt = dbc.conn.prepareStatement(sql);
			dbc.pstmt.setString(1, data.getOrderNo());
			dbc.pstmt.setInt(2, data.getCartId());
			dbc.pstmt.setString(3, data.getBookId());
			dbc.pstmt.setString(4, data.getBookName());
			dbc.pstmt.setInt(5, data.getUnitPrice());
			dbc.pstmt.setInt(6, data.getCnt());
			dbc.pstmt.setInt(7, data.getSumPrice());
			flag = dbc.pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbc.disconnect();
		}
		return flag != 0;
	}
	
	public boolean insertOrderInfo(OrderInfo info) {
		
		int flag = 0;
		String sql = "INSERT INTO " + TABLE_DATA + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, now(), ?, ?, ?)";
		
		try {
			dbc.connect();
			dbc.pstmt = dbc.conn.prepareStatement(sql);
			dbc.pstmt.setString(1, info.getOrderNo());
			dbc.pstmt.setString(2, info.getMemberId());
			
			// ...
			
			flag = dbc.pstmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbc.disconnect();
		}
		return flag == 1;
	}
	
	public List<OrderData> selectAllOrderData(String orderNo){
		
		
		return null;
	}
	
	public int getTotalPrice(String orderNo) {
		
		
		return 0;
	}
	
	public String getOrderProductName(String orderNo) {
		
		String orderProductName = null;
		int orderProductCnt = 0;
		String sql = "SELECT * FROM " + TABLE_DATA + " WHERE orderNo = '" + orderNo + "'";
		
		try {
			dbc.connect();
			dbc.pstmt = dbc.conn.prepareStatement(sql);
			dbc.rs = dbc.pstmt.executeQuery();
			while(dbc.rs.next()) {
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public boolean updateOrderInfoWhenProcessSuccess(OrderInfo info) {
		
		int flag = 0;
		String sql = "UPDATE " + TABLE_DATA + " SET paymethod = ?, orderStep = ?, datePay = now(), WHERE orderNo = ?";
		
		DBConnection dbc = new DBConnection();
		dbc.connect();
		
		try {
			dbc.pstmt = dbc.conn.prepareStatement(sql);
			dbc.pstmt.setString(1, info.getPayMethod());
			dbc.pstmt.setString(2, info.getOrderStep());
			dbc.pstmt.setString(3, info.getOrderNo());
			flag = dbc.pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag == 1;
	}
}
