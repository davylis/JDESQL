import java.text.DecimalFormat;
import java.util.ArrayList;

public class ShoppingCart {
	private ArrayList<Item> cart;

	public ShoppingCart() {
		this.cart = new ArrayList<Item>();
	}
	public void add(Product product, int quantity) {
		Item item = new Item(product, quantity);
		this.cart.add(item);
	}
	public void remove(Product product) {
		for(Item i : cart) {
			if(i.getProduct()==product) {
				cart.remove(i);
			}
		}
	}
	public double getTotalPrice() {
		double price = 0.0;
		for(Item i : cart) {
			price += i.getSubtotal();
		}
		return price;
	}
	public String toString() {
		if(cart.isEmpty()) {
			return "There are no items in the shopping cart.\n";
		}
		DecimalFormat twoDecimal = new DecimalFormat("0.00");
		String string = "=== Shopping cart ===\n";
		for(Item item : cart) {
			Product currentProduct = item.getProduct();
			string += currentProduct.getProductNum() + ": ";
			string += currentProduct.getProductName();
			string += ", quantity: " + item.getQuantity();
			string += ", unit price: " + twoDecimal.format(currentProduct.getPrice());
			string += ", subtotal: " + twoDecimal.format(item.getSubtotal()) + "\n";
		}
		string += "TOTAL PRICE: " + twoDecimal.format(getTotalPrice()) + " euros\n";
		return string;
	}
	}

