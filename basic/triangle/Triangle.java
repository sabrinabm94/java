package triangle;

import javaRepositories.Print;

public class Triangle {
    public double a;
    public double b;
    public double c;
    public double area;

    public static double calculeArea(Triangle triangle) {
        double perimeter = (triangle.a + triangle.b + triangle.c) / 2.0;
        triangle.area = Math.sqrt(perimeter * (perimeter - triangle.a) * (perimeter - triangle.b) * (perimeter - triangle.c));
        return triangle.area;
    }

    public static void print(Triangle triangle) {
        Print.print("triangle ");
        Print.print("a: " + triangle.a + "\nb: " + triangle.b + "\nc: " + triangle.c + "\nArea: " + triangle.area + "\n");
    }
}
