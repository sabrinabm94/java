package aluraCarreer.funcionario_v2;

//gerente herda de funcionário seus métodos e atributos
public class Gerente extends Funcionario {
	private int senha;
	
	public boolean autentica(int senha) {
		if(this.senha == senha) {
			return true;
		} else {
			return false;
		}
	}
	
	//reescrita do método getBonificação que tem na classe pai funcionério
	public double getBonificacao() {
		//o super indica que o atributo não esté definido nesta classe e sim na super classe (a classe pai), que no caso é a Funcionário
		//foi chamado um método da classe funcionário para concatenar com outro valor
		return super.getBonificacao() +  super.getSalario();
		//se fosse utilizado o this.getBonificacao em vez de usar super.getBonificacao, o método seria chamado recursivamente ele mesmo, causando erros nessa situação.
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}
}
