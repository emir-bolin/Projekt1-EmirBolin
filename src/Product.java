// SUPER-class
public abstract class Product {
    // Attributes
    protected String name; // Todo: change to private
    protected double price;
    protected double stock;

    // Default Constructors
    public Product() {
    }

    public Product(String name, double price, double stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    // Methods
    public double calculateCost(double amount) {
        return price * amount;
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

    public double getTotalPrice() {
        return getPrice() * getAmount();
    }

}
