package arvore.binaria;

public class Main {

	public static void main(String[] args) {
		Arvore<Integer> a = new Arvore<>();
		
		a.adiciona(5);
		a.adiciona(3);
		a.adiciona(2);
		a.adiciona(4);
		a.adiciona(7);
		a.adiciona(6);
		a.adiciona(8);
		
		BTreePrinter.printNode(a.raiz);

	}

}
