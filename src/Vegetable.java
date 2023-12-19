// SUB-class
public class Vegetable extends Product{
    // Attributes
    private double weight;

    // Constructors
    public Vegetable(){}
    public Vegetable(String name, double price, int quantity, double weight){
        super(name, price, quantity);
        this.weight = weight;
    }

    // Methods


}
