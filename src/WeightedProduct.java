// SUB-class
// Representing a product with a specific weight
public class WeightedProduct extends Product {
    // Attributes
    private double amount;

    // Constructor to initialize the attributes of the WeightedProduct
    public WeightedProduct(String name, double price, double stock, double amount) {
        super(name, price, stock, " kg ");
        this.amount = amount;
    }

    // Methods

    // Updates the amount of the product and adjusts the stock accordingly
    public void updateAmount(double amount) {
        this.amount += amount;
        this.setStock(getStock() - amount);
    }

    // Getters & setters
    
    // Returns the amount of the product
    @Override
    public double getAmount() {
        return amount;
    }
}