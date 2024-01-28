import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// Shop class represents a simple shopping system with user carts and products
public class Shop {
    // Attributes
    private ArrayList<Cart> carts = new ArrayList<>();
    private Cart currentCart;
    private ArrayList<Product> products = new ArrayList<>();

    // Constructor
    public Shop() {
        initializeProducts();
        logInMenu(); // Start the login menu
        shopInterface();
    }

    // Methods

    // Creates the products to the shop
    private void initializeProducts() {
        products.add(new QuantityProduct("egg", 4.45, 200, 0));
        products.add(new QuantityProduct("milk", 15.95, 80, 0));
        products.add(new QuantityProduct("cheese", 45.00, 50, 0));
        products.add(new WeightedProduct("onion", 14.90, 20.00, 0));
        products.add(new WeightedProduct("salad", 35.00, 30.00, 0));
        products.add(new WeightedProduct("carrot", 18.90, 25.00, 0));
    }

    // Handles user login or registration
    private void logInMenu() {
        Scanner scanner = new Scanner(System.in);
        String username;
        System.out.print("Log in with your username\nInput: ");
        username = scanner.nextLine();

        boolean cartExists = findCart(username);

        // If user does not have a cart, create a new one
        if (!cartExists) {
            this.currentCart = new Cart(username);
            carts.add(this.currentCart);
        }
    }

    private boolean findCart(String username) {
        boolean foundCart = false;
        for (Cart cart : carts) {
            if (cart.getUserName().equals(username)) {
                this.currentCart = cart;
                foundCart = true;
                break;
            }
        }
        return foundCart;
    }

    // Displays the main menu options and handles user input
    private void shopInterface() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a number between 1 and 5 followed by enter");
        System.out.println("[1] Add product");
        System.out.println("[2] Remove product");
        System.out.println("[3] Show cart");
        System.out.println("[4] Sign out");
        System.out.println("[5] Exit");
        System.out.print("Input: ");

        int input;
        try {
            input = scanner.nextInt();

            switch (input) {
                case 1 -> addProduct();
                case 2 -> removeProduct();
                case 3 -> this.currentCart.showCart();
                case 4 -> logInMenu();
                case 5 -> System.exit(0);
            }
        } catch (InputMismatchException e) {
            System.out.println("You can only use numbers.\n");
        } catch (Exception e) {
            System.out.println(e + "\n");
        }
        shopInterface(); // Recursive call to keep displaying the menu
    }

    // Displays information about all available products
    private void showAllProducts() {
        System.out.println("\nProducts:");
        for (Product product : products) {
            System.out.println(product.getName() + " Price: " + product.getPrice() + "kr Stock: " + product.getStock());
        }
    }

    // Checks if a product exists in shop based on the user's input
    private Product findProduct(String input) {
        Product selectedProduct = null;
        for (Product product : products) {
            if (product.getName().toLowerCase().equals(input)) {
                selectedProduct = product;
                return selectedProduct;
            }
        }
        System.out.println("Product not found in shop\n");
        return selectedProduct;
    }

    // Adds a selected product to the user's cart
    private void addProduct() { //
        Scanner scanner = new Scanner(System.in);
        String input;

        showAllProducts();
        System.out.print("\nWhich product would you like to add to the cart?\nInput: ");
        input = scanner.nextLine().toLowerCase();
        Product selectedProduct = findProduct(input);

        if (selectedProduct != null) {
            if (!(selectedProduct.getStock() > 0)) {
                System.out.println(selectedProduct.getName() + " is out of stock\n");
                return; // Early return
            }
            // Checks if the product is QuantityProduct or WeightedProduct and handles accordingly
            if (selectedProduct instanceof QuantityProduct) {
                System.out.print("How much " + selectedProduct.getName() + " do you want?\nInput: ");
                int amount = scanner.nextInt();
                this.currentCart.updateCartWithProduct(selectedProduct, amount);
            } else {
                System.out.print("How much " + selectedProduct.getName() + " in kg do you want (i.e. 2,4)?\nInput: ");
                double amount = scanner.nextDouble();
                this.currentCart.updateCartWithProduct(selectedProduct, amount);
            }
        }
    }

    // Removes a product from the user's cart
    private void removeProduct() {
        Scanner scanner = new Scanner(System.in);
        String input;

        if (!this.currentCart.isEmpty()) {
            this.currentCart.showCart();
            System.out.print("Which product would you like to remove from the cart?\nInput: ");
            input = scanner.nextLine().toLowerCase();
            this.currentCart.removeProductFromCart(input);
        } else {
            System.out.println("Cart is empty\n");
        }
    }
}