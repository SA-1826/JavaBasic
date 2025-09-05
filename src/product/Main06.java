package product;

import java.util.List;
import java.util.Scanner;

public class Main06 {

	public static void main(String[] args) {
		ProductsManager manager = new ProductsManager();
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.println("--メニュー--");
			System.out.println("1:商品追加");
			System.out.println("2:商品情報取得");
			System.out.println("3:商品検索");
			System.out.println("4:商品全て表示");
			System.out.println("5:商品削除");
			System.out.println("0:終了");
			System.out.println();
			System.out.println("メニューから操作を選択してください。");
			
			int choice = scanner.nextInt();
			scanner.nextLine();
			
			switch (choice) {
				case 1 -> {
					try {
						System.out.println("商品IDを入力してください：");
						int newId = scanner.nextInt();
						scanner.nextLine();
						System.out.println("入力された商品ID：" + newId);
						
						System.out.println("商品名を入力してください：");
						String newName = scanner.nextLine();
						if (newName.isBlank()) {
							System.out.println("無効な入力です。入力された商品名：" + newName);
							throw new Exception("無効な入力です。商品名を正しく入力してください。");
						} else {
							System.out.println("入力された商品名：" + newName);
						}
						
						System.out.println("価格を入力してください：");
						int newPrice = scanner.nextInt();
						if (newPrice < 0) {
							System.out.println("無効な入力です。入力された価格：" + newPrice);
							throw new Exception("無効な入力です。価格を正しく入力してください。");
						} else {
							System.out.println("入力された価格：" + newPrice);
						}
						
						System.out.println("在庫数を入力してください：");
						int newStock = scanner.nextInt();
						if (newStock < 0) {
							System.out.println("無効な入力です。入力された在庫数：" + newStock);
							throw new Exception("無効な入力です。在庫を正しく入力してください。");
						} else {
							System.out.println("入力された在庫：" + newStock);
						}
						
						Product newProduct = new Product(newId, newName, newPrice, newStock);
						manager.addProduct(newProduct);
						System.out.println(newProduct + "を登録しました。");
					} catch (Exception e) {
						e.printStackTrace();
						break;
					}
				}
				
				case 2 -> {
					System.out.println("商品情報を取得する商品名を入力してください：");
					String productName = scanner.nextLine();
					try {
						System.out.println("取得した商品は、" + manager.getProductByName(productName) + "です。");
					} catch (IllegalArgumentException e) {
						System.out.println(e.getMessage());
					}
				}
				
				case 3 -> {
					System.out.println("検索する商品名を入力してください：");
					String searchName = scanner.nextLine();
					List<Product> searchResult = manager.search(searchName);
					if (searchResult.isEmpty()) {
						System.out.println("商品が見つかりませんでした。");
					} else {
						for (Product product : searchResult) {
							System.out.println(product);
						}
					}
				}
				
				case 4 -> {
					System.out.println("商品を全て表示します");
					manager.showAllProducts();
				}
				
				case 5 -> {
					System.out.println("削除する商品のIDを入力してください：");
					int deleteId = scanner.nextInt();
					scanner.nextLine();
					manager.removeProduct(deleteId);
					System.out.println("商品IDが" + deleteId + "の商品を削除しました");
				}
				
				case 0 -> {
					System.out.println("終了します");
					scanner.close();
					return;
				}
				
				default -> System.out.println("無効な入力です。もう一度入力してください。");
			}
			
			System.out.println();
		}
	}

}
