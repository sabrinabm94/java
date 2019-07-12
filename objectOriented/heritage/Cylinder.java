package objectOriented.heritage;

public class Cylinder extends Geometric {
    private double pi = Math.PI;
    private double height;
    private double diameter;
    private double radius;

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
        this.radius = this.diameter / 2;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    //circle base area
    public double calculateArea() {
        return pi * radius * radius;
    }

    @Override
    public double calculateVolume() {
        return calculateArea() * height;
    }
}
