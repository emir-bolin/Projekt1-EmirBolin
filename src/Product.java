// SUPER-class
public class Product {
    // Attributes
    protected String name;
    protected double price;
    protected int quantity;
    protected double weight;

    // Default Constructors
    public Product(){}
    public Product(String name, double price, int quantity){
        this.initialize(name, price);
        this.quantity = quantity;
    }

    public Product(String name, double price, double weight){
        this.initialize(name, price);
        this.weight = weight;
    }

    public void initialize(String name, double price){
        this.name = name;
        this.price = price;
    }

    // Methods
    public void calcCost() {
        double cost = price * quantity;
        System.out.println("The cost of this " + this.name + " is " + cost);
    }

}