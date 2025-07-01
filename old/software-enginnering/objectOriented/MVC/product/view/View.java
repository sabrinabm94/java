package objectOriented.MVC.product.view;

import javaRepositories.Print;
import objectOriented.MVC.product.model.Product;

public class View {
    public void show(Product product) {
        Print.println("|-----------------------|");
        Print.println("|------- Product -------|");
        Print.println("|-----------------------|");
        Print.println("|------ " + product.getName() + " -----|");
        Print.println("|-----------------------|");
        Print.println("|-----------------------|");
    }
}
