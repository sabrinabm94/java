package trees.avl;

import javaRepositories.Print;

public class Tree<T extends Comparable<T>> {
	public Node<T> roots;
	public static int counterAdd;
	public static int counterFind;

	public void add(T valor) {
		if (this.roots == null) {
			this.roots = new Node<T>(valor);
		} else {  
			this.add(this.roots, valor);
		}
	}

	public void add(Node<T> no, T valor) {
		counterAdd++;
		if (no.valor.compareTo(valor) < 0) {
			if (no.right == null) {
				Node<T> novo = new Node<T>(valor);
				novo.parent = no;
				no.right = novo;
				verifyBalancingFactor(novo); //balan�a a arvore
			} else {
				this.add(no.right, valor);
			}
		} else {
			if (no.left == null) {
				Node<T> novo = new Node<T>(valor);
				novo.parent = no;
				no.left = novo;

			} else {
				this.add(no.left, valor);
			}
		}
	}
	
	public void remove(Node<T> node) {
		if(node.left !=  null) {
			this.remove(node.left);
		}
		if(node.right != null) {
			this.remove(node.right);
		}
		if(node.parent == null) {
			this.roots = null;
		} else {
			if(node.parent.left == node) {
				node.parent.left = null;
			} else {
				node.parent.left = null;
			}
		}
	}
	
	//busca por profundidade recursiva : percorre
	public Node<T> find(T valor) {
		return this.find(this.roots, valor);
	}
	
	public Node<T> find(Node<T> node, T valor) {
		counterFind++;
		if (node == null) {
			//Print.print("Achei");
			//Print.print("localizar: " + node.getValor());
			return null;
		}
		
		if(node != null) {
			if(node.value.equals(valor)) {
				return node;
			}
		}
		
		if(node.left != null && valor.compareTo(node.left.value) <= 0) {
			Node<T> aux = find(node, valor);
			if(aux != null) {
				return aux;
			}
		}
		
		if(node.right != null && valor.compareTo(node.right.valor) >= 0) {
			Node<T> aux = find(node.right, valor);
			if(aux != null) {
				return aux;
			}
		}
		
		return null;
	}
	
	public void goThroughPreOrder(Node<T> node) {
		if(node != null) {
			Print.print("Valor: " +  node.getValue());
			
			//chamo o esquerda at� n�o ter mais filhos
			goThroughPreOrder(node.getleft());
			goThroughPreOrder(node.getRight());
		}
	}
	
	//percorrerInOrder: primeiro visito o filho da esquerda e depois o n� pai
	public void goThroughInOrder(Node<T> node) {
		if(node != null) {
			goThroughPreOrder(node.getleft());

			Print.print("Valor: " +  node.getValue());

			goThroughPreOrder(node.getRight());
		}
	}
	
	//percorrerPosOrder: percorrem os filhos e sobre ao pai ao finalizar
	public void goThroughPosOrder(Node<T> node) {
		if(node != null) {
			goThroughPreOrder(node.getleft());

			goThroughPreOrder(node.getRight());

			Print.print("Valor: " +  node.getValue());
		}
	}
	
	public int balancingFactor(Node<T> node) {
		int esquerda = 0, direita = 0;
		
		if(node.getleft() != null) {
		//calcula a altura da esquerda
			esquerda = height(node.left) + 1;
		}
		
		if(node.right != null) {
		//calcula a altura da direita
			direita = height(node.right) + 1;
		}
		
		return esquerda - direita;
	}
	
	private int height(Node<T> node) {
		int esquerda = 0, direita = 0;
		
		if(node.left != null) {
			esquerda = height(node.left);
		}
		if(node.right != null) {
			direita = height(node.right) + 1;
		}
		
		//retorna o lado maior, esquerda ou direita
		return esquerda > direita ? esquerda : direita;
	}
		
		
	//Rota��o simples a esquerda
	public Node<T> rse(Node<T> no) {
		Node<T> pai = no.parent;
		Node<T> direita = no.right;

		no.right = direita.left;
		no.parent = direita;

		direita.left = no;
		direita.parent = pai;
		
		if (pai == null) {
			this.roots = direita;
		} else {
			//identifico se o n� rotacionado ser� pra direita ou esquerda, de acordo com o menor pra direita e o maior pra esquerda
			if(direita.valor.compareTo(pai.valor) < 0) {
				pai.left = direita;
			} else {
				pai.right = direita;
			}
		}
		
		return direita;
	}

