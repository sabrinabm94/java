package objectOriented.heritage;

import javaRepositories.Print;

public class Main {
    public static void main(String[] args) {
        //Geometric geometric = new Geometric();
        Cube cube = new Cube();
        Cylinder cylinder = new Cylinder();
        Pyramid pyramid = new Pyramid();
        Circle circle = new Circle();

        cube.setName("Cube");
        cube.setHeight(2.0);
        cube.setLenght(2.0);
        cube.setWidth(2.0);
        Print.print("\n" + cube.getName());
        Print.print("Area: " + cube.calculateArea());
        Print.print("Volum: " + cube.calculateVolume());

        cylinder.setName("Cylinder");
        cylinder.setHeight(2.0);
        cylinder.setDiameter(4.0);
        Print.print("\n" + cylinder.getName());
        Print.print("Area: " + cylinder.calculateArea());
        Print.print("Volum: " + cylinder.calculateVolume());

        pyramid.setName("Pyramid");
        pyramid.setHeight(2.0);
        pyramid.setWidth(2.0);
        Print.print("\n" + pyramid.getName());
        Print.print("Area: " + pyramid.calculateArea());
        Print.print("Volum: " + pyramid.calculateVolume());

        circle.setName("Circle");
        circle.setRadius(3.0);
        Print.print("\n" + circle.getName());
        Print.print("Area: " + circle.calculateArea());
        Print.print("Volum: " + circle.calculateVolume());
        Print.print("Circumference: " + circle.calculateVolume());
    }
}
