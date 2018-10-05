import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.function.Consumer;

public class Tree<T> {
	private Node<T> Root;

	public Node<T> getRoot() {
		return Root;
	}

	public void setRoot(Node<T> root) {
		Root = root;
	}
	
	public void walkInTree(Node<T> node) {
		System.out.println(node.getValue());
		
		for(Node<T> children: node.getChildren()) {
			this.walkInTree(children);
		}
	}
	
	//busca por profundidade com recursividade
	public void goThrough(Node<T> node) {
		System.out.println(node.getValue());
		
		for(Node<T> children: node.getChildren()) {
			this.goThrough(children);
		}
	}
	
	//busca por profundidade sem recursão
		public void deep(Node<T> node) {
			Stack<Node<T>> stack = new Stack<Node<T>>();
			stack.push(node);
			
			while (!stack.isEmpty()) {
				node = stack.pop();
				System.out.println(node.getValue());
				
				for(int i = node.getChildren().size() -1; i >= 0; i--) {
					stack.push(node.getChildren().get(i));
				}
			}
		}
		
	public void goThrough() {
		this.goThrough(this.Root);
	}
	
	//busca por profundidade com lambda
	public void goThroughLambda(Node<T> node, Consumer<Node<T>> lamba) {
		lamba.accept(node);
		
		for(Node<T> children: node.getChildren()) {
			this.goThroughLambda(children, lamba);
		}
	}

	//busca por largura
	public void width(Node<T> node) {
		List<Node<T>> list = new ArrayList<Node<T>>();
		list.add(node);
		
		while(!list.isEmpty()) {
			node = list.remove(0);
			System.out.println(node.getValue());
			
			list.addAll(node.getChildren());
		}
	}
	
	/*
	busca em largura: quantos nós existem?
	busca profundidade: nó folha com maior distância do nó raiz
	profundidade x largura: árvores com pouca hierarquia podem se tornar listas, com um nível de largura e muita profundidade.
	Números baixos de comparações por causa das podas
	
	busca em largura (BFS)
	Desce um nível hierárquico, vai por todos os filhos nesse nível, depois desse ao nível abaixo desce e continua.
	
	busca em profundidade (DFS)
	Busca entre os os níveis da árvore.
	Começa pela raiz entrando por um filho desta e percorrento todos os seus filhos até encontrar o nó folha, depois sobre um nível e vai ao seu par e visita todos os seus filhos, e continua. 
	*/
}
