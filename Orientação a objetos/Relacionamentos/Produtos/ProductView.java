//é responsável por exibir os dados na tela
//ligado a classe produto pois o recebe como parâmetro

package relacionamentos;

public class ProductView {	
	public void show(Product product) {
		System.out.println("|-----------------|");
		System.out.println("|---- Produto ----|");
		System.out.println("|-----------------|");
		System.out.println("|---- " + product.getName() + " ----|");
		System.out.println("|-----------------|");
		System.out.println("|-----------------|");
	}
}
