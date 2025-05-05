package shopping;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class ShoppingCart {

    private Map<String, Double> productPrices = new HashMap<>();
    private Map<String, Integer> cartItems = new LinkedHashMap<>(); // Item -> Quantity (maintains insertion order)

    public void addProductPrice(String product, double price) {
        productPrices.put(product, price);
    }

    public void addItem(String product) {
        cartItems.put(product, cartItems.getOrDefault(product, 0) + 1);
    }

    public void removeItem(String product) {
        if (cartItems.containsKey(product)) {
            cartItems.put(product, cartItems.get(product) - 1);
            if (cartItems.get(product) <= 0) {
                cartItems.remove(product);
            }
        }
    }

    public Map<String, Integer> getCartItemsOrdered() {
        return new LinkedHashMap<>(cartItems); // Return a copy to maintain order
    }

    public double getTotalPrice() {
        double total = 0;
        for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
            String product = entry.getKey();
            int quantity = entry.getValue();
            if (productPrices.containsKey(product)) {
                total += productPrices.get(product) * quantity;
            } else {
                System.out.println("Warning: Price not found for " + product);
            }
        }
        return total;
    }

    public void displayCartByInsertionOrder() {
        System.out.println("--- Shopping Cart (Insertion Order) ---");
        for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
            String product = entry.getKey();
            int quantity = entry.getValue();
            double price = productPrices.getOrDefault(product, 0.0);
            System.out.println(product + " (Quantity: " + quantity + ", Price: $" + price + ")");
        }
        System.out.println("Total: $" + getTotalPrice());
    }

    public void displayCartSortedByPrice() {
        // Use TreeMap with a custom comparator to sort items by price
        TreeMap<String, Integer> sortedCartByPrice = new TreeMap<>(Comparator.comparing(productPrices::get));

        // Populate the TreeMap with cart items
        for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
            sortedCartByPrice.put(entry.getKey(), entry.getValue());
        }

        System.out.println("\n--- Shopping Cart (Sorted by Price) ---");
        for (Map.Entry<String, Integer> entry : sortedCartByPrice.entrySet()) {
            String product = entry.getKey();
            int quantity = entry.getValue();
            double price = productPrices.getOrDefault(product, 0.0);
            System.out.println(product + " (Price: $" + price + ", Quantity: " + quantity + ")");
        }
        System.out.println("Total: $" + getTotalPrice());
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Add product prices
        cart.addProductPrice("Laptop", 1200.00);
        cart.addProductPrice("Mouse", 25.00);
        cart.addProductPrice("Keyboard", 75.00);
        cart.addProductPrice("Monitor", 300.00);

        // Add items to the cart
        cart.addItem("Laptop");
        cart.addItem("Mouse");
        cart.addItem("Keyboard");
        cart.addItem("Laptop"); // Adding again to increase quantity
        cart.addItem("Monitor");
        cart.addItem("Mouse"); // Adding again

        cart.displayCartByInsertionOrder();
        cart.displayCartSortedByPrice();

        System.out.println("\nRemoving one Mouse...");
        cart.removeItem("Mouse");
        cart.displayCartByInsertionOrder();
        cart.displayCartSortedByPrice();

        System.out.println("\nRemoving all Laptops...");
        cart.removeItem("Laptop");
        cart.removeItem("Laptop");
        cart.displayCartByInsertionOrder();
        cart.displayCartSortedByPrice();
    }
}
