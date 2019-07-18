package objectOriented.geometricForms;

public class Circle extends Geometric {
    private double pi = Math.PI;
    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Circle() {
        super();
    }

    public Circle(double radius) {
        super();
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return pi * (radius * radius);
    }

    @Override
    public double calculateVolume() {
        return (4 * pi * (radius * radius * radius)) / 3;
    }

    public double calculateCircumference() {
        return 2.0 * pi * radius;
    }
}
