package trees.tree;
import java.util.ArrayList;
import java.util.List;

public class Node<T> {
	private Node<T> parent;
	private Node<T> right;
	private Node<T> left;
	
	private List<Node<T>> children; //lista dos n�s filhos
	
	private T value; //valor do n�
	
	/*
	private: somente a propria classe
	protected: rela��o com heran�a, somente os filhos podem acessar, todos os filhos
	publico: acesso livre a todos
	padr�o: somente o mesmo pacote
	
	encapsulamento: manter a integridade do estado do objeto, podendo fazer valida��es na entrada de dados nos m�todos sets
	*/
	
	/*
	Alternativa sem encapsulamento
	public Node<T> parent; //refer�ncia do n� pai
	public List<Node<T>> children; //listas de n�s filhos
	public T value; //seu valor
	*/
	
	public Node () {
		children = new ArrayList<Node<T>>(); 
	}
	
	public Node<T> getParent() {
		return parent;
	}
	//s� precisaria do encapsulamento se as vari�veis fosse criadas privadas, neste caso foi
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
	
	public Node<T> getRight() { 
		return right;
	}
	public void setRight(Node<T> right) {
		this.right = right;
	}
	
	public Node<T> getLeft() { 
		return left;
	}
	public void setLeft(Node<T> left) {
		this.left = left;
	}
}