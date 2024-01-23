// SUB-class
public class WeightedProduct extends Product {
    // Attributes
    private double amount;

    // Constructors
    public WeightedProduct() {
    } // Todo: maybe remove this line?

    public WeightedProduct(String name, double price, double stock, double amount) {
        super(name, price, stock);
        this.amount = amount;
    }

    // Methods
    public void updateAmount(double amount) {
        this.amount += amount;
        this.setStock(getStock() - amount);
    }

    // Getters and setters
    @Override
    public double getAmount() {
        return amount;
    }
}