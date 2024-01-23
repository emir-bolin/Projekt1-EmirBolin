public class AmountOfProduct {
    // Attributes
    private Product product;
    private double amount;

    // Constructor
    public AmountOfProduct() {
    }

    public AmountOfProduct(Product product, double amount) {
        this.product = product;
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getTotalPrice() {
        return (double) (Math.round(product.getPrice() * getAmount() * 100)) / 100;
    }
}
