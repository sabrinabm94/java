package aluraCarreer.bytebank;

import javaRepositories.Print;

public class CriaConta {
	public static void main(String[] args) {
		//instanciando a classe conta, criando um objeto do tipo conta
		Conta primeiraConta = new Conta();
		//um objeto nunca estão dentro de uma variável, e sim somente a sua referência
		
		//modificando valor do saldo do objeto primeira conta
		Print.print("Saldos");
		primeiraConta.saldo = 200;
		Print.print("Primeira conta: " + primeiraConta.saldo);
		
		primeiraConta.saldo += 100;
		Print.print("Primeira conta: " + primeiraConta.saldo);
		
		Conta segundaConta = new Conta();
		segundaConta.saldo = 50;
		Print.print("Segunda conta: " + segundaConta.saldo);
	}
}
