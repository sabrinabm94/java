package objectOriented.heritage;

import javaRepositories.Print;

public class GeometricView {
    public void showValue(Geometric geometric) {
        Print.print(geometric.getName());
        Print.print("Volume: " + geometric.calculateVolume() + "\n");
    }
}