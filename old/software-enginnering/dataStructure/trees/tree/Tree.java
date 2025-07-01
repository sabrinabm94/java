package trees.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.function.Consumer;

public class Tree<T extends Comparable<T>> {
	private Node<T> root;

	public Node<T> getRoot() {
		return root;
	}

	public void setRoot(Node<T> root) {
		this.root = root;
	}
	
	//goThrough recursion
	public void goThrough(Node<T> node) {
		System.out.println(node.getValue());
		
		for(Node<T> children: node.getChildren()) {
			this.goThrough(children);
		}
	}
	
	/*
	public void goThrough() {
		this.goThrough(this.Root);
	}
	*/
	
	//goThrough with lambda
	public void goThroughLambda(Node<T> node, Consumer<Node<T>> lamba) {
		lamba.accept(node);
		
		for(Node<T> children: node.getChildren()) {
			this.goThroughLambda(children, lamba);
		}
	}

	
	//busca por profundidade sem recurs�o
	public void deepSearch(Node<T> node) {
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
	
	//busca por profundidade com lambda e recurs�o
	public void deepSearchLambda(Node<T> node, Consumer<Node<T>> lambda) throws Exception{
		Stack stack = new Stack();
		for (Node<T> children : node.getChildren()){
			stack.push(node.getChildren());
			this.goThroughLambda(children, lambda);
		}
	}
	
	
	//busca por largura sem recurs�o com fila
	public void goThroughWithQueue(Node<T> node) {
		List<Node<T>> queue = new ArrayList<Node<T>>();
		queue.add(node);
		
		while(!queue.isEmpty()) {
			node = queue.remove(0);
			System.out.println(node.getValue());
			queue.addAll(node.getChildren());
		}
	}
	
	//busca por toda profundidade
	public Node<T> goThroughDeep(Node<T> node, T value){
		if (node.getValue().equals(value)){
			return node;
		}
		for (Node<T> children : node.getChildren()){
			Node<T> result = this.goThroughDeep(children, value);	
			if (result != null ){
				return result;
			}
		}
		return null;
	}
	
	/*
	public void remove(T value){
		Node<T> node = this.search(value);
		if (node != null ){
			for(Node<T> children : node.getChildren()){
				children.setParent(node.getParent());
				node.getParent().getChildren().add(children);
			}
			node.getParent().getChildren().remove(node);
		}
	}
	*/
	
	public Node<T> removeWithRoot(T value) {
		try {
			Node<T> nodeFounded = this.goThroughDeep(getRoot(), value);
			
			//percorre os filhos e atualiza os pais e filhos
			for (Node<T> children : nodeFounded.getChildren()){
				children.setParent(nodeFounded.getParent());
				nodeFounded.getParent().getChildren().add(children);
			}
			return nodeFounded = null;
		} catch (Exception e){
			System.out.print(e);
		}
		return null;
	}
	
	public void addByValue(T value) {
		root = getRoot();
		if(this.root == null) {
			this.root = new Node<T>();
			this.root.setValue(value);
		} else {
			this.addByNode(this.root, value);
		}
	}
	
	public void addByNode(Node<T> node, T value) {
		//verifica se o valor que queremos adicionar � maior ou menor que a raiz
		if(node.getValue().compareTo(value) < 0) {
			//verifica se existe algum filho a direita
			if(node.getRight() == null) {
				Node<T> right = new Node<T>();
				right.setValue(value);
				node.setRight(right);
			} else {
				//recurs�o da busca
				this.addByNode(node.getRight(), value);
			}
		} else { //ent�o tem filho a esquerda
			if(node.getLeft() == null) {
				//cria node left e seta o valor
				Node<T> left = new Node<T>();
				left.setValue(value);
				//seta o n� como left do node
				node.setLeft(left);
			} else {
				this.addByNode(node.getLeft(), value);
			}
		}
	}
	
	public void remove(Node<T> node) {
		if(node.getLeft() != null) {
			this.remove(node.getLeft());
		}
		
		if(node.getRight() != null) {
			this.remove(node.getRight());
		}
		
		if(node.getParent() == null) {
			this.root = null;
		} else {
			if(node.getParent().getLeft() == node) {
				node.getParent().setLeft(null);
			} else {
				node.getParent().setRight(null);
			}
		}
	}
	
	/*
	busca em largura: quantos não existem?
	busca profundidade: nó folha com maior distáncia do nó da raiz
	profundidade x largura: árvores com pouca hierarquia podem se tornar listas, com um nível de largura e muita profundidade.
	Números baixos de comparações por causa das podas
	
	busca em largura (BFS)
	Desce um nível hierárquico, vai por todos os filhos nesse nível, depois desse ao nível abaixo desce e continua.
	
	busca em profundidade (DFS)
	Busca entre os os níveis da árvore.
	Começa pela raiz entrando por um filho desta e percorrento todos os seus filhos até encontrar o nó folha, depois sobre um nível e vai ao seu par e visita todos os seus filhos, e continua.
	*/
}
