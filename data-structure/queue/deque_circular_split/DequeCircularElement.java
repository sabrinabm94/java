public class DequeCircularElement<T> {
	private DequeCircularElement<T> next;
	private DequeCircularElement<T> prev;
	private T value;
	public DequeCircularElement(T v) {
		value = v;
	}
	public void setNext(DequeCircularElement<T> e) {
		this.next = e;
	}
	public DequeCircularElement<T> getNext() {
		return next;
	}
	public void setPrev(DequeCircularElement<T> e) {
		this.prev = e;
	}
	public DequeCircularElement<T> getPrev() {
		return prev;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public T getValue() {
		return value;
	}
}
