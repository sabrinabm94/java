import java.util.ArrayList;
import java.util.List;

public class Node<T> {
	private Node<T> Parent;
	private List<Node<T>> Children;
	private T value;
	
	public Node () {
		Children = new ArrayList<Node<T>>(); //criando um construtor para o Children
	}
	
	public Node<T> getParent() {
		return Parent;
	}
	public void setParent(Node<T> parent) {
		Parent = parent;
	}
	public List<Node<T>> getChildren() {
		return Children;
	}
	public void setChildren(List<Node<T>> children) {
		Children = children;
	}
	public T getValue() { 
		//método é indicado para quando tem alteração de valor, o que não é o caso do exemplo
		//também pode ser utilizado node.value acessando a variável caso estivesse publica.
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
}