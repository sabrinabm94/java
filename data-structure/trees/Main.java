public class Main {
	public static void main(String[] args) {
		/* 
		Criação de árvore
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
		
		//criação de nós, adição de valores e estruturação de subníveis
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
		
		//setando raiz (é sempre o primeiro da lista, o nó pai de todos)
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

		tree.goThrough();
		
		tree.goThroughLambda(tree.getRoot(),(node) -> System.out.print(node.getValue()));
		
		/*
		Os elementos filhos menores ficam a direita e os maiores a esquerda
		A estrutura da arvore seria para indexar elementos (mais veloz para localizar elementos)
		A estrutura linear(lista) seria mais simples para adicionar elementos mas muito lenta para buscar
		*/
		}
	}
