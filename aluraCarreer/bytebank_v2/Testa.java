package aluraCarreer.bytebank_v2;

import javaRepositories.Print;

public class Testa {
	public static void main(String[] args) {
		//cliente
		Cliente sivy = new Cliente();
		sivy.nome = "Sivy Boing";
		sivy.cpf = "222.222.222.222";
		sivy.profissao = "Desenvolvedora";
		
		//conta
		Conta contaSivy = new Conta();
		contaSivy.deposita(500);
		
		//atribui a referência do objeto cliente ao titular da conta
		contaSivy.titular = sivy;
		Print.print("A conta do(a) titular " + contaSivy.titular.nome + " tem o saldo de: " + contaSivy.getSaldo());
	}
}
