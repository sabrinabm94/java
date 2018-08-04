package trabalho;

public class Main {
	public static void main(String[] args) {
		Geometric geometric = new Geometric();
		GeometricView view = new GeometricView();
		Cube cube = new Cube();
		Cylinder cylinder = new Cylinder();
		Pyramid pyramid = new Pyramid();
		
		geometric.setName("Geometric form");
		
		cube.setName("Cube");
		cube.setHeight(2);
		cube.setLenght(2);
		cube.setWidth(2);
		
		cylinder.setName("Cylinder");
		cylinder.setHeight(2);
		cylinder.setDiameter(4);
		
		pyramid.setName("Pyramid");
		pyramid.setHeight(2);
		pyramid.setLado(2);
		
		view.showValue(geometric);
		view.showValue(cube);
		view.showValue(cylinder);
		view.showValue(pyramid);
		
	}
}
