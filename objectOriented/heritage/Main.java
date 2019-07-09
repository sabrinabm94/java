package objectOriented.heritage;

public class Main {
    public static void main(String[] args) {
        Geometric geometric = new Geometric();
        View view = new View();
        Cube cube = new Cube();
        Cylinder cylinder = new Cylinder();
        Pyramid pyramid = new Pyramid();

        geometric.setName("Geometric form");
        cube.setName("Cube");
        cube.setHeight(2.0);
        cube.setLenght(2.0);
        cube.setWidth(2.0);
        view.print(cube);

        cylinder.setName("Cylinder");
        cylinder.setHeight(2.0);
        geometric.setDiameter(4.0);
        cylinder.setDiameter(4.0);
        view.print(cylinder);

        pyramid.setName("Pyramid");
        pyramid.setHeight(2.0);
        pyramid.setFace(2.0);
        view.print(pyramid);
    }
}
