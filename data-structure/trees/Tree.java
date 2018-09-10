package trees;

public class Tree<T> {
	private Node<T> Root;

	public Node<T> getRoot() {
		return Root;
	}

	public void setRoot(Node<T> root) {
		Root = root;
	}
	
	/*
	adicionar
	remover
	percorrer
	busca em largura: quantos nós existem?
	busca profundidade: nó folha com maior distância do nó raiz
	profundidade x largura: árvores com pouca hierarquia podem se tornar listas, com um nível de largura e muita profundidade.
	Números baixos de comparações por causa das podas
	*/
}


