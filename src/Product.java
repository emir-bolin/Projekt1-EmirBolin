// SUPER-class
public abstract class Product {
    // Attributes
    private String name;
    private double price;
    private double stock;

    // Default Constructors
    public Product() {
    }

    public Product(String name, double price, double stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    // Getters & setters
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }

    public abstract double getAmount();

    public abstract void updateAmount(double amount);
}
