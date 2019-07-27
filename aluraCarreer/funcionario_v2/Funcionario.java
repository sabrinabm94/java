package aluraCarreer.funcionario_v2;

public class Funcionario {
	//private: os atributos são visíveis somente dentro desta classe
	private String nome;
	private String cpf;
	
	//protected: é privado para todos, menos para os filhos desta classe, sendo visível para gerente
	//protected double salario;
	private double salario;
	
	public double getBonificacao() {
		return this.salario * 0.1;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
}
