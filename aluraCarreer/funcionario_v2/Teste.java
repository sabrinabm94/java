package funcionario_v2;

import javaRepositories.Print;

import aluraCarreer.funcionario_v2.Funcionario;

public class Teste {
	public static void main(String[] args) {
		Funcionario sivy = new Funcionario();
		sivy.setNome("Sivy Boing");
		sivy.setCpf("000000000000");
		sivy.setSalario(2500);

		Print.println("Nome: " + sivy.getNome());
		Print.println("Salário: " + sivy.getSalario());
		Print.println("Valor da bonificação: " + sivy.getBonificacao());
		
		Funcionario alexander = new Funcionario();
		alexander.setNome("Alexander C. Becker");
		alexander.setCpf("111111111111");
		alexander.setSalario(3000);

		Print.println("\nNome: " + alexander.getNome());
		Print.println("Salário: " + alexander.getSalario());
		Print.println("Valor da bonificação: " + alexander.getBonificacao());

		Gerente liv = new Gerente();
		liv.setNome("Liv B. Becker");
		liv.setCpf("111111111111");
		liv.setSalario(5000);
		liv.setSenha(12345);

		Print.println("\nNome: " + liv.getNome());
		Print.println("Salário: " + liv.getSalario());
		Print.println("Valor da bonificacão: " + liv.getBonificacao());
		Print.println("Autenticado: " + liv.autentica(12345));
		
		//Polimorfismo
		//Utilização de uma referência mais genérica: funciona pois o gerente é um tipo de funcionário, as funções serão somente as que existem em funcionário
		Funcionario func = new Gerente();
		
		Gerente gerenteTeste = new Gerente();
		gerenteTeste.setNome("Marcos");
		gerenteTeste.setSalario(1500);
		
		ControleBonificacao controle = new ControleBonificacao();
		controle.registra(gerenteTeste);
		Print.println(controle.getSoma() + "");
		
		Funcionario funcionarioTeste = new Funcionario();
		funcionarioTeste.setSalario(2000);
		controle.registra(funcionarioTeste);
		Print.println(controle.getSoma() + "");
		
		/*
		func.autentica();
		não funciona pois autentica está no gerente, e não em funcionário.
		*/
	}
}
