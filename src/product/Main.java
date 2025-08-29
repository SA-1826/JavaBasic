package product;

import java.util.List;

public class Main {

	public static void main(String[] args) {

		Product product1 = new Product(1, "冷蔵庫", 50000, 10);
		Product product2 = new Product(2, "ソファ", 30000, 5);
		Product product3 = new Product(3, "米", 2000, 3);
		Product product4 = new Product(4, "小説", 1500, 4);
		Product product5 = new Product(5, "Tシャツ", 1500, 5);
		
		ProductsManager manager = new ProductsManager();
		
		manager.addProduct(product1);
		manager.addProduct(product2);
		manager.addProduct(product3);
		manager.addProduct(product4);
		manager.addProduct(product5);
		
		System.out.println("---商品を5つ追加して全てを表示する---");
		manager.showAllProducts();
		
		System.out.println();
		
		System.out.println("---商品を1つ削除して全てを表示する---");
		manager.removeProduct(1);
		manager.showAllProducts();
		
		System.out.println();
		
		System.out.println("---商品名「米」の情報を表示する---");
		System.out.println(manager.getProductByName("米"));
		
		System.out.println();
		
		DiscountedProduct discountedProduct2 = new DiscountedProduct(
			product2.getId(),
			product2.getName(),
			product2.getPrice(),
			product2.getStock(),
			0.3
		);
		manager.removeProduct(2);
		manager.addProduct(discountedProduct2);
		System.out.println("--商品名「ソファ」の情報と割引率30%の情報を表示する--");
		System.out.println(manager.getProductByName("ソファ"));
		
		System.out.println();
		
		System.out.println("--商品名「Tシャツ」を検索して表示する--");
		List<Product> searchResult = manager.search("Tシャツ");
		if (searchResult.isEmpty()) {
			System.out.println("商品が見つかりませんでした。");
		} else {
			for (Product product : searchResult) {
				System.out.println(product);
			}
		}
		
	}

}
