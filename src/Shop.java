import java.util.Scanner;

public class Shop {
    private static Cart cart;

    public Shop() {
        Product egg = new QuantityProduct("egg", 4.45, 100, 0);
        Product milk = new QuantityProduct("milk", 15.95, 30, 0);
        Product cheese = new QuantityProduct("cheese", 89.00, 25, 0);
        Product onion = new WeightedProduct("onion", 14.90, 20.00, 0);
        Product salad = new WeightedProduct("salad", 35.00, 15.00, 0);
        Product carrot = new WeightedProduct("carrot", 18.90, 10.00, 0);

        Cart.products = new Product[]{egg, milk, cheese, onion, salad, carrot};
        cart = new Cart();
        menu();
    }

    public static void menu() {
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
                case 3 -> cart.showCart();
                case 4 -> System.exit(0);
            }
        } catch (Exception e) {
            System.out.println("\nYou can only use numbers.\n");
        }
        menu();
    }

    private static void showAllProducts() {
        System.out.println("\nProducts:");
        for (Product product : Cart.products) {
            System.out.println(product.getName() + " Price: " + product.getPrice() + "kr Stock: " + product.getStock());
        }
    }

    private static Product findProduct(String input) {
        Product selectedProduct = null;
        for (Product product : Cart.products) {
            if (product.getName().toLowerCase().equals(input)) {
                selectedProduct = product;
                break;
            }
        }
        return selectedProduct;
    }

    private static void addProduct() {
        Scanner scanner = new Scanner(System.in);
        String input;

        showAllProducts();
        System.out.print("\nWhich product would you like to add to the cart?\nInput: ");
        input = scanner.nextLine().toLowerCase();
        Product selectedProduct = findProduct(input);

        if (selectedProduct != null) {
            if (selectedProduct instanceof QuantityProduct) { // Todo: decrease stock
                System.out.print("How much " + selectedProduct.getName() + " do you want?\nInput: ");
                int amount = scanner.nextInt();

                if (amount > selectedProduct.getStock()) {
                    amount = (int) selectedProduct.getStock();
                    System.out.println("There is only " + amount + " " + selectedProduct.getName() + " in stock");
                }
                selectedProduct.setStock(selectedProduct.getStock() - amount);
                ((QuantityProduct) selectedProduct).setAmount(amount);
                cart.addProduct(selectedProduct);
                System.out.println(amount + " " + selectedProduct.getName() + " added to cart.");
            } else {
                System.out.print("How much " + selectedProduct.getName() + " in kg do you want?\nInput: ");
                double amount = scanner.nextDouble();

                if (amount > selectedProduct.getStock()) {
                    amount = selectedProduct.getStock();
                    System.out.println("There is only " + amount + " kg " + selectedProduct.getName() + " in stock");
                }
                selectedProduct.setStock(selectedProduct.getStock() - amount);
                ((WeightedProduct) selectedProduct).setAmount(amount);
                cart.addProduct(selectedProduct);
                System.out.println(amount + " kg " + selectedProduct.getName() + " added to cart.");
            }
        } else {
            System.out.println("Product not found.");
        }
    }

    private static void removeProduct() {
        Scanner scanner = new Scanner(System.in);
        String input;

        cart.showCart();
        System.out.print("Which product would you like to remove from the cart?\nInput: ");
        input = scanner.nextLine().toLowerCase();
        Product selectedProduct = findProduct(input);

        if (selectedProduct != null) {
            cart.removeProduct(selectedProduct);
            System.out.println(selectedProduct.getName() + " was removed from the cart.");
        } else {
            System.out.println("Product not found.");
        }
    }
}