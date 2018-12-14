package funcionario_v1;

public class Teste {
	
	public static void main(String[] args) {
		Funcionario sabrina = new Funcionario();
		sabrina.setNome("Sabrina B. Moreira");
		sabrina.setCpf("000000000000");
		sabrina.setSalario(2500);
		
		System.out.println(sabrina.getNome());
		System.out.println(sabrina.getSalario());
		System.out.println(sabrina.getBonificacao());
		
		Funcionario alexander = new Funcionario();
		alexander.setNome("Alexander C. Becker");
		alexander.setCpf("111111111111");
		alexander.setSalario(3000);
		alexander.setTipo(1);
		
		System.out.println(alexander.getNome());
		System.out.println(alexander.getSalario());
		System.out.println(alexander.getBonificacao());
		
		Funcionario liv = new Funcionario();
		liv.setNome("Liv B. Becker");
		liv.setCpf("111111111111");
		liv.setSalario(5000);
		liv.setTipo(2);
		
		System.out.println(liv.getNome());
		System.out.println(liv.getSalario());
		System.out.println(liv.getBonificacao());
	}

}
