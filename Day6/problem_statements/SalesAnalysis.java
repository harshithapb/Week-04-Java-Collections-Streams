package problem_statements;

import java.util.*;
import java.util.stream.Collectors;
class Sale {
    String productId;
    int quantity;
    double price;
    public Sale(String productId, int quantity, double price) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }
    public String getProductId() {
        return productId;
    }
    public int getQuantity() {
        return quantity;
    }
    public double getPrice() {
        return price;
    }
}
class ProductSales {
    String productId;
    double totalRevenue;
    public ProductSales(String productId, double totalRevenue) {
        this.productId = productId;
        this.totalRevenue = totalRevenue;
    }
    public String getProductId() {
        return productId;
    }
    public double getTotalRevenue() {
        return totalRevenue;
    }
    public String toString() {
        return productId + " - $" + totalRevenue;
    }
}
public class SalesAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Sale> sales = new ArrayList<>();
        System.out.print("Enter number of sales records: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for sale " + (i + 1) + ":");
            System.out.print("Product ID: ");
            String productId = scanner.nextLine();
            System.out.print("Quantity: ");
            int quantity = Integer.parseInt(scanner.nextLine());
            System.out.print("Price: ");
            double price = Double.parseDouble(scanner.nextLine());
            sales.add(new Sale(productId, quantity, price));
        }
        List<ProductSales> topProducts = sales.stream()
                .filter(s -> s.getQuantity() > 10)
                .collect(Collectors.groupingBy(Sale::getProductId,
                        Collectors.summingDouble(s -> s.getQuantity() * s.getPrice())))
                .entrySet().stream()
                .map(e -> new ProductSales(e.getKey(), e.getValue()))
                .sorted(Comparator.comparingDouble(ProductSales::getTotalRevenue).reversed())
                .limit(5)
                .collect(Collectors.toList());
        System.out.println("\nTop 5 Products by Total Revenue (quantity > 10):");
        if (topProducts.isEmpty()) {
            System.out.println("No products matched the criteria.");
        } else {
            topProducts.forEach(System.out::println);
        }
    }
}
