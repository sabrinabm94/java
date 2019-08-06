package aluraCarreer.bytebank;

import javaRepositories.Print;

public class TesteReferencia {
	public static void main(String[] args) {
		Conta primeiraConta = new Conta();
		primeiraConta.saldo = 300;
		Print.print("primeira conta - saldo: " + primeiraConta.saldo);
		
		//o objeto não está dentro da variável, e sim somente a sua referência
		//temos somente um objeto criado, e suas referências para ele
		Conta segundaConta = primeiraConta;
		
		//mostra a referência a primeira conta
		Print.print(segundaConta + "");
		
		//mostra o saldo da primeira conta, pois não foi instanciado um novo objeto para a segunda conta
		Print.print(segundaConta.saldo + "");
		
		//incrementar o valor do saldo da primeira conta utilizando a referência da segunda conta a este objeto
		segundaConta.saldo += 100;
		Print.print("segunda conta - saldo: " + segundaConta.saldo);
		
		//mostrando o valor do saldo do objeto da primeira conta, que tinha sido alterado pela referência da segunda conta
		Print.print("primeira conta - saldo: " + primeiraConta.saldo);
		
		//comparando as referencias ao objeto das variáveis
		if(primeiraConta == segundaConta) {
			Print.print("Referências iguais ao mesmo objeto");
		}
		
		Conta terceiraConta = new Conta();
		//comparando as referencias ao objeto das variáveis
		if(primeiraConta == terceiraConta) {
			Print.print("Referências iguais ao mesmo objeto");
		} else {
			Print.print("Referências diferentes para outros objetos");
		}
	}
}
