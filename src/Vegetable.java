// SUB-class
public class Vegetable extends Product {
    // Attributes
    private double weight;

    // Constructors
    public Vegetable() {
    }

    public Vegetable(String name, double price, double weight) {
        super(name, price);
        this.weight = weight;
    }

    // Methods
    public double calculateCost(double amount) {
        return price * weight;
    }
}
