package mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import _06_action_tags.market.dto.ProductDTO;
import mvc.database.DBConnection;
import mvc.dto.CartDTO;

public class CartDAO {
	
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	private void connect() {
		try {
			connection = new DBConnection().getConnection();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public CartDAO() {
		connect();
	}
	
	public boolean updateCart(ProductDTO dto, String orderNo, String memberId) throws SQLException {
		
		int flag = 0;
		
		String sql = "SELECT cartId FROM cart WHERE orderNO = ? AND productId = ? LIMIT 1";
		
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, orderNo);
		preparedStatement.setString(1, memberId);
		resultSet = preparedStatement.executeQuery();
		
		if(resultSet.next()) {
			int cartId = resultSet.getInt("cartdID");
			sql = "UPDATE cart SET cnt = cnt + 1 WHERE cartId = ?";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, cartId);
			flag = preparedStatement.executeUpdate();
		}
		else {
			sql = "INSERT INTO cart VALUES (null, ?, ?, ?, ?, ?, ?, now())";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, memberId);
			preparedStatement.setString(2, orderNo);
			preparedStatement.setString(3, dto.getProductID());
			preparedStatement.setString(4, dto.getpName());
			preparedStatement.setInt(5, dto.getUnitPrice());
			preparedStatement.setInt(6, 1);
			
			flag = preparedStatement.executeUpdate();
		}
		
		return flag == 1;
	}
	
	public ArrayList<CartDTO> getCartList(String orderNo) throws SQLException{
		
		ArrayList<CartDTO> cartList = new ArrayList<>();
		
		String sql = "SELECT * FROM cart WHERE orderNo = ?";
		
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, orderNo);
		resultSet = preparedStatement.executeQuery();
		
		while(resultSet.next()) {
			CartDTO dto = new CartDTO();
			dto.setCartId(resultSet.getInt("cartId"));
			dto.setMemberId(resultSet.getString("memberId"));
			dto.setOrderNo(orderNo);
			dto.setName(resultSet.getString("name"));
			dto.setUnitPrice(resultSet.getInt("unitPrice"));;
			dto.setCnt(resultSet.getInt("cnt"));
			dto.setInsertDate(resultSet.getString("insertDate"));
			
			cartList.add(dto);
		}
		
		return cartList;
	}
	
	public boolean updateCartByLogin(HttpSession session) throws SQLException {
		int flag = 0;
		String orderNo = session.getId();
		String id = (String)session.getAttribute("sessionId");
		
		String sql = "UPDATE cart SET orderNo = ? WHERE id = ?";
		
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, id);
		preparedStatement.setString(2, orderNo);
		flag = preparedStatement.executeUpdate();
		
		return flag != 0;
	}
	
	public boolean deleteCartById(String orderNo, int cartId) throws SQLException {
		
		int flag = 0;
		String sql = "SELECT * FROM cart WHERE orderNo = ? AND carId = ?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, orderNo);
		preparedStatement.setInt(2, cartId);
		resultSet = preparedStatement.executeQuery();
		
		if(resultSet.next()) {
			sql = "DELETE FROM cart WHERE cartId = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, cartId);
			flag = preparedStatement.executeUpdate();
		}
		
		return flag == 1;
	}
	
	public boolean deleteCartAll(String orderNo) throws SQLException {
		
		int flag = 0;
		
		String sql = "DELETE FROM cart WHERE orderNo = ?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, orderNo);
		flag = preparedStatement.executeUpdate();
		
		return flag != 0;
	}
}
