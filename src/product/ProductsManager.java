package product;

import java.util.ArrayList;
import java.util.List;

public class ProductsManager implements Searchable {
	private List<Product> products;
	
	public ProductsManager() {
		this.products = new ArrayList<>();
	}
	
	// 新たなproductを追加
	public void addProduct(Product product) {
		products.add(product);
	}

	// idを引数としてproductを削除
	public void removeProduct(int id) {
		products.removeIf(product -> product.getId() == id);
	}
	
	// nameを引数としてproduct情報を取得
	public Product getProductByName(String name) {
		for (Product product : products) {
			if (product.getName().equals(name)) {
				return product;
			}
		}
		throw new IllegalArgumentException("指定された商品は存在しません：" + name);
	}
	
	public void showAllProducts() {
		for (Product product : products) {
			System.out.println(product);
		}
	}
	
	@Override
	public List<Product> search(String keyword) {
		List<Product> result = new ArrayList<>();
		for (Product product : products) {
			if (product.getName().contains(keyword)) {
				result.add(product);
			}
		}
		return result;
	}
}
