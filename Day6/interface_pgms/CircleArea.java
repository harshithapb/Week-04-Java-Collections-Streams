package interface_pgms;

import java.util.Scanner;
import java.util.function.Function;
public class CircleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter radius: ");
        double radius = scanner.nextDouble();
        Function<Double, Double> areaFunction = r -> Math.PI * r * r;
        double area = areaFunction.apply(radius);
        System.out.println("Area of circle: " + area);
    }
}
