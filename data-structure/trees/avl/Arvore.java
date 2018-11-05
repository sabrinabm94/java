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
	
	//percorrerInOrder: primeiro visito o filho da esquerda e depois o nó pai
	public void percorrerInOrder(No<T> node) {
		if(node != null) {
			percorrerPreOrder(node.getEsquerda());
			
			System.out.println("Valor: " +  node.getValor());
			
			percorrerPreOrder(node.getDireita());
		}
	}
	
	//percorrerPosOrder: percorrem os filhos e sobre ao pai ao finalizar
	public void percorrerPosOrder(No<T> node) {
		if(node != null) {
			percorrerPreOrder(node.getEsquerda());
			
			percorrerPreOrder(node.getDireita());
			
			System.out.println("Valor: " +  node.getValor());
		}
	}
	
	public int fatorBalanceamento(No<T> node) {
		int esquerda = 0, direita = 0;
		
		if(node.esquerda != null) {
		//calcula a altura da esquerda
			esquerda = altura(node.esquerda) + 1;
		}
		
		if(node.direita != null) {
		//calcula a altura da direita
			direita = altura(node.direita) + 1;
		}
		
		return esquerda - direita;
	}
	
	private int altura(No<T> node) {
		int esquerda = 0, direita = 0;
		
		if(node.esquerda != null) {
			esquerda = altura(node.esquerda);
		}
		
		if(node.direita != null) {
			direita = altura(node.direita) + 1;
		}
		
		//retorna o lado maior, esquerda ou direita
		return esquerda > direita ? esquerda : direita;
	}
		
		
	//Rotação simples a esquerda
		
	//Rotação simples a direita
		
	//Rotação dupla a esquerda
		
	//Rotação dupla a direita
		
	/* 
	Árvores AVL
	
	Calcular o fator de balanceamento de um nó, percorrendo-a com a busca por profundidade para calcular a altura de um nó em específico
	
	Verificar se a árvore está mais pesada para esquerda ou direita, onde tem mais nós filhos, e deve ser removido e jogado para o lado oposto para balancear.
	Para saber para qual sentido rotacionar: analisar o nó degenerado e verificar o sinal
	 
	Dupla ou simples: pega o nó filho para o lado que necessita fazer a rotação, calculo o fator de balanceamento dele, e se os sinais são diferentes faz rotação dupla, e se for igual faz rotação simples.
	Quando visualmente tem joelho, tem que rotacionar duplamente
	*/

}
