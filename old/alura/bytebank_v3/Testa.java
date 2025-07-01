package aluraCarreer.bytebank_v3;

import javaRepositories.Print;

public class Testa {
	public static void main(String[] args) {
		//cliente
		Cliente sivy = new Cliente();
		sivy.setNome("Sivy Boing");
		sivy.setCpf("222.222.222.222");
		sivy.setProfissao("Desenvolvedora");
		
		//conta
		//Conta contaSivy = new Conta();
		Conta contaSivy = new Conta(1,1);
		contaSivy.setAgencia(0);
		contaSivy.setAgencia(1);
		contaSivy.deposita(500);
		
		Conta contaAlexander = new Conta(2,2);
		
		//atribui a referência do objeto cliente ao titular da conta
		contaSivy.setTitular(sivy);
		Print.print("A conta do(a) titular " + contaSivy.getTitular().getNome() + " tem o saldo de: " + contaSivy.getSaldo());

		//chamando método estático da classe
		Print.print("O total de contas: " + Conta.getTotal());
	}
}
