import java.util.Scanner;

public class Shop {
    private static Cart cart;

    public Shop() {
        cart = new Cart();
        Product egg = new Dairy("egg", 6.45, 100);
        Product milk = new Dairy("milk", 15.95, 30);
        Product cheese = new Dairy("cheese", 89.00, 25);
        Product onion = new Vegetable("onion", 14.90, 20);
        Product salad = new Vegetable("salad", 35.00, 15);
        Product carrot = new Vegetable("carrot", 18.90, 10);

        Cart.products = new Product[]{egg, milk, cheese, onion, salad, carrot};
        menu();
    }

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        boolean wantsToExit = false;

        while (!wantsToExit) {
            System.out.println("Choose a number between 1 and 4 followed by enter.");
            System.out.println("[1] Add product");
            System.out.println("[2] Remove product");
            System.out.println("[3] Show cart");
            System.out.println("[4] Exit");
            System.out.print("Input: ");

            int input;
            try {
                input = scanner.nextInt(); // Todo: stop infinite loop when wrong input is typed in

                switch (input) {
                    case 1 -> addProduct();
                    // case 2 -> removeProduct();
                    case 3 -> cart.showCart();
                    case 4 -> wantsToExit = true;
                }
            } catch (Exception e) {
                System.out.println("\nYou can only use numbers.\n");
            }
        }
    }

    private static void showAllProducts() {
        System.out.println("\nDairy products:");
        for (Product product : Cart.products) {
            if (product.getName().equals("onion")
                System.out.println("\nVegetables:");
            System.out.println(product.getName() + " " + product.getPrice() + "kr"); // Todo: print quantity/weight
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
            System.out.print("How much would you like in quantity or weight?\nInput: ");
            double amount = scanner.nextDouble();

            cart.addProduct(selectedProduct, amount);
            System.out.println(selectedProduct.getName() + " was added to the cart.");
        } else {
            System.out.println("Product not found.");
        }
    }

    private static void removeProduct() {
        Scanner scanner = new Scanner(System.in);
        String input;

        cart.showCart();
        System.out.print("\nWhich product would you like to remove from the cart?\nInput: ");
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
