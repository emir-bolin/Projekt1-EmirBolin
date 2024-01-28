// SUB-class
// Representing a product with a specific quantity
public class QuantityProduct extends Product {
    // Attributes
    private int amount;

    // Constructor to initialize the attributes of the QuantityProduct
    public QuantityProduct(String name, double price, double stock, int amount) {
        super(name, price, stock, " ");
        this.amount = amount;
    }

    // Methods

    // Updates the amount of the product and adjusts the stock accordingly
    public void updateAmount(double amount) {
        this.amount += (int) amount;
        this.setStock(getStock() - amount);
    }

    // Getters & setters

    // Returns the amount of the product
    @Override
    public double getAmount() {
        return amount;
    }
}