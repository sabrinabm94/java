package bytebank;

public class TestaMetodos {
	public static void main(String[] args) {
		Conta contaSabrina = new Conta();
		contaSabrina.titular = "Sabrina Boing M.";
		contaSabrina.saldo = 10;
		
		//Deposita
		contaSabrina.deposita(100);
		System.out.println("Conta do(a) " + contaSabrina.titular + " com saldo de: " + contaSabrina.saldo);
		
		
		//Saca
		boolean conseguiuSacar = contaSabrina.saca(100);
		System.out.println("Conseguiu sacar? " + conseguiuSacar + ", conta do(a)" + contaSabrina.titular + " com saldo de: " + contaSabrina.saldo);
		
		Conta contaAlexander = new Conta();
		contaAlexander.titular = "Alexander C. Becker";
		contaAlexander.deposita(1000);
		System.out.println("Conta do(a) " + contaAlexander.titular + " com saldo de: " + contaAlexander.saldo);
		
		//transfere
		boolean conseguiuTransfere = contaSabrina.transfere(3, contaAlexander);
		if(conseguiuTransfere) {
			System.out.println("Conta do(a) " + contaAlexander.titular + " com saldo de: " + contaAlexander.saldo);
			System.out.println("Conta do(a) " + contaSabrina.titular + " com saldo de: " + contaSabrina.saldo);
		} else {
			System.out.println("Faltou dinheiro");
		}
		
	}
}
