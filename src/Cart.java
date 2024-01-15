import java.util.ArrayList;

public class Cart {
    // Attributes
    private ArrayList<Product> products = new ArrayList<Product>();
    private double totalCost = 0.0;

    // Constructors
    public Cart() {
    }

    // Methods
    public void addProduct(Product product) {
        products.add(product);
        totalCost += product.getPrice(); // Todo: detect if the product is a vegetable or dairy to calculate price
    }

    public void showCart() {
        System.out.println("Cart Contents:");
        for (Product product : products) {
            System.out.println(product);
        }
        System.out.println("\nTotal cost is: " + totalCost + " kr");
    }
}
