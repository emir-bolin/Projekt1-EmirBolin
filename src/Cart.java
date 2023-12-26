import java.util.ArrayList;

public class Cart {
    // Attributes
    private int cartId;
    private ArrayList<Product> products;
    private int amountOfProducts;
    private double totalCost;

    // Constructors
    public Cart(int cartId) {
        this.cartId = cartId;
        this.products = new ArrayList<>();
        this.amountOfProducts = 0;
        this.totalCost = 0.0;
    }

    // Methods
    public void addProduct(Product product) {
        products.add(product);
        totalCost += product.getPrice();
    }

    public void displayCart() {
        System.out.println("Cart Contents (Cart ID: " + cartId + "):");
        for (int i = 0; i < amountOfProducts; i++) {
            System.out.println(products.get(i));
        }
        System.out.println("Total cost is: " + totalCost + " kr");
    }
}