	//Rota��o simples a direita
	public Node<T> rsd(Node<T> no) {
		Node<T> pai = no.parent;
		Node<T> esquerda = no.left;

		no.left = esquerda.right;
		no.parent = esquerda;

		esquerda.right = no;
		esquerda.parent = pai;

		if (pai == null) {
			Node<T> parent = esquerda;
		} else {
			if(esquerda.valor.compareTo(pai.valor) < 0) {
				pai.left = esquerda;
			} else {
				pai.right = esquerda;
			}
		}
		
		return esquerda;
	}
	
	//Rota��o dupla a esquerda
	public Node<T> rde(Node<T> no) {
		no.right = rsd(no.right);
		return rse(no);
	}

		
	//Rota��o dupla a direita
	public Node<T> rdd(Node<T> no) {
		no.left = rse(no.left);
		return rsd(no);
	}
	
	private void verifyBalancingFactor(Node<T> no) {
		if (no != null) {
			balance(no);
			verifyBalancingFactor(no.parent);
		}
	}
	
	private void balance(Node<T> treeAvlNode) {
		int fb = balancingFactor(treeAvlNode);
	    
		if (fb < -1) {
			//rota��o simples
			if (balancingFactor(treeAvlNode.right) < 0) {
				rse(treeAvlNode);
        	} else {
        		//ou dupla
        		rde(treeAvlNode);
        	}
		} else if (fb > 1) {
			//rota��o simples
			if (balancingFactor(treeAvlNode.left) > 0) {
				rsd(treeAvlNode);
			} else {
				//ou dupla
				rdd(treeAvlNode);
			}
		}
	}

	/*
	�rvores AVL
	Seu objetivo � ser uma �rvore bin�ria balanceada para ter uma melhor performance na busca, que � afetada por uma grande profundidade.
	
	O fato de balanceamento � o fator chave pra ver a sua degenera��o e necessidade de balanceamento.
	
	O fator de balanceamento � calculado perante a altura do filho da esquerda - a altura da direita do n�. A altura � calculada pela soma dos n�veis do filho da direita e da esquerda.
	Todos os n�s que tem o valor de balanceamento diferente de 0, -1 ou 1 est� desgenerado e faz as rota��es nele.
	O sinal identifica se a rota��o ser� a direita ou esquerda.
	Se o sinal do n� do pai for positivo analisa o filho da direita, se for igual, rota��o simples
	Se o sinal do n� do pai for negativo, analisa o filho da esquerda, se for diferente, rota��o dupla
	
	n�s visinhos: pai e filhos
	n�s folha: n�o raiz
	 
	Calcular o fator de balanceamento de um n�, percorrendo-a com a busca por profundidade para calcular a altura de um n� em espec�fico
	
	Verificar se a �rvore est� mais pesada para esquerda ou direita, onde tem mais n�s filhos, e deve ser removido e jogado para o lado oposto para balancear.
	Para saber para qual sentido rotacionar: analisar o n� degenerado e verificar o sinal
	 
	Dupla ou simples: pega o n� filho para o lado que necessita fazer a rota��o, calculo o fator de balanceamento dele, e se os sinais s�o diferentes faz rota��o dupla, e se for igual faz rota��o simples.
	Quando visualmente tem joelho, tem que rotacionar duplamente
	*/
	
	/*
	 Resum�o
	 Altura: quantos filhos o n� tem em n�veis, nunca pode ser negativa, no minimo 0.
	 Fator de balanceamento: pegar a altura do n� filho da direita e seus filhos menos a altura do n� filho da esquerda e seus filhos
	 o valor da direita � negativo.
	*/

}
