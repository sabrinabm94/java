package relationship;

public class ProductView {	
	public void show(Product product) {
		System.out.println("|-----------------|");
		System.out.println("|---- Product ----|");
		System.out.println("|-----------------|");
		System.out.println("|---- " + product.getName() + " ----|");
		System.out.println("|-----------------|");
		System.out.println("|-----------------|");
	}
}
