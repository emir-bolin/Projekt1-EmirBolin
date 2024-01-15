import java.util.Scanner;

public class Shop {

    // Constructors
    public Shop() {
        Menu();
    }

    Product milk = new Dairy("milk", 15.95, 30);
    Product cheese = new Dairy("cheese", 89.00, 25);
    Product egg = new Dairy("egg", 6.45, 100);
    Product carrot = new Vegetable("carrot", 18.90, 10);
    Product onion = new Vegetable("onion", 14.90, 20);
    Product salad = new Vegetable("salad", 35.00, 15);

    public void Menu() {
        Scanner scanner = new Scanner(System.in);
        boolean wantsToExit = false;

        while (!wantsToExit) {
            System.out.println("Choose a number between 1 and 4 followed by enter.");
            System.out.println("[1] Add product");
            System.out.println("[2] Remove product");
            System.out.println("[3] Show cart");
            System.out.println("[4] Exit");

            int input;
            try {
                input = scanner.nextInt();

                switch (input) {
                    case 1 -> AddProduct();
                    case 2 -> RemoveProduct();
                    case 3 -> ShowCart();
                    case 4 -> wantsToExit = true;
                }
            } catch (Exception e) {
                System.out.println("You can only use numbers.");
            }
        }
    }

}
