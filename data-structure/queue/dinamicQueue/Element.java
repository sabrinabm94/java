package fila;
public class Element {
	private Element next;
	private Object value;
	public Element getNext() {
		return next;
	}
	public void setNext(Element e) {
		this.next = e;
	}
	public Object getValue() {
		return value;
	}
}
