public class Arvore<T extends Comparable<T>> {
	public No<T> raiz;
	
	//Árvores binárias (ordenadas): nós estão em hierarquia, ordenados e balanceado (esquerda: menor, direita: maior)
	//Árvores (AVL): seu objetivo é ser uma árvore binária balanceada
	
	//Árvore degenerada: quando a árvore tem uma estrutura linear, com somente uma subárvore, complexidade N.
	//Árvore cheia: Todos os nós tem a mesma quantidade de filhos, complexidade Log N.

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
	
	//Dimensões: definido pela largura x altura
	
	//largura: É o número maior de filhos que tem no mesmo nível
	//busca: a busca acontece percorrendo os níveis, ao entrar em um nível todos os seus elementos são visitados para depois descer ao próximo nível
	
	//profundidade: é o maior comprimento possível do nó raiz até o nó folha mais profundo, fornece a altura da árvore. Sempre da esqueda pra direita.
	//busca: os elementos são visitados intercalando-se nos níveis da árvore, percorrendo diversos caminhos.

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
	
	//Pre order: raiz, esquerda, direita
	//Raiz, próximo filho a esquerda e todos seus filhos, até o último nó folha da direita.
	public void percorrerPreOrder(No<T> node) {
		if(node != null) {
			System.out.println("Valor: " +  node.getValor());
			
			//chamo o esquerda até não ter mais filhos
			percorrerPreOrder(node.getEsquerda());
			percorrerPreOrder(node.getDireita());
		}
	}
	
	//In order: esquerda, raiz, direita
	//Último nó folha da esquerda, pai deste, outros filhos, raiz, até último no folha da direita
	public void percorrerInOrder(No<T> node) {
		if(node != null) {
			percorrerPreOrder(node.getEsquerda());
			
			System.out.println("Valor: " +  node.getValor());
			
			percorrerPreOrder(node.getDireita());
		}
	}
	
	//Pos order: esquerda, direita, raiz
	//Último no folha da esquerda, último nó folha da direita até raiz
	public void percorrerPosOrder(No<T> node) {
		if(node != null) {
			percorrerPreOrder(node.getEsquerda());
			
			percorrerPreOrder(node.getDireita());
			
			System.out.println("Valor: " +  node.getValor());
		}
	}
	
	//O nó a esquerda deste tem que ser menor, o nó a direita deste deve ser maior

	//Verifica se a árvore está degenerada, ou seja, se o seu valor é diferente de -1, 0 ou 1. 
	//FB: altura da subárvore esquerda - altura da subárvore direita.
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
	
	//Deve ser chamado para cada adição/exclusão
	private void verificaFB(No<T> no) {
		if (no != null) {
			balancear(no);
	    		verificaFB(no.pai);
		}
	}
	
	//Verificar se a árvore está mais pesada para esquerda ou direita, onde tem mais nós filhos, e deve ser removido e jogado para o lado oposto para balancear.

	//Rotação dupla ou simples ? Pega o nó filho para o lado que necessita fazer a rotação, cálculo o fator de balanceamento dele, e se os sinais são diferentes faz rotação dupla, e se for igual faz rotação simples
	//Joelho: se visualmente tem um joelho, necessita de rotação dupla
	private void balancear(No<T> no) {
		int fb = fatorBalanceamento(no);
	    
		if (fb < -1) {
			if (fatorBalanceamento(no.direita) < 0) {
				rse(no);
	        	} else {
				rde(no);
	        	}
		} else if (fb > 1) {
			if (fatorBalanceamento(no.esquerda) > 0) {
				rsd(no);
			} else {
				rdd(no);
			}
		}
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
	public No<T> rse(No<T> no) {
		No<T> pai = no.pai;
		No<T> direita = no.direita;

		no.direita = direita.esquerda;
		no.pai = direita;

		direita.esquerda = no;
		direita.pai = pai;
		
		if (pai == null) {
			raiz = direita;
		} else {
			pai.direita = direita;
		}
		
		return direita;
	}

	//Rotação simples a direita
	public No<T> rsd(No<T> no) {
		No<T> pai = no.pai;
		No<T> esquerda = no.esquerda;

		no.esquerda = esquerda.direita;
		no.pai = esquerda;

		esquerda.direita = no;
		esquerda.pai = pai;

		if (pai == null) {
			raiz = esquerda;
		} else {
			pai.esquerda = esquerda;
		}
		
		return esquerda;
	}
	
	//Rotação dupla a esquerda
	public No<T> rde(No<T> no) {
		no.direita = rsd(no.direita);
		return rse(no);
	}

		
	//Rotação dupla a direita
	public No<T> rdd(No<T> no) {
		no.esquerda = rse(no.esquerda);
		return rsd(no);
	}
}
