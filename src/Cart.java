import java.util.ArrayList;

public class Cart {
    // Attributes
    private ArrayList<Product> myCart = new ArrayList<>();
    public static Product[] products; // This is chooseable products

    // Constructors
    public Cart() {
    }

    public void addProduct(Product product) {
        myCart.add(product);
    }

    public void removeProduct(Product product) {
        myCart.remove(product);
    }

    public int getNumberOfProducts() {
        return myCart.size();
    }

    public double getTotalCost() {
        double totalCost = 0;
        for (Product product : myCart) {
            totalCost += product.getTotalPrice();
        }
        return totalCost;
    }

    public void showCart() {
        System.out.println("\nCart Contents:");
        for (Product product : myCart) {
            double productTotalCost = product.getTotalPrice();
            System.out.println("Product: " + product.getName() + " Cost: " + product.getPrice() + " * " + product.getAmount() + " = " + productTotalCost + " kr");
        }
        System.out.println("Total cost is: " + getTotalCost() + " kr\n");
    }
}