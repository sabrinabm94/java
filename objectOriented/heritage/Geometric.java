package objectOriented.heritage;

public class Geometric {
    public final double PI = 3.14159;
    private String name;
    public Double diameter;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(Double diameter) {
        this.diameter = diameter;
    }

    public double calculateVolume() {
        return 0;
    }

    public double calculateRay() {
        return getDiameter() / 2;
    }

    public double calculateCircumference() {
        return 2.0 * PI * calculateRay();
    }
}
