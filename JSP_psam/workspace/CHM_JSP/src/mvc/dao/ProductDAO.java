package mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import _06_action_tags.market.dto.ProductDTO;
import mvc.database.DBConnection;

public class ProductDAO {
	
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
	
	public ProductDAO() {
		connect();
	}
	
	public ProductDTO getProductById(String id) throws SQLException {
		
		ProductDTO dto = null;
		String sql = "SELECT * FROM product WHERE p_id = ? LIMIT 1";
		
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, id);
		resultSet = preparedStatement.executeQuery();
		
		if(resultSet.next()) {
			dto = new ProductDTO();
			dto.setProductID(resultSet.getString("p_id"));
			dto.setpName(resultSet.getString("p_name"));
			dto.setUnitPrice(resultSet.getInt("p_unitPrice"));
			dto.setDescription(resultSet.getString("p_description"));
			dto.setCategory(resultSet.getString("p_category"));
			dto.setManufacturer(resultSet.getString("p_manufacturer"));
			dto.setUnitsInStock(resultSet.getInt("p_unitsInStock"));
			dto.setCondition(resultSet.getString("p_condition"));
			dto.setFilename(resultSet.getString("p_fileName"));
		}
		
		if(resultSet != null){
			resultSet.close();
		}
		if(preparedStatement != null){
			preparedStatement.close();
		}
		if(connection != null){
			connection.close();
		}
		
		return dto;
	}
}
