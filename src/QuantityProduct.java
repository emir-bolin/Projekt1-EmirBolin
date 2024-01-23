// SUB-class
public class QuantityProduct extends Product {
    // Attributes
    private int amount;

    // Constructors
    public QuantityProduct() {
    } // Todo: maybe remove this line?

    public QuantityProduct(String name, double price, double stock, int amount) {
        super(name, price, stock);
        this.amount = amount;
    }

    // Methods
    public void updateAmount(double amount) {
        this.amount += amount;
        this.setStock(getStock() - amount);
    }

    // Getters & setters
    @Override
    public double getAmount() {
        return amount;
    }
}