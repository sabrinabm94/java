package aluraCarreer.funcionario_v1;

import javaRepositories.Print;

public class Teste {
	public static void main(String[] args) {
		Funcionario sivy = new Funcionario();
		sivy.setNome("Sivy Boing");
		sivy.setCpf("000000000000");
		sivy.setSalario(2500);
		
		Print.print(sivy.getNome());
		Print.print(sivy.getSalario() + "");
		Print.print(sivy.getBonificacao() + "");
		
		Funcionario alexander = new Funcionario();
		alexander.setNome("Alexander C. Becker");
		alexander.setCpf("111111111111");
		alexander.setSalario(3000);
		alexander.setTipo(1);

		Print.print(alexander.getNome());
		Print.print(alexander.getSalario() + "");
		Print.print(alexander.getBonificacao() + "");
		
		Funcionario liv = new Funcionario();
		liv.setNome("Liv B. Becker");
		liv.setCpf("111111111111");
		liv.setSalario(5000);
		liv.setTipo(2);

		Print.print(liv.getNome());
		Print.print(liv.getSalario() + "");
		Print.print(liv.getBonificacao() + "");
	}
}
