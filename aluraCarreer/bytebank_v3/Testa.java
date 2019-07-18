package bytebank_v3;

public class Testa {
	public static void main(String[] args) {
		//cliente
		Cliente sabrina = new Cliente();
		sabrina.setNome("Sabrina Boing M.");
		sabrina.setCpf("222.222.222.222");
		sabrina.setProfissao("Desenvolvedora");
		
		//conta
		//Conta contaSabrina = new Conta();
		Conta contaSabrina = new Conta(1,1);
		contaSabrina.setAgencia(0);
		contaSabrina.setAgencia(1);
		contaSabrina.deposita(500);
		
		Conta contaAlexander = new Conta(2,2);
		
		//atribui a referência do objeto cliente ao titular da conta
		contaSabrina.setTitular(sabrina);
		System.out.println("A conta do(a) titular " + contaSabrina.getTitular().getNome() + " tem o saldo de: " + contaSabrina.getSaldo());
		
		
		//chamando método estático da classe
		System.out.println("O total de contas é: " + Conta.getTotal());
	}
}
