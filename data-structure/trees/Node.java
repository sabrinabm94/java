package trees;

import java.util.List;

public class Node<T> {
	private Node<T> Parent;
	private List<Node<T>> Children;
	private T value;
	
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
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
}
