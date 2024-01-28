import java.util.ArrayList;
import java.util.Iterator;

// Represents a shopping cart associated with a user
public class Cart {
    // Attributes
    private ArrayList<AmountOfProduct> myCart = new ArrayList<>();
    private String userName; // User associated with the cart

    // Constructor to create a new cart for a specific user
    public Cart(String userName) {
        this.userName = userName;
    }

    // Methods

    // Adds a product to the cart or updates the quantity if the product is already in the cart
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

    // Removes a product from the cart
    public void removeProduct(String productName) {
        Iterator<AmountOfProduct> iterator = myCart.iterator();

        while (iterator.hasNext()) {
            AmountOfProduct item = iterator.next();

            if (item.getProduct().getName().equals(productName)) {
                item.getProduct().updateAmount(-item.getAmount());
                iterator.remove(); // Use iterator to safely remove the item
                System.out.println(productName + " removed from cart\n");
                break; // Break to stop further iterations
            }
        }
    }

    // Displays the contents of the cart
    public void showCart() {
        if (!myCart.isEmpty()) {
            System.out.println("\n" + userName + "'s cart:");
            for (AmountOfProduct item : myCart) {
                System.out.println(item.getProduct().getName() + " " + item.getProduct().getPrice() + " " + item.getProduct().getAmountType() + " * " + item.getAmount() + " = " + item.getTotalPrice() + " kr");
            }
            System.out.println("Total cost is: " + getTotalCost() + " kr\n");
        } else {
            System.out.println("Cart is empty");
        }
    }

    // Checks if cart is empty
    public Boolean isEmpty() {
        return myCart.isEmpty();
    }

    // Calculates and returns the total cost of all items in the cart
    public double getTotalCost() {
        double totalCost = 0;
        for (AmountOfProduct item : myCart) {
            totalCost += item.getTotalPrice();
        }
        return totalCost;
    }
    // Getters & setters

    // Returns the username associated with the cart
    public String getUserName() {
        return userName;
    }
}