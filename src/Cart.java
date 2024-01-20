import java.util.ArrayList;

public class Cart {
    public static Product[] products;
    private ArrayList<Product> cartProducts = new ArrayList<>();
    private double totalCost = 0.0;

    public Cart() {
    }

    public void addProduct(Product product, double amount) {
        // Handles different product types
        if (product instanceof Dairy dairyProduct) {
            totalCost += dairyProduct.calculateCost(amount);

        } else {
            Vegetable vegetableProduct = (Vegetable) product;
            totalCost += vegetableProduct.calculateCost(amount);
        }
        cartProducts.add(product);
    }

    public void removeProduct(Product product) {
        if (product instanceof Dairy dairyProduct) {
            totalCost -= dairyProduct.calculateCost(amount);

        } else {
            Vegetable vegetableProduct = (Vegetable) product;
            totalCost += vegetableProduct.calculateCost(amount);
        }
        cartProducts.add(product);
    }

    public void showCart() {
        System.out.println("\nCart Contents:");
        for (Product product : cartProducts) {
            System.out.println(product.name + " " + product.price); // Todo: print quantity/weight
        }
        System.out.println("Total cost is: " + totalCost + " kr\n"); // Todo: fix calculatePrice method
    }
}