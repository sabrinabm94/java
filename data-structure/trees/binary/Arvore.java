package arvore.binaria;

public class Arvore<T extends Comparable<T>> {
	public No<T> raiz;

	public void adiciona(T valor) {
		if (this.raiz == null) {
			this.raiz = new No<T>(valor);
		} else {  
			this.adiciona(this.raiz, valor);
		}
	}

	private void adiciona(No<T> no, T valor) {
		if (no.valor.compareTo(valor) < 0) {
			if (no.direita == null) {
				no.direita = new No<T>(valor);
			} else {
				this.adiciona(no.direita, valor);
			}
		} else {
			if (no.esquerda == null) {
				no.esquerda = new No<T>(valor);
			} else {
				this.adiciona(no.esquerda, valor);
			}
		}
	}
}
