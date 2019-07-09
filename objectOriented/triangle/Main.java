package objectOriented.triangle;

import java.util.Locale;
import java.util.Scanner;
import javaRepositories.Print;

public class Main {
    public static void main(String[] args) {
        Triangle triangleA = new Triangle();
        triangleA = enterTriangleMensures(triangleA);
        triangleA.calculeArea(triangleA);
        triangleA.print(triangleA);

        Triangle triangleB = new Triangle();
        triangleB = enterTriangleMensures(triangleB);
        triangleB.calculeArea(triangleB);
        triangleB.print(triangleB);
    }

    public static Triangle enterTriangleMensures(Triangle triangle) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        Print.print("\nEnter with the mensure of a triangule: ");
        Print.print("Mensure of face a: ");
        triangle.a = scanner.nextDouble();
        Print.print("Mensure of face b: ");
        triangle.b = scanner.nextDouble();
        Print.print("Mensure of face c: ");
        triangle.c = scanner.nextDouble();

        return triangle;
    }
}
