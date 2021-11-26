import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Product> cart = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int leftAttempts = 5;
        for (int i = 0; i < leftAttempts; i++) {
            System.out.println("Please provide " + (leftAttempts - i) + " name product: ");
            String name = scanner.nextLine();

            System.out.println("Please provide price of product: ");
            BigDecimal price = scanner.nextBigDecimal();

            System.out.println("Please provide amount of product: ");
            int amount = scanner.nextInt();

            if (checkProductIsAllreadyAdded(name, amount)) {
                System.out.println("Product was already added, amount was increased.");
            } else {
                cart.add(new Product(name, price, amount));
            }

            scanner.nextLine();
        }

        for (Product product : cart) {
            product.getTotalInfoAboutCart();
        }

        getTotalAmountOfCard();
    }

    static void getTotalAmountOfCard() {
        BigDecimal totalAmount = BigDecimal.ZERO;

        for (Product p : cart) {
            totalAmount = totalAmount.add(p.getTotalPriceProductInCart());
        }
        System.out.println("Total value of cart: " + totalAmount);
    }

    static boolean checkProductIsAllreadyAdded(String nameProduct, int amount) {
        for (Product c : cart) {
            if (c.getName().contains(nameProduct)) {
                int currentAmount = c.getAmount();
                c.setAmount(currentAmount + amount);
                return true;
            }
        }
        return false;
    }
}
