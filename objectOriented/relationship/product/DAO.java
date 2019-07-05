package objectOriented.relationship.product;

public class DAO {
    public Product catchById(long id) {
        Product product = new Product();
        product.setName("Great name");
        return product;
    }
}
