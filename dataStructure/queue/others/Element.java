package queue.others;

class Element<T> {
	Element<T> next;
	Element<T> prev;
	T value;
	
	Element(T value, Element<T> prev, Element<T> next) {
		this.value = value;
		this.prev = prev;
		this.next = next;
	}
}