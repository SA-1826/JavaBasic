package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.Scanner;

public class ProductDB {

	public static void main(String[] args) {
		// 7週目課題のコード
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
		
		// 8週目課題のコード
		ProductDAO productDAO = new ProductDAO();
		Scanner scanner = new Scanner(System.in);
		
		try {
			System.out.println("--商品の登録--");
			System.out.println("商品名を入力してください：");
			String newName = scanner.nextLine();
			if (newName.isBlank()) {
				System.out.println("無効な入力です。入力された商品名：" + newName);
				throw new Exception("無効な入力です。商品名を正しく入力してください。");
			}
			
			System.out.println("価格を入力してください：");
			int newPrice = scanner.nextInt();
			if (newPrice < 0) {
				System.out.println("無効な入力です。入力された価格：" + newPrice);
				throw new Exception("無効な入力です。価格を正しく入力してください。");
			}
			
			System.out.println("在庫数を入力してください：");
			int newStock = scanner.nextInt();
			if (newStock < 0) {
				System.out.println("無効な入力です。入力された在庫数：" + newStock);
				throw new Exception("無効な入力です。在庫を正しく入力してください。");
			}
			
			System.out.println("カテゴリーIDを入力してください：");
			int newCategoryId = scanner.nextInt();
			if (newCategoryId <= 0) {
				System.out.println("無効な入力です。入力されたカテゴリーID：" + newCategoryId);
				throw new Exception("無効な入力です。カテゴリーIDを正しく入力してください。");
			}
			
			Product newProduct = new Product(newName, newPrice, newStock, newCategoryId);
			int rowsInserted = productDAO.insert(newProduct);
			System.out.println("登録成功件数：" + rowsInserted + "件");
			System.out.println("登録内容：");
			System.out.println("商品名：" + newName + ", 価格：" + newPrice + ", 在庫数：" + newStock + ", カテゴリーID：" + newCategoryId);
			
		} catch (SQLException e) {
			System.out.println("DB接続失敗");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			System.out.println();
			System.out.println("--商品の価格と在庫を更新--");
			System.out.println("商品IDを入力してください：");
			int updateId = scanner.nextInt();
			
			System.out.println("価格を入力してください：");
			int updatePrice = scanner.nextInt();
			
			System.out.println("在庫数を入力してください：");
			int updateStock = scanner.nextInt();
			
			int rowsUpdated = productDAO.updatePriceAndStock(updateId, updatePrice, updateStock);
			System.out.println("更新成功件数：" + rowsUpdated + "件");
			if (rowsUpdated == 0) {
				System.out.println("更新失敗");
			} else {
				System.out.println("更新内容：");
				System.out.println("商品ID：" + updateId + ", 価格：" + updatePrice + ", 在庫数：" + updateStock);
			}
			
		} catch (SQLException e) {
			System.out.println("DB接続失敗");
			e.printStackTrace();
		}
		
		try {
			System.out.println();
			System.out.println("-商品の削除（カテゴリーID指定）-");
			System.out.println("削除するカテゴリーIDを入力してください：");
			int deleteId = scanner.nextInt();
			
			int rowsDeleted = productDAO.delete(deleteId);
			System.out.println("削除成功件数：" + rowsDeleted + "件");
			System.out.println("カテゴリーID " + deleteId + " の商品を削除しました。");
			
		} catch (SQLException e) {
			System.out.println("DB接続失敗");
			e.printStackTrace();
		}
		
		scanner.close();
	}

}
