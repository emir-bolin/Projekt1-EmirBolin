// SUB-class
public class Dairy extends Product{
    // Attributes
    private int quantity;

    // Constructors
    public Dairy(){}
    public Dairy(String name, double price, int quantity){
        super(name, price);
        this.quantity = quantity;
    }
}
