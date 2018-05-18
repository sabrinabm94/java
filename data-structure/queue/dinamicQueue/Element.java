package fila;
public class Element {
	private Element next;
	private Object value;
	public Element (Object v) {
		value = v;
	}
	public void setNext(Element e) {
		this.next = e;
	}
	public Element getNext() {
		return next;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public Object getValue() {
		return value;
	}
}

