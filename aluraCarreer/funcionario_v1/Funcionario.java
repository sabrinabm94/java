package funcionario_v1;

public class Funcionario {
	private String nome;
	private String cpf;
	private double salario;
	private int tipo = 0; 
	//funcionário = 0 gerente = 1 diretor = 2
	
	public double getBonificacao() {
		if(this.tipo == 0) { //funcionario comum
			return this.salario * 0.1;
		} else if(this.tipo == 1) { //gerente
			return this.salario;
		} else { //diretor
			return this.salario + 1000.00;
		}
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

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
}
