
public class Product {
	private int productNum;
	private String productName;
	private double price;
	public Product(int num, String name, double price) {
		this.productNum = num;
		this.productName = name;
		this.price = price;
	}
	public double getPrice() {
		return this.price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getProductName() {
		return this.productName;
	}
	public void setProductName(String name) {
		this.productName=name;
	}
	public int getProductNum() {
		return this.productNum;
	}
	public void getProductNum(int num) {
		this.productNum = num;
	}

}
