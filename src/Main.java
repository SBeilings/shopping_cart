import java.util.*;

public class Main {
    public static void main(String[] args) {
        Answer.Cart cart = new Answer.Cart();
        cart.addItem(ProductType.PANTS, 2, 16.99);
        cart.addItem(ProductType.SHIRT, 3, 11.99);
        System.out.println(cart.getTotal());

    }
}

class Answer {
    static class Cart {
        List<Product> items = new ArrayList<>();

        void addItem(ProductType productType, int quantity, double price) {
            items.add(new Product(productType, quantity, price));
        }

        double getTotal() {
            Iterator<Product> iterator = items.iterator();
            double total = 0;
            while (iterator.hasNext()){
                Product value = iterator.next();
                int quantity = value.getQuantity();
                double price = value.getPrice();
                double productPrice = quantity * price;
                total += productPrice;
                System.out.println(total);
            }
            return total;
        }
    }

}

class Product {
    private final ProductType productType;
    private final int quantity;
    private final double price;

    public Product(ProductType productType, int quantity, double price) {
        this.productType = productType;
        this.quantity = quantity;
        this.price = price;
    }

    public ProductType getProductType() {
        return productType;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s, quantity: %d, price: %.2f", productType, quantity, price);
    }
}

enum ProductType {
    SOCKS, SHIRT, PANTS
}
