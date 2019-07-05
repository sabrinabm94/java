package objectOriented.relationship.product;

import javaRepositories.Print;

public class View {
    public void show(Product product) {
        Print.print("|--------------------|");
        Print.print("|----- Product ------|");
        Print.print("|--------------------|");
        Print.print("|------ " + product.getName() + " -----|");
        Print.print("|--------------------|");
        Print.print("|--------------------|");
    }
}
