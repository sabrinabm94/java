import java.util.ArrayList;
import java.util.List;

public class Node<T> {
	private Node<T> parent; //referência do nó pai 
	private List<Node<T>> children; //lista dos nós filhos
	private T value; //valor do nó
	
	/*
	private: somente a propria classe
	protected: relação com herança, somente os filhos podem acessar, todos os filhos
	publico: acesso livre a todos
	padrão: somente o mesmo pacote
	
	encapsulamento: manter a integridade do estado do objeto, podendo fazer validações na entrada de dados nos métodos sets
	*/
	
	/*
	Alternativa sem encapsulamento
	public Node<T> parent; //referência do nó pai
	public List<Node<T>> children; //listas de nós filhos
	public T value; //seu valor
	*/
	
	public Node () {
		children = new ArrayList<Node<T>>(); 
	}
	
	public Node<T> getParent() {
		return parent;
	}
	//só precisaria do encapsulamento se as variáveis fosse criadas privadas, neste caso foi
	public void setParent(Node<T> p) {
		parent = p;
	}
	public List<Node<T>> getChildren() {
		return children;
	}
	public void setChildren(List<Node<T>> c) {
		children = c;
	}
	public T getValue() { 
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
}