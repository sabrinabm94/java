public class Semaforo {
	private String faseAtual = "Verde";
	
	public String obterFaseAtual() {
		return faseAtual;
	}
	
	public void mudarParaProximaFase() {
		if(faseAtual.equals("Verde")) {
			faseAtual = "Amarelo";
		}
		else if (faseAtual.equals("Amarelo")) {
			faseAtual = "Vermelho";
		}
		else if (faseAtual.equals("Vermelho")) {
			faseAtual = "Verde";
			
		}
	}
}