package objectOriented.MVC.product.model.dao;

import objectOriented.MVC.product.model.Product;

public class DAO {
    public Product createDefaultProduct() {
        Product product = new Product();
        product.setName("Great product");
        return product;
    }
}
