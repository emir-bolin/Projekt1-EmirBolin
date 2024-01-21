// SUB-class
public class WeightedProduct extends Product {
    // Attributes
    private double amount;

    // Constructors
    public WeightedProduct() {
    }

    public WeightedProduct(String name, double price, double stock, double amount) {
        super(name, price, stock);
        this.amount = amount;
    }

    // Methods

    // Getters and setters
    @Override
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}