package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;

public class ProductDB {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/product_management";
		String user = "villageU";
		String password = "villageP";
		
		try (Connection connection = DriverManager.getConnection(url, user, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM products")) {
			System.out.println("DB接続成功");
			System.out.println();
			
			System.out.println("--productsテーブルの全ての商品情報を表示--");
			while (resultSet.next()) {
				System.out.println();
				System.out.println("id: " + resultSet.getInt("id"));
				System.out.println("name: " + resultSet.getString("name"));
				System.out.println("price: " + resultSet.getInt("price"));
				System.out.println("stock: " + resultSet.getInt("stock"));
				System.out.println("category_id: " + resultSet.getInt("category_id"));
			}
		} catch (SQLSyntaxErrorException e) {
			System.out.println("DB接続失敗");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB接続失敗");
			e.printStackTrace();
		}
	}

}
