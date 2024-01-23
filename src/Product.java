// SUPER-class
// Abstract class representing a generic product
public abstract class Product {
    // Attributes
    private String name;
    private double price;
    private double stock;

    // Default constructor with parameters to initialize the product attributes
    public Product(String name, double price, double stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    // Getters & setters

    // Returns the product name
    public String getName() {
        return name;
    }

    // Returns the product price
    public double getPrice() {
        return price;
    }

    // Returns the available stock of the product
    public double getStock() {
        return stock;
    }

    // Updates the stock of the product
    public void setStock(double stock) {
        this.stock = stock;
    }

    // Abstract method to get the amount of the product (implementation varies in subclasses)
    public abstract double getAmount();

    // Abstract method to update the amount of the product (implementation varies in subclasses)
    public abstract void updateAmount(double amount);
}
