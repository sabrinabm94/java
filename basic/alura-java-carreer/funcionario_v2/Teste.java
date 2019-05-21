package funcionario_v2;

public class Teste {
	
	public static void main(String[] args) {
		Funcionario sabrina = new Funcionario();
		sabrina.setNome("Sabrina B. Moreira");
		sabrina.setCpf("000000000000");
		sabrina.setSalario(2500);
		
		System.out.println("Nome: " + sabrina.getNome());
		System.out.println("Salário: " + sabrina.getSalario());
		System.out.println("Valor da bonificação: " + sabrina.getBonificacao());
		
		Funcionario alexander = new Funcionario();
		alexander.setNome("Alexander C. Becker");
		alexander.setCpf("111111111111");
		alexander.setSalario(3000);
		
		System.out.println("");
		System.out.println("Nome: " + alexander.getNome());
		System.out.println("Salário: " + alexander.getSalario());
		System.out.println("Valor da bonificação: " + alexander.getBonificacao());
		
		Gerente liv = new Gerente();
		liv.setNome("Liv B. Becker");
		liv.setCpf("111111111111");
		liv.setSalario(5000);
		liv.setSenha(12345);
		
		System.out.println("");
		System.out.println("Nome: " + liv.getNome());
		System.out.println("Salário: " + liv.getSalario());
		System.out.println("Valor da bonificação: " + liv.getBonificacao());
		System.out.println("Autenticado: " + liv.autentica(12345));
		
		//Polimorfismo
		//Utilização de uma referência mais genérica: funciona pois o gerente é um tipo de funcionário, as funções serão somente as que existem em funcionário
		Funcionario func = new Gerente();
		
		Gerente gerenteTeste = new Gerente();
		gerenteTeste.setNome("Marcos");
		gerenteTeste.setSalario(1500);
		ControleBonificacao controle = new ControleBonificacao();
		controle.registra(gerenteTeste);
		System.out.println(controle.getSoma());
		
		Funcionario funcionarioTeste = new Funcionario();
		funcionarioTeste.setSalario(2000);
		controle.registra(funcionarioTeste);
		System.out.println(controle.getSoma());
		
		/*
		func.autentica();
		não funciona pois autentica está no gerente, e não em funcionário.
		*/
	}

}
