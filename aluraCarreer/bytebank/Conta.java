package bytebank;

//classe: especificação de um tipo (neste caso o conta) que define seus atributos e comportamentos
public class Conta {
	//atributos ou propriedades, iniciam com 0/false/vazio
	//alterações feita na classe serão replicada aos objetos ao ser instanciado, depois disso podem ser alterados
	double saldo;
	int agencia;
	int numero;
	String titular;
	
	//função sem retorno
	public void deposita(double valor) {
		this.saldo = this.saldo + valor;
		//this para referenciar o saldo (atribuito da classe) da conta na qual o método foi invocado
		//o valor não utiliza this por ser uma varável temporário que só existe neste escopo e desaparecerá ao ser terminado de executar essa função
	}
	
	public boolean saca(double valor) {
		if(this.saldo >= valor) {
			this.saldo = this.saldo - valor;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean transfere(double valor, Conta contaDestino) {
		if(this.saldo >= valor) {
			saca(valor);
			contaDestino.deposita(valor);
			return true;
		} 
		
		return false;
	}
}
