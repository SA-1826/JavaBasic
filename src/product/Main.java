package product;

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
	}

}
