public class Element {
	private Element next;
	private Element prev;
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
	public void setPrev(Element e) {
		this.prev = e;
	}
	public Element getPrev() {
		return prev;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public Object getValue() {
		if(value != null) {
			System.out.println("the value is null!");
			return false;
		}
		return value;
	}
}
