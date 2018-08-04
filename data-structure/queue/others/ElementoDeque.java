package exercicios;

class ElementoDeque<T> {
	ElementoDeque<T> proximo;
	ElementoDeque<T> anterior;
	T valor;
	
	ElementoDeque(T valor, ElementoDeque<T> anterior, ElementoDeque<T> proximo) {
		this.valor = valor;
		this.anterior = anterior;
		this.proximo = proximo;
	}
}