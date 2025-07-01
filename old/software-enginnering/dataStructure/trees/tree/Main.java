package trees.tree;

public class Main {
	public static void main(String[] args) {
		/*
		Cria��o de �rvore
			1
		  2 - 5
		3 - 4 -6
		*/
		Tree<Integer> tree = new Tree<Integer>();

		/*
		Alternativa sem encapsulamento
		Node<Integer> node1 = new Node<Integer>();
		node1.value(1);
		node1.children.add(node2);
		node2.parent(node1);
		*/

		//cria��o de n�s, adi��o de valores e estrutura��o de subn�veis
		Node<Integer> node1 = new Node<Integer>();
		node1.setValue(1);

		Node<Integer> node2 = new Node<Integer>();
		node2.setValue(2);

		Node<Integer> node5 = new Node<Integer>();
		node5.setValue(5);

		Node<Integer> node3 = new Node<Integer>();
		node3.setValue(3);

		Node<Integer> node4 = new Node<Integer>();
		node4.setValue(4);

		Node<Integer> node6 = new Node<Integer>();
		node6.setValue(6);

		//setando raiz (� sempre o primeiro da lista, o n� pai de todos)
		tree.setRoot(node1);


		//filhos
		node1.getChildren().add(node2); //pegando os valores da lista sem reiniciar ela
		node1.getChildren().add(node5);
		node2.getChildren().add(node3);
		node2.getChildren().add(node4);
		node5.getChildren().add(node6);

		//pais
		node2.setParent(node1);
		node3.setParent(node2);
		node4.setParent(node2);
		node5.setParent(node1);
		node6.setParent(node5);

		tree.goThrough(tree.getRoot());

		tree.goThroughLambda(tree.getRoot(),(node) -> System.out.print(node.getValue()));

		tree.addByValue(7);
		tree.addByNode(node3, 7);

		tree.removeWithRoot(7);

		tree.deepSearch(tree.getRoot());
		tree.goThroughWithQueue(tree.getRoot());

		/*
		Os elementos filhos menores ficam a direita e os maiores a esquerda
		A estrutura da arvore seria para indexar elementos (mais veloz para localizar elementos)
		A estrutura linear(lista) seria mais simples para adicionar elementos mas muito lenta para buscar
		*/
	}
}
