public class Arvore<T extends Comparable<T>> {
	public No<T> raiz;
	public static int contadorAdicionar;
	public static int contadorLocalizar;

	public void adiciona(T valor) {
		if (this.raiz == null) {
			this.raiz = new No<T>(valor);
		} else {  
			this.adiciona(this.raiz, valor);
		}
	}

	public void adiciona(No<T> no, T valor) {
		contadorAdicionar++;
		if (no.valor.compareTo(valor) < 0) {
			contadorAdicionar++;
			if (no.direita == null) {
				No<T> novo = new No<T>(valor);
				novo.pai = no;
				no.direita = novo;
				verificaFB(novo); //balança a arvore
			} else {
				this.adiciona(no.direita, valor);
			}
		} else {
			contadorAdicionar++;
			if (no.esquerda == null) {
				No<T> novo = new No<T>(valor);
				novo.pai = no;
				no.esquerda = novo;
				verificaFB(novo); //balança a arvore
			} else {
				this.adiciona(no.esquerda, valor);
			}
		}
	}
	
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
		contadorLocalizar++;
		if (node == null) {
			//System.out.println("Achei");
			//System.out.println("localizar: " + node.getValor());
			return null;
		}
		
		contadorLocalizar++;
		if(node != null) {
			contadorLocalizar++;
			if(node.valor.equals(valor)) {
				return node;
			}
		}
		
		No<T> aux = localizar(node.esquerda, valor);
		contadorLocalizar++;
		if(aux != null) {
			return aux;
		}
		
		aux = localizar(node.direita, valor);
		contadorLocalizar++;
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
			//identifico se o nó rotacionado será pra direita ou esquerda, de acordo com o menor pra direita e o maior pra esquerda
			if(direita.valor.compareTo(pai.valor) < 0) {
				pai.esquerda = direita;
			} else {
				pai.direita = direita;
			}
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
			if(esquerda.valor.compareTo(pai.valor) < 0) {
				pai.esquerda = esquerda;
			} else {
				pai.direita = esquerda;
			}
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
	
	private void verificaFB(No<T> no) {
		if (no != null) {
			balancear(no);
	    		verificaFB(no.pai);
		}
	}
	
	private void balancear(No<T> no) {
		int fb = fatorBalanceamento(no);
	    
		if (fb < -1) {
			//rotação simples
			if (fatorBalanceamento(no.direita) < 0) {
				rse(no);
        	} else {
        		//ou dupla
        		rde(no);
        	}
		} else if (fb > 1) {
			//rotação simples
			if (fatorBalanceamento(no.esquerda) > 0) {
				rsd(no);
			} else {
				//ou dupla
				rdd(no);
			}
		}
	}

		
	/* 
	Árvores AVL
	Seu objetivo é ser uma árvore binária balanceada para ter uma melhor performance na busca, que é afetada por uma grande profundidade.
	
	O fato de balanceamento é o fator chave pra ver a sua degeneração e necessidade de balanceamento.
	
	O fator de balanceamento é calculado perante a altura do filho da esquerda - a altura da direita do nó. A altura é calculada pela soma dos níveis do filho da direita e da esquerda.
	Todos os nós que tem o valor de balanceamento diferente de 0, -1 ou 1 está desgenerado e faz as rotações nele.
	O sinal identifica se a rotação será a direita ou esquerda.
	Se o sinal do nó do pai for positivo analisa o filho da direita, se for igual, rotação simples
	Se o sinal do nó do pai for negativo, analisa o filho da esquerda, se for diferente, rotação dupla
	
	nós visinhos: pai e filhos
	nós folha: não raiz
	 
	Calcular o fator de balanceamento de um nó, percorrendo-a com a busca por profundidade para calcular a altura de um nó em específico
	
	Verificar se a árvore está mais pesada para esquerda ou direita, onde tem mais nós filhos, e deve ser removido e jogado para o lado oposto para balancear.
	Para saber para qual sentido rotacionar: analisar o nó degenerado e verificar o sinal
	 
	Dupla ou simples: pega o nó filho para o lado que necessita fazer a rotação, calculo o fator de balanceamento dele, e se os sinais são diferentes faz rotação dupla, e se for igual faz rotação simples.
	Quando visualmente tem joelho, tem que rotacionar duplamente
	*/
	
	/*
	 Resumão
	 Altura: quantos filhos o nó tem em níveis, nunca pode ser negativa, no minimo 0.
	 Fator de balanceamento: pegar a altura do nó filho da direita e seus filhos menos a altura do nó filho da esquerda e seus filhos
	 o valor da direita é negativo.
	*/
	 

}
