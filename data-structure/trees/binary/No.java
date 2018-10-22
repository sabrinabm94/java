package arvore.binaria;

public class No<T extends Comparable<T>> {
	public No<T> pai;
	public No<T> esquerda;
	public No<T> direita;

	public T valor;
	
	public No(T valor) {
		this.valor = valor;
	}
}
