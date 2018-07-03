package exercicios;

import java.util.Collections;
import java.util.HashMap;
import java.util.function.Consumer;

import static java.util.Comparator.comparingInt;

class FilaDinamica<T> {
	private ElementoFila<T> cabeca;
	private ElementoFila<T> cauda;
	
	void add(T valor) {
		ElementoFila<T> novo = new ElementoFila<>(valor, null);
		
		if(isEmpty()) {
			cabeca = novo;
			cauda = novo;
			return;
		}
		
		if(cabeca == cauda) { //um Elemento<T> só
			cabeca.proximo = novo;
		}
		
		cauda.proximo = novo;
		cauda = novo;
	}
	
	T remove() {
		if(isEmpty()) {
			throw new RuntimeException("Não é possível remover um elemento de uma fila vazia.");
		}
		T removed = cabeca.valor;
		
		cabeca = cabeca.proximo;
		
		return removed;
	}
	
	boolean isEmpty() {
		return cabeca == null;
	}
	
	void clear() {
		while (!this.isEmpty()) {
			cabeca.valor = null;
			cabeca = cabeca.proximo;
		}
	}
	
	void list(Consumer<T> function) {
		ElementoFila<T> atual = cabeca;
		
		while(atual != null) {
			function.accept(atual.valor);
			atual = atual.proximo;
		}
	}

	Integer maiorValor() { 
		if(isEmpty()) {
			throw new RuntimeException("Não existe maior valor numa fila vazia!");
		}
		
		if(!(cabeca.valor instanceof Integer)) {
			throw new RuntimeException("O Deque precisa ser do tipo Integer.");
		}
		
		ElementoFila<T> atual = cabeca;
		
		Integer maiorAtual = (Integer) cabeca.valor;
		while(atual != null) {
			if((Integer) atual.valor > maiorAtual) {
				maiorAtual = (Integer) atual.valor;
			}
			
			atual = atual.proximo;
		}

		return maiorAtual;
	}
	
	boolean temEsteValor(int valorProcurando) {
		ElementoFila<T> atual = cabeca;
		
		while(atual != null) {
			if(atual.valor.equals(valorProcurando)) {
				return true;
			}
			
			atual = atual.proximo;
		}
		
		return false;
	}
	
	double media() {
		if(isEmpty()) {
			throw new RuntimeException("A fila está vazia.");
		}
		
		if(!(cabeca.valor instanceof Integer)) {
			throw new RuntimeException("Este método requer que a fila seja do tipo Integer.");
		}
		
		ElementoFila<T> atual = cabeca;
		int soma = 0;
		int numElementos = 0;
		
		while(atual != null) {
			soma += (Integer) atual.valor;
			numElementos++;
			atual = atual.proximo;
		}
		
		return (double) soma / numElementos;
	}

	int mediana() {
		if(isEmpty()) {
			throw new RuntimeException("A fila está vazia.");
		}
		
		if(!(cabeca.valor instanceof Integer)) {
			throw new RuntimeException("Este método requer que a fila seja do tipo Integer.");
		}
		
		ElementoFila<T> atual = cabeca;
		int numElementos = 0;
		
		//Contando quantos elementos existem nesta lista...
		while(atual != null) {
			numElementos++;
			atual = atual.proximo;
		}
		
		atual = cabeca;
		int posicaoAtual = 0;
		
		//Procurando o elemento que está (mais ou menos) no meio
		while(atual != null) {
			if(posicaoAtual == (numElementos / 2)) {
				return (Integer) atual.valor;
			}
			
			atual = atual.proximo;
			posicaoAtual++;
		}
		
		throw new RuntimeException("Não foi possível calcular a mediana.");
	}

	int moda() {
		if(isEmpty()) {
			throw new RuntimeException("A fila está vazia.");
		}
		
		if(!(cabeca.valor instanceof Integer)) {
			throw new RuntimeException("Este método requer que a fila seja do tipo Integer.");
		}

        HashMap<Integer, Integer> frequenciaValores = new HashMap<>();
		
		ElementoFila<T> i = cabeca;

		int posicaoAtualExterno = 0;

		while(i != null) {
			ElementoFila<T> j = cabeca;
            int posicaoAtualInterno = 0;

            if(frequenciaValores.get(i.valor) == null) {
                frequenciaValores.put((Integer)i.valor, 0);
            }

			while(j != null) {
			    if(posicaoAtualInterno >= posicaoAtualExterno && j.valor == i.valor) {
                    frequenciaValores.put((Integer)j.valor, frequenciaValores.get(j.valor) + 1);
                }
				j = j.proximo;
                posicaoAtualInterno++;
			}

			i = i.proximo;
            posicaoAtualExterno++;
		}

        return Collections.max(frequenciaValores.entrySet(), comparingInt(HashMap.Entry::getValue)).getKey();
	}
}