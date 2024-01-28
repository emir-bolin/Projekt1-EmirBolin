// Represents a combination of a product and its quantity in the cart
public class CartProduct {
    // Attributes
    private final Product product;
    private double amount;

    // Constructor with parameters to initialize the product and its amount
    public CartProduct(Product product, double amount) {
        this.product = product;
        this.amount = amount;
    }

    // Returns the product
    public Product getProduct() {
        return product;
    }

    // Returns the amount of the product
    public double getAmount() {
        return amount;
    }

    // Updates the amount of the product
    public void setAmount(double amount) {
        this.amount = amount;
    }

    // Calculates and returns the total price of the product based on the amount
    public double getTotalPrice() {
        return (double) (Math.round(product.getPrice() * getAmount() * 100)) / 100;
    }
}
