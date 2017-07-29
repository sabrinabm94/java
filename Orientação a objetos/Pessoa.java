public class Pessoa {
	public String nome;
	private int idade;
	
	public Pessoa() { //construtor pessoa
		//Chamada de outros construtores deve estar na primeira linha
		//this("Sem Nome");
		this("Sem Nome", 0);
		System.out.println("Criou a pessoa");
		//System.out.println("Idade: " + idade);
	}
	
	public Pessoa(String nome) { //construtor nome
		//this.nome = nome;
		this(nome, 0);
		System.out.println("Nome: " + nome);
	}
	
	public Pessoa(int idade) { //construtor idade
		this("Sem nome", idade);
		System.out.println("Idade: " + idade);
	}
	
	public Pessoa(String nome, int idade) {
		this.idade = idade;
		this.nome = nome;
		if(idade < 0) {
			System.out.println("Idade negativa");
			return;
		}
		System.out.println("Encerrou o construtor");
	}
	
	/*
	Caso para a construção 2 dados sejam obrigatórios, pode fazer o seguinte:
	public Pessoa(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}
	*/
}
