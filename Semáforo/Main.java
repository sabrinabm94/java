public class Main {
	public static void main (String[] args) {
		Semaforo s = new Semaforo();
		System.out.println(s.obterFaseAtual());
		s.mudarParaProximaFase();
		System.out.println(s.obterFaseAtual());
		s.mudarParaProximaFase();
		System.out.println(s.obterFaseAtual());
		s.mudarParaProximaFase();
		System.out.println(s.obterFaseAtual());
		s.mudarParaProximaFase();
		System.out.println(s.obterFaseAtual());
		s.mudarParaProximaFase();
		
	}
}