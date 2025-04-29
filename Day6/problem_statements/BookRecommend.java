package problem_statements;

import java.util.*;
import java.util.stream.Collectors;
class Book {
    String title;
    String author;
    String genre;
    double rating;
    Book(String title, String author, String genre, double rating) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.rating = rating;
    }
}
class BookRecommendation {
    String title;
    double rating;
    BookRecommendation(String title, double rating) {
        this.title = title;
        this.rating = rating;
    }
}
public class BookRecommend {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Book> books = new ArrayList<>();
        System.out.print("Enter number of books: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            System.out.println("Enter details for book " + i + ":");
            System.out.print("Title: ");
            String title = scanner.nextLine();
            System.out.print("Author: ");
            String author = scanner.nextLine();
            System.out.print("Genre: ");
            String genre = scanner.nextLine();
            System.out.print("Rating: ");
            double rating = Double.parseDouble(scanner.nextLine());
            books.add(new Book(title, author, genre, rating));
        }
        List<BookRecommendation> recommendations = books.stream()
                .filter(b -> b.genre.equalsIgnoreCase("Science Fiction") && b.rating > 4.0)
                .map(b -> new BookRecommendation(b.title, b.rating))
                .sorted((b1, b2) -> Double.compare(b2.rating, b1.rating))
                .collect(Collectors.toList());
        System.out.print("Enter the page size: ");
        int pageSize = Integer.parseInt(scanner.nextLine());
        int totalPages = (int) Math.ceil(recommendations.size() / (double) pageSize);
        for (int page = 0; page < totalPages; page++) {
            System.out.println("\nPage " + (page + 1) + ":");
            recommendations.stream()
                    .skip(page * pageSize)
                    .limit(pageSize)
                    .forEach(r -> System.out.println(r.title + " - Rating: " + r.rating));
        }
    }
}

