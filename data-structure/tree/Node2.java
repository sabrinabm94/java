package tree;
public class Node2 {
	private Object value;
	private Node2 previous;
	
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public Node2 getPrevious() {
		return previous;
	}
	public void setPrevious(Node2 previous) {
		this.previous = previous;
	}
}