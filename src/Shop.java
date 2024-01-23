import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
    // Attributes
    private ArrayList<Cart> carts = new ArrayList<>();
    private Cart currentCart;
    private static ArrayList<Product> products = new ArrayList<>();

    // Constructors
    public Shop() {
        Product egg = new QuantityProduct("egg", 4.45, 200, 0);
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

        logInMenu();

    }

    // Methods
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
        if (!foundCart) {
            this.currentCart = new Cart(username);
            carts.add(this.currentCart);
        }
        menu();
    }

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
        menu();
    }

    private void showAllProducts() {
        System.out.println("\nProducts:");
        for (Product product : products) {
            if (product.getStock() != 0)
                System.out.println(product.getName() + " Price: " + product.getPrice() + "kr Stock: " + product.getStock());
        }
    }

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

    private void addProduct() {
        Scanner scanner = new Scanner(System.in);
        String input;

        showAllProducts();
        System.out.print("\nWhich product would you like to add to the cart?\nInput: ");
        input = scanner.nextLine().toLowerCase();
        Product selectedProduct = findProduct(input);

        if (selectedProduct != null) {
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

    private void removeProduct() {
        Scanner scanner = new Scanner(System.in);
        String input;

        this.currentCart.showCart();
        System.out.print("Which product would you like to remove from the cart?\nInput: ");
        input = scanner.nextLine().toLowerCase();
        this.currentCart.removeProduct(input);
    }
}