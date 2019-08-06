package queue;

public class ElementGenerics {
    private ElementGenerics<T> next;
    private ElementGenerics<T> prev;
    private T value;

    public ElementGenerics(T v) {
        value = v;
    }
    public void setNext(ElementGenerics<T> e) {
        this.next = e;
    }
    public ElementGenerics<T> getNext() {
        return next;
    }
    public void setPrev(ElementGenerics<T> e) {
        this.prev = e;
    }
    public ElementGenerics<T> getPrev() {
        return prev;
    }
    public void setValue(T value) {
        this.value = value;
    }
    public T getValue() {
        return value;
    }
}
