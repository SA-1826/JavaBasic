package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductDAO {
	public int insert(Product product) throws SQLException {
		String sql = "INSERT INTO products (id, name, price, stock, category_id) VALUES (?, ?, ?, ?, ?)";
		int rowsAffected = 0;
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			pstmt.setInt(1, product.getId());
			pstmt.setString(2, product.getName());
			pstmt.setInt(3, product.getPrice());
			pstmt.setInt(4, product.getStock());
			pstmt.setInt(5, product.getCategoryId());
			
			rowsAffected = pstmt.executeUpdate();
		}
		
		return rowsAffected;
	}
	
	public int updatePriceAndStock(int id, int price, int stock) throws SQLException {
		String sql = "UPDATE products SET price = ?, stock = ? WHERE id = ?";
		int rowsAffected = 0;
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			pstmt.setInt(1, price);
			pstmt.setInt(2, stock);
			pstmt.setInt(3, id);
			
			rowsAffected = pstmt.executeUpdate();
		}
		
		return rowsAffected;
	}
	
	public int delete(int category_id) throws SQLException {
		String sql = "DELETE FROM products WHERE category_id = ?";
		int rowsAffected = 0;
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			pstmt.setInt(1, category_id);
			rowsAffected = pstmt.executeUpdate();
		}
		
		return rowsAffected;
	}
}
