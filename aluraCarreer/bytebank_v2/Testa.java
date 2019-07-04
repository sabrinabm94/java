package bytebank_v2;

public class Testa {
	public static void main(String[] args) {
		//cliente
		Cliente sabrina = new Cliente();
		sabrina.nome = "Sabrina Boing M.";
		sabrina.cpf = "222.222.222.222";
		sabrina.profissao = "Desenvolvedora";
		
		//conta
		Conta contaSabrina = new Conta();
		contaSabrina.deposita(500);
		
		//atribui a referência do objeto cliente ao titular da conta
		contaSabrina.titular = sabrina;
		System.out.println("A conta do(a) titular " + contaSabrina.titular.nome + " tem o saldo de: " + contaSabrina.getSaldo());
	}
}
