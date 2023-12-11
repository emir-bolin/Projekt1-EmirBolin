// SUPER-class
public class Product {
    // Attributes
    protected String name;
    protected double price;
    protected int quantity;

    // Default Constructors
    public Product(){}

    public Product(String name, double price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Methods
    public void calcCost() {
        double cost = price * quantity;
        System.out.println("The cost of this " + this.name + " is " + cost);
    }

}
