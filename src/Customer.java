public class Customer {
    // Attributes
    private String name;
    private Cart cart;

    // Constructors
    public Customer(String name) {
        this.name = name;
        this.cart = new Cart();
    }

    // Methods

    // Getters & setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
