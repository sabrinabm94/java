package aluraCarreer.bytebank_v3;

import javaRepositories.Print;

public class Conta {
	//private para evitar que as variáveis sejam acessadas diretamente, queremos que sejam alteradas somente pelos métodos deposita, saca e transfere
	//atributos da instância
	private double saldo;
	private int agencia;
	private int numero;
	private Cliente titular;
	
	//static: atributo da classe (compartilhado por todas as instâncias)
	private static int total;
	
	//A principal responsabilidade do construtor é iniciar atributos
	public Conta(int agencia, int numero) {
		//total++;
		Conta.total++;
		
		this.agencia = agencia;
		this.numero = numero;
		
		//O construtor pode ser usada para fazer restrições, ser obrigado a informar a agencia e némero para instanciar uma conta
		Print.print("Criando uma conta via construtor");
	}
	
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
	
	//quando as variáveis são privadas, é necessário utilizar os get/set para poder alterar essas variáveis por outras classes
	//neste caso não é necessário um setSaldo porque o saca/deposita/transfere já faz esse papel de alterar o valor do saldo
	//o ideal é que todos os atributos da classe sejam privados, com raras excessões
	public double getSaldo() {
		return this.saldo;
	}
	
	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		if(agencia <= 0) {
			Print.print("O valor informado n�o � permitido");
		} else {
			this.agencia = agencia;
		}
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		if(agencia <= 0) {
			Print.print("O valor informado não é permitido");
		} else {
			this.numero = numero;
		}
	}

	public Cliente getTitular() {
		return titular;
	}

	public void setTitular(Cliente titular) {
		this.titular = titular;
	}
	
	//método da classe (compartilhado por todas as instâncias)
	public static int getTotal() {
		return Conta.total;
	}
}
