package objectOriented.products;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Locale;
import javaRepositories.Print;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        String[] productData = new String[3];

        //create product
        productData = enterProductData(scanner, productData);
        Product product = new Product(productData[0], Double.valueOf(productData[1]), Integer.valueOf(productData[2]));
        printProduct(product);

        int quantity = enterProductQuantity(scanner);
        //add
        addProductQuantity(product, quantity);
        printProduct(product);

        //remove
        removeProductQuantity(product, quantity);
        printProduct(product);
    }

    public static String[] enterProductData(Scanner scanner, String[] productData) {
        Print.print("\nEnter with the product data ");
        Print.print("Name: ");
        productData[0] = scanner.nextLine();

        Print.print("Price: ");
        productData[1] = String.valueOf(scanner.nextDouble());

        Print.print("Quantity: ");
        productData[2] = String.valueOf(scanner.nextInt());

        return productData;
    }

    public static void printProduct(Product product) {
        Print.print("\nName: " + product.getName() + "\nPrice: $" + product.getPrice() + "\nQuantity: " + product.getQuantity() + " units");
    }

    public static int enterProductQuantity(Scanner scanner) {
        Print.print("\nEnter with the quantity value: ");

        return scanner.nextInt();
    }

    public static Product addProductQuantity(Product product, int quantity) {
        Print.print("\nAdditing " + quantity + " units from product");
        quantity = product.getQuantity() + quantity;
        product.setQuantity(quantity);

        return product;
    }

    public static Product removeProductQuantity(Product product, int quantity) {
        Print.print("\nRemoving " + quantity + " units from product");
        quantity = product.getQuantity() - quantity;
        product.setQuantity(quantity);

        return product;
    }
}
