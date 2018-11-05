public class Main {

	public static void main(String[] args) {
		Arvore<Integer> a = new Arvore<>();
		
		//os objetos de nó estão encapsulados dentro da arvore, mas não foram instanciados
		a.adiciona(5);
		a.adiciona(3);
		a.adiciona(2);
		a.adiciona(4);
		a.adiciona(7);
		a.adiciona(6);
		a.adiciona(8);
		
		BTreePrinter.printNode(a.raiz);
		
		No<Integer> node = a.localizar(5);
		a.percorrerPreOrder(a.raiz);
	}

}
