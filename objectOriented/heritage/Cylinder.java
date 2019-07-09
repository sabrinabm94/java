package objectOriented.heritage;

public class Cylinder extends Geometric {
    private double height;
    private double diameter;

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
    }

    @Override
    public double calculateVolume() {
        return PI * height * (calculateRay() * calculateRay());
    }
}
