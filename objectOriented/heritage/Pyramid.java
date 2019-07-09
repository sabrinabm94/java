package objectOriented.heritage;

public class Pyramid extends Geometric {
    private double face;
    private double height;

    public double getFace() {
        return face;
    }

    public void setFace(double face) {
        this.face = face;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double calculateVolume() {
        return ((face * face) * height) / 3;
    }
}
