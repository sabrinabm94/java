//controller

package relationship;

public class Main {
	public static void main(String[] args) {
		//Product p = new Product();
		//p.setName("Great name");
		
		ProductDAO dao = new ProductDAO();		
		Product p = dao.catchById(1);
		
		ProductView view = new ProductView();
		view.show(p);
	}
}
