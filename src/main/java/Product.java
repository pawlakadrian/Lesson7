import java.math.BigDecimal;

public class Product {
    private String name;
    private BigDecimal price;
    private int amount;

    public Product(String name, BigDecimal price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getTotalPriceProductInCart() {
        return price.multiply(BigDecimal.valueOf(amount));
    }

    public void getTotalInfoAboutCart() {
        System.out.println("Product: " + this.getName() + ", price per item: " + this.getPrice() + ", amount: " + this.getAmount() + ", total price for all items: " + this.getTotalPriceProductInCart());
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}
