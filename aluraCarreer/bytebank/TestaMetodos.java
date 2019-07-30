package aluraCarreer.bytebank;

import javaRepositories.Print;

public class TestaMetodos {
	public static void main(String[] args) {
		Conta contaSivy = new Conta();
		contaSivy.titular = "Sivy Boing";
		contaSivy.saldo = 10;
		
		//Deposita
		contaSivy.deposita(100);
		Print.print("Conta do(a) " + contaSivy.titular + " com saldo de: " + contaSivy.saldo);
		
		//Saca
		boolean conseguiuSacar = contaSivy.saca(100);
		Print.print("Conseguiu sacar? " + conseguiuSacar + ", conta do(a)" + contaSivy.titular + " com saldo de: " + contaSivy.saldo);
		
		Conta contaAlexander = new Conta();
		contaAlexander.titular = "Alexander Becker";
		contaAlexander.deposita(1000);
		Print.print("Conta do(a) " + contaAlexander.titular + " com saldo de: " + contaAlexander.saldo);
		
		//transfere
		boolean conseguiuTransfere = contaSivy.transfere(3, contaAlexander);
		if(conseguiuTransfere) {
			Print.print("Conta do(a) " + contaAlexander.titular + " com saldo de: " + contaAlexander.saldo);
			Print.print("Conta do(a) " + contaSivy.titular + " com saldo de: " + contaSivy.saldo);
		} else {
			Print.print("Faltou dinheiro");
		}
	}
}
