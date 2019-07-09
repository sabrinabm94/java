package objectOriented.heritage;

import javaRepositories.Print;

public class View {
    public void print(Geometric geometric) {
        Print.print("\n" + geometric.getName());

        try {
            Print.print("Ray: " + geometric.calculateRay());
        } catch (Exception exception) {
            //Print.print("Error: " + exception.getMessage());
        }

        try {
            Print.print("Circumference: " + geometric.calculateCircumference());
        } catch (Exception exception) {
            //Print.print("Error: " + exception.getMessage());
        }

        try {
            Print.print("Volume: " + geometric.calculateVolume());
        } catch (Exception exception) {
            //Print.print("Error: " + exception.getMessage());
        }
    }
}