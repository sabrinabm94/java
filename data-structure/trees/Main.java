
public class Main {

	public static void main(String[] args) {
		//criação de árvore
		Tree<Integer> tree = new Tree<Integer>();
		
		//criação de nodes e valores
		Node<Integer> node1 = new Node<Integer>();
		node1.setValue(1);
		
		Node<Integer> node2 = new Node<Integer>();
		node2.setValue(2);
		
		Node<Integer> node3 = new Node<Integer>();
		node3.setValue(3);
		
		Node<Integer> node4 = new Node<Integer>();
		node4.setValue(4);
		
		Node<Integer> node5 = new Node<Integer>();
		node5.setValue(5);
		
		Node<Integer> node6 = new Node<Integer>();
		node6.setValue(6);
		
		//indicado que o node1 é a raiz, a raiz é sempre o primeiro valor, que é o de cima
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

		tree.gothrough();
		
		tree.gothroughLambda(tree.getRoot(),(node) -> System.out.print(node.getValue()));
		
		}
		
	}
