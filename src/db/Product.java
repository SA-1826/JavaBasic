package db;

public class Product {
	private int id;
	private String name;
	private int price;
	private int stock;
	private int category_id;
	
	public Product(String name, int price, int stock, int category_id) {
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.category_id = category_id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getStock() {
		return stock;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public int getCategoryId() {
		return category_id;
	}
	
	public void setCategoryId(int category_id) {
		this.category_id = category_id;
	}
}
