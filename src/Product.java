// SUPER-class
// Abstract class representing a generic product
public abstract class Product {
    // Attributes
    private String name;
    private double price;
    private double stock;
    private String amountType;

    // Default constructor with parameters to initialize the product attributes
    public Product(String name, double price, double stock, String amountType) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.amountType = amountType;
    }

    //Method

    // Returns true if amount is less than stock
    public boolean isInStock(double wantedAmount) {
        if (wantedAmount > getStock()) {
            System.out.println("There is only " + getStock() + getAmountType() + getName() + " in stock");
            return false;
        }
        return true;
    }

    // Getters & setters

    // Returns the product name
    public String getName() {
        return name;
    }

    // Returns the product price
    public double getPrice() {
        return price;
    }

    // Returns the available stock of the product
    public double getStock() {
        return stock;
    }

    // Updates the stock of the product
    public void setStock(double stock) {
        this.stock = stock;
    }

    // Returns the type of the amount
    public String getAmountType() {
        return amountType;
    }

    // Abstract method to update the amount of the product (implementation of amount varies in subclasses)
    public abstract void updateAmount(double amount);
}
