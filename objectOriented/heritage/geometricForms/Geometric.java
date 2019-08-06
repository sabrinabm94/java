package objectOriented.heritage.geometricForms;

public abstract class Geometric {
    private String name;
    private Color color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Geometric() {
        super();
    }

    public Geometric(String name, Color color) {
        super();
        this.name = name;
        this.color = color;
    }

    //método abstrato
    public abstract double calculateArea();

    public double calculateVolume() {
        return 0;
    }
}
