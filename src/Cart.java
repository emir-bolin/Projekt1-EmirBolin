import java.util.ArrayList;

public class Cart {
    // Attributes
    private ArrayList<Product> products;
    private double totalCost;

    // Constructors
    public Cart() {
        this.products = new ArrayList<Product>();
        this.totalCost = 0.00;
    }

    // Methods
    public void addProduct(Product product) {
        products.add(product);
        totalCost += product.getPrice(); // Todo: detect if the product is a vegetable or dairy to calculate price
    }

    public void displayCart() {
        System.out.println("Cart Contents:");
        for (Product product : products) {
            System.out.println(product);
        }
        System.out.println("\nTotal cost is: " + totalCost + " kr");
    }
}
