package relacionamentos;

public class ProductDAO {
	//DAO data acess object, responsável em acessar o banco de dados
	
	public Product catchById(long id) {
		Product p = new Product();
		p.setName("Bonitão");
		return p;
	}
}
