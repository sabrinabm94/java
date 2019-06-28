public class Main {
	public static void main(String[] args) {
		Arvore<Integer> a = new Arvore<>();
		
		for(int i = 1; i <= 100; i++) {
			a.adiciona(i);
			
			a.localizar(i);
			//contador adicionado + contador localizar
			System.out.println(Arvore.contadorAdicionar + ";" + Arvore.contadorLocalizar);
		}
	}
}
