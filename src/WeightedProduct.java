// SUB-class
public class WeightedProduct extends Product {
    // Attributes
    private double weight;

    // Constructors
    public WeightedProduct(String name, double price, double weight) {
        super(name, price);
        this.weight = weight;
    }

    @Override
    public void calcCost() {
        double cost = price * weight;
        System.out.println("The cost of the " + this.name + "s is " + cost);
    }
}
