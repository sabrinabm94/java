package bytebank;

public class CriaConta {
	public static void main(String[] args) {
		//instanciando a classe conta, criando um objeto do tipo conta.
		Conta primeiraConta = new Conta();
		//um objeto nunca está dentro de uma variável, e sim somente a sua referência
		
		//modificando valor do saldo do objeto primeira conta.
		System.out.println("Saldos");
		primeiraConta.saldo = 200;
		System.out.println("Primeira conta: " + primeiraConta.saldo);
		
		primeiraConta.saldo += 100;
		System.out.println("Primeira conta: " + primeiraConta.saldo);
		
		Conta segundaConta = new Conta();
		segundaConta.saldo = 50;
		System.out.println("Segunda conta: " + segundaConta.saldo);
	}
}
