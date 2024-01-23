import java.util.ArrayList;
import java.util.Scanner;

// Shop class represents a simple shopping system with user carts and products
public class Shop {
    // Attributes
    private ArrayList<Cart> carts = new ArrayList<>();
    private Cart currentCart;
    private static ArrayList<Product> products = new ArrayList<>();

    // Constructor
    public Shop() {
        initializeProducts();
        logInMenu(); // Start the login menu
    }

    // Methods

    // Creates the products to the shop
    private void initializeProducts() {
        Product egg = new QuantityProduct("egg", 4.45, 200, 0); // Todo: should I keep amount?
        Product milk = new QuantityProduct("milk", 15.95, 80, 0);
        Product cheese = new QuantityProduct("cheese", 45.00, 50, 0);
        Product onion = new WeightedProduct("onion", 14.90, 20.00, 0);
        Product salad = new WeightedProduct("salad", 35.00, 30.00, 0);
        Product carrot = new WeightedProduct("carrot", 18.90, 25.00, 0);
        products.add(egg);
        products.add(milk);
        products.add(cheese);
        products.add(onion);
        products.add(salad);
        products.add(carrot);
    }

    // Handles user login or registration
    public void logInMenu() {
        Scanner scanner = new Scanner(System.in);
        String username;
        System.out.print("Log in with your username\nInput: ");
        username = scanner.nextLine();

        boolean foundCart = false;
        for (Cart cart : carts) {
            if (cart.getUserName().equals(username)) {
                this.currentCart = cart;
                foundCart = true;
                break;
            }
        }
        // If user doesn't have a cart, create a new one
        if (!foundCart) {
            this.currentCart = new Cart(username);
            carts.add(this.currentCart);
        }
        menu(); // Proceed to the main menu
    }

    // Displays the main menu options and handles user input
    public void menu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a number between 1 and 4 followed by enter.");
        System.out.println("[1] Add product");
        System.out.println("[2] Remove product");
        System.out.println("[3] Show cart");
        System.out.println("[4] Sign out");
        System.out.print("Input: ");

        int input;
        try {
            input = scanner.nextInt();

            switch (input) {
                case 1 -> addProduct();
                case 2 -> removeProduct();
                case 3 -> this.currentCart.showCart();
                case 4 -> logInMenu();
            }
        } catch (Exception e) {
            System.out.println("\nYou can only use numbers.\n");
        }
        menu(); // Recursive call to keep displaying the menu
    }

    // Displays information about all available products
    private void showAllProducts() {
        System.out.println("\nProducts:");
        for (Product product : products) {
            if (product.getStock() != 0)
                System.out.println(product.getName() + " Price: " + product.getPrice() + "kr Stock: " + product.getStock());
        }
    }

    // Checks if a product exists based on the user's input
    private Product findProduct(String input) {
        Product selectedProduct = null;
        for (Product product : products) {
            if (product.getName().toLowerCase().equals(input)) {
                selectedProduct = product;
                break;
            }
        }
        return selectedProduct;
    }

    // Adds a selected product to the user's cart
    private void addProduct() {
        Scanner scanner = new Scanner(System.in);
        String input;

        showAllProducts();
        System.out.print("\nWhich product would you like to add to the cart?\nInput: ");
        input = scanner.nextLine().toLowerCase();
        Product selectedProduct = findProduct(input);

        if (selectedProduct != null) {
            // Check if the product is QuantityProduct or WeightedProduct and handle accordingly
            if (selectedProduct instanceof QuantityProduct) { //
                System.out.print("How much " + selectedProduct.getName() + " do you want?\nInput: ");
                int amount = scanner.nextInt();

                if (amount > selectedProduct.getStock()) {
                    amount = (int) selectedProduct.getStock();
                    System.out.println("There is only " + amount + " " + selectedProduct.getName() + " in stock");
                }
                ((QuantityProduct) selectedProduct).updateAmount(amount);
                this.currentCart.addProduct(selectedProduct, amount);
                System.out.println(amount + " " + selectedProduct.getName() + " added to cart.\n");
            } else {
                System.out.print("How much " + selectedProduct.getName() + " in kg do you want?\nInput: ");
                double amount = scanner.nextDouble();

                if (amount > selectedProduct.getStock()) {
                    amount = selectedProduct.getStock();
                    System.out.println("There is only " + amount + " kg " + selectedProduct.getName() + " in stock");
                }
                ((WeightedProduct) selectedProduct).updateAmount(amount);
                this.currentCart.addProduct(selectedProduct, amount);
                System.out.println(amount + " kg " + selectedProduct.getName() + " added to cart.\n");
            }
        } else {
            System.out.println("Product not found.");
        }
    }

    // Removes a product from the user's cart
    private void removeProduct() {
        Scanner scanner = new Scanner(System.in);
        String input;

        this.currentCart.showCart();
        System.out.print("Which product would you like to remove from the cart?\nInput: ");
        input = scanner.nextLine().toLowerCase();
        this.currentCart.removeProduct(input);
    }
}