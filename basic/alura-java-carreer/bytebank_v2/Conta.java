package bytebank_v2;

public class Conta {
	public int agencia;
	public int numero;
	public double saldo;
	public Cliente titular;
	
	public void deposita(double valor) {
		this.saldo = this.saldo + valor;
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
	
	public double getSaldo() {
		return this.saldo;
	}
}
