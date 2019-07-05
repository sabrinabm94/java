package objectOriented.heritage;

public class Pyramid extends Geometric {
    private double lado;
    private double height;

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double calculateVolume() {
        return ((lado * lado) * height) / 3;
    }
}
