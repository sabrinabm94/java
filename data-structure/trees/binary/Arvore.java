public class Arvore<T extends Comparable<T>> {
	public No<T> raiz;

	public void adiciona(T valor) {
		if (this.raiz == null) {
			this.raiz = new No<T>(valor);
		} else {  
			this.adiciona(this.raiz, valor);
		}
	}

	public void adiciona(No<T> no, T valor) {
		if (no.valor.compareTo(valor) < 0) {
			if (no.direita == null) {
				No<T> novo = new No<T>(valor);
				novo.pai = no;
				no.direita = novo;
			} else {
				this.adiciona(no.direita, valor);
			}
		} else {
			if (no.esquerda == null) {
				No<T> novo = new No<T>(valor);
				novo.pai = no;
				no.esquerda = novo;
			} else {
				this.adiciona(no.esquerda, valor);
			}
		}
	}
	
	//remove utilizando nó: necessita instanciar
	public void remove(No<T> node) {
		if(node.esquerda !=  null) {
			this.remove(node.esquerda);
		}
		if(node.direita != null) {
			this.remove(node.direita);
		}
		if(node.pai == null) {
			this.raiz = null;
		} else {
			if(node.pai.esquerda == node) {
				node.pai.esquerda = null;
			} else {
				node.pai.direita = null;
			}
		}
	}
	
	//busca por profundidade recursiva : percorre
	
	public No<T> localizar(T valor) {
		return this.localizar(this.raiz, valor);
	}
	
	public No<T> localizar(No<T> node, T valor) {
		if(node != null) {
			if(node.getValor().equals(valor)) {
				return node;
			}
		}
		
		No<T> aux = localizar(node.getEsquerda(), valor);
		if(aux != null) {
			return aux;
		}
		
		aux = localizar(node.getDireita(), valor);
		if(aux != null) {
			return aux;
		}
		
		return null;
	}
	
	public void percorrerPreOrder(No<T> node) {
		if(node != null) {
			System.out.println("Valor: " +  node.getValor());
			
			//chamo o esquerda até não ter mais filhos
			percorrerPreOrder(node.getEsquerda());
			percorrerPreOrder(node.getDireita());
		}
	}
	
	public void percorrerInOrder(No<T> node) {
		if(node != null) {
			percorrerPreOrder(node.getEsquerda());
			
			System.out.println("Valor: " +  node.getValor());
			
			percorrerPreOrder(node.getDireita());
		}
	}
	
	public void percorrerPosOrder(No<T> node) {
		if(node != null) {
			percorrerPreOrder(node.getEsquerda());
			
			percorrerPreOrder(node.getDireita());
			
			System.out.println("Valor: " +  node.getValor());
		}
	}
	
	//percorrerInOrder: primeiro visito o filho da esquerda e depois o nó pai
	//percorrerPosOrder: percorrem os filhos e sobre ao pai ao finalizar
}
