public class QuantityProduct extends Product{
    // Attributes
    private int quantity;

    // Constructors
    public QuantityProduct(){}
    public QuantityProduct(String name, double price, int quantity){
        super(name, price);
        this.quantity = quantity;
    }

    // Methods
    @Override
    public void calcCost() {
        double cost = price * quantity;
        System.out.println("The cost of the " + this.name + " is " + cost);
    }
}
