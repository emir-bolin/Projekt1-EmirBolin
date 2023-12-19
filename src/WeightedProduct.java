// SUB-class
public class WeightedProduct extends Product {
    // Attributes
    private double weight;

    // Constructors
    public WeightedProduct(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    @Override
    public void calcCost() {
        double cost = price * weight;
        System.out.println("The cost of the " + this.name + "s is " + cost);
    }
}
