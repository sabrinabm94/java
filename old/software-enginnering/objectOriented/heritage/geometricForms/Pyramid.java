package objectOriented.heritage.geometricForms;

public class Pyramid extends Geometric {
    private double width;
    private double height;

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return (width * width) / 2;
    }

    @Override
    public double calculateVolume() {
        return ((width * width) * height) / 3;
    }
}
