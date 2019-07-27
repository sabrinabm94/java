package aluraCarreer.funcionario_v2;

import funcionario_v2.Funcionario;

public class ControleBonificacao {
	private double soma;
	
	//Polimorfismo
	//Utiliza a referência mais genética, a classe pai funcionario para que ele e todos os seus filhos possam utilizar essa mesma função
	public void registra(Funcionario funcionario) {
		double bonificacao = funcionario.getBonificacao();
		this.soma = this.soma + bonificacao;
	}
	
	public double getSoma() {
		return soma;
	}
}
