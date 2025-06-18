package aluraCarreer.bytebank_v3;

public class ContaCorrente extends Conta {

	//herda os métodos e caracteristicas, mas não os construtores
		public ContaCorrente(int agencia, int numero) {
		//necessita da indicação da super para a classe pai
		super(agencia, numero);
	}
}
