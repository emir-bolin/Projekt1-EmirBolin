import java.util.ArrayList;
import java.util.Iterator;

// Represents a shopping cart associated with a user
public class Cart {
    // Attributes
    private ArrayList<CartProduct> myCart = new ArrayList<>();
    private String userName; // User associated with the cart

    // Constructor to create a new cart for a specific user
    public Cart(String userName) {
        this.userName = userName;
    }

    // Methods

    // Entry point for updating the cart
    public void updateCartWithProduct(Product selectedProduct, double amount) {
        if (amount > 0) { // only numbers greater than 0 is allowed
            if (!selectedProduct.isInStock(amount)) {
                amount = selectedProduct.getStock(); // Decrease number of added products to correspond a stock
            }
            selectedProduct.updateAmount(amount);
            this.addProductToCart(selectedProduct, amount);
        } else {
            System.out.println("Only numbers greater than 0 is allowed");
        }
    }

    // Adds a product to the cart or updates the quantity if the product is already in the cart
    private void addProductToCart(Product product, double amount) { // Private because it is used from updateCart()
        boolean foundProduct = false;
        for (CartProduct cartProduct : myCart) {
            if (cartProduct.getProduct().getName().equals(product.getName())) {
                cartProduct.setAmount(amount + cartProduct.getAmount());
                foundProduct = true;
                break;
            }
        }
        if (!foundProduct) {
            myCart.add(new CartProduct(product, amount));
        }
        if (amount > 0)
            System.out.println(amount + product.getAmountType() + product.getName() + " added to cart.\n"); // Todo: make it integer
    }

    // Removes a product from the cart
    public void removeProductFromCart(String productName) {
        Iterator<CartProduct> iterator = myCart.iterator();

        while (iterator.hasNext()) {
            CartProduct item = iterator.next();

            if (item.getProduct().getName().equals(productName)) {
                item.getProduct().updateAmount(-item.getAmount());
                iterator.remove(); // Use iterator to safely remove the item
                System.out.println(productName + " removed from cart\n");
                return;
            }
        }
        System.out.println(productName + " is not in cart\n");

    }

    // Displays the contents of the cart
    public void showCart() {
        if (!myCart.isEmpty()) {
            System.out.println("\n" + userName + "'s cart:");
            for (CartProduct item : myCart) {
                System.out.println(item.getProduct().getName() + " " + item.getProduct().getPrice() + " kr * " + item.getAmount() + item.getProduct().getAmountType() + "= " + item.getTotalPrice() + " kr");
            }
            System.out.println("Total cost is: " + getTotalCost() + " kr\n");
        } else {
            System.out.println("Cart is empty\n");
        }
    }

    // Checks if cart is empty
    public Boolean isEmpty() {
        return myCart.isEmpty();
    }

    // Calculates and returns the total cost of all items in the cart
    private double getTotalCost() {
        double totalCost = 0;
        for (CartProduct item : myCart) {
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