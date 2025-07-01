package trees.avl;

public class Node<T extends Comparable<T>> {
	public Node<T> parent;
	public Node<T> left;
	public Node<T> right;
	public T value;

	public T valor;
	
	public Node<T> getParent() {
		return parent;
	}
	
	public Node(T value) {
		this.value = value;
	}
	
	public void setParent(Node<T> parent) {
		this.parent = parent;
	}

	public Node<T> getleft() {
		return left;
	}

	public void setleft(Node<T> left) {
		this.left = left;
	}

	public Node<T> getRight() {
		return right;
	}

	public void setRight(Node<T> right) {
		this.right = right;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
}
