package trabalho;
public class Element<T> {
	private Element<T> next;
	private Element<T> prev;
	private T value;
	public Element (T v) {
		value = v;
	}
	public void setNext(Element<T> e) {
		this.next = e;
	}
	public Element<T> getNext() {
		return next;
	}
	public void setPrev(Element<T> e) {
		this.prev = e;
	}
	public Element<T> getPrev() {
		return prev;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public T getValue() {
		return value;
	}
}
