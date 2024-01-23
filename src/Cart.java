import java.util.ArrayList;

public class Cart {
    // Attributes
    private ArrayList<AmountOfProduct> myCart = new ArrayList<>();
    private String userName;

    // Constructors
    public Cart(String userName) {
        this.userName = userName;
    }

    // Methods
    public void addProduct(Product product, double amount) {
        boolean foundProduct = false;
        for (AmountOfProduct amountOfProduct : myCart) {
            if (amountOfProduct.getProduct().getName().equals(product.getName())) {
                amountOfProduct.setAmount(amount + amountOfProduct.getAmount());
                foundProduct = true;
                break;
            }
        }
        if (!foundProduct) {
            myCart.add(new AmountOfProduct(product, amount));
        }
    }

    public void removeProduct(String productName) { // Todo: when returning product, make amount positive
        for (AmountOfProduct item : myCart) {
            if (item.getProduct().getName().equals(productName)) {
                item.getProduct().updateAmount(item.getAmount()); // Todo: when returning product, stop printing you can only use numbers
                myCart.remove(item);
            }

        }
    }

    public void showCart() {
        System.out.println("\n" + userName + "'s cart:");
        for (AmountOfProduct item : myCart) {
            System.out.println("Product: " + item.getProduct().getName() + " Cost: " + item.getProduct().getPrice() + " * " + item.getAmount() + " = " + item.getTotalPrice() + " kr");
        }
        System.out.println("Total cost is: " + getTotalCost() + " kr\n");
    }

    public double getTotalCost() {
        double totalCost = 0;
        for (AmountOfProduct item : myCart) {
            totalCost += item.getTotalPrice();
        }
        return totalCost;
    }
    // Getters & setters

    public String getUserName() {
        return userName;
    }
}