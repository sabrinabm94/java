package objectOriented.relationship.product;

public class Main {
    public static void main(String[] args) {
        //Product p = new Product();
        //p.setName("Great name");

        DAO dao = new DAO();
        Product product = dao.catchById(1);

        View view = new View();
        view.show(product);
    }
}
