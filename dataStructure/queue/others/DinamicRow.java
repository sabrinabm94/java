package queue.others;

import java.util.Collections;
import java.util.HashMap;
import java.util.function.Consumer;

import static java.util.Comparator.comparingInt;

class DinamicRow<T> {
	private Element<T> cabeca;
	private Element<T> cauda;
	
	void add(T value) {
        Element<T> novo = new Element<>(value, null, null);
		
		if(isEmpty()) {
			cabeca = novo;
			cauda = novo;
			return;
		}
		
		if(cabeca == cauda) { //um Elemento<T> só
			cabeca.next = novo;
		}
		
		cauda.next = novo;
		cauda = novo;
	}
	
	T remove() {
		if(isEmpty()) {
			throw new RuntimeException("Não é possível remover um elemento de uma fila vazia.");
		}
		T removed = cabeca.value;
		
		cabeca = cabeca.next;
		
		return removed;
	}
	
	boolean isEmpty() {
		return cabeca == null;
	}
	
	void clear() {
		while (!this.isEmpty()) {
			cabeca.value = null;
			cabeca = cabeca.next;
		}
	}
	
	void list(Consumer<T> function) {
        Element<T> atual = cabeca;
		
		while(atual != null) {
			function.accept(atual.value);
			atual = atual.next;
		}
	}

	Integer maiorValor() { 
		if(isEmpty()) {
			throw new RuntimeException("Não existe maior valor numa fila vazia!");
		}
		
		if(!(cabeca.value instanceof Integer)) {
			throw new RuntimeException("O DequeRemove precisa ser do tipo Integer.");
		}

        Element<T> atual = cabeca;
		
		Integer maiorAtual = (Integer) cabeca.value;
		while(atual != null) {
			if((Integer) atual.value > maiorAtual) {
				maiorAtual = (Integer) atual.value;
			}
			
			atual = atual.next;
		}

		return maiorAtual;
	}
	
	boolean temEsteValor(int valorProcurando) {
        Element<T> atual = cabeca;
		
		while(atual != null) {
			if(atual.value.equals(valorProcurando)) {
				return true;
			}
			
			atual = atual.next;
		}
		
		return false;
	}
	
	double media() {
		if(isEmpty()) {
			throw new RuntimeException("A fila está vazia.");
		}
		
		if(!(cabeca.value instanceof Integer)) {
			throw new RuntimeException("Este método requer que a fila seja do tipo Integer.");
		}

        Element<T> atual = cabeca;
		int soma = 0;
		int numElementos = 0;
		
		while(atual != null) {
			soma += (Integer) atual.value;
			numElementos++;
			atual = atual.next;
		}
		
		return (double) soma / numElementos;
	}

	int mediana() {
		if(isEmpty()) {
			throw new RuntimeException("A fila está vazia.");
		}
		
		if(!(cabeca.value instanceof Integer)) {
			throw new RuntimeException("Este método requer que a fila seja do tipo Integer.");
		}

        Element<T> atual = cabeca;
		int numElementos = 0;
		
		//Contando quantos elementos existem nesta lista...
		while(atual != null) {
			numElementos++;
			atual = atual.next;
		}
		
		atual = cabeca;
		int posicaoAtual = 0;
		
		//Procurando o elemento que está (mais ou menos) no meio
		while(atual != null) {
			if(posicaoAtual == (numElementos / 2)) {
				return (Integer) atual.value;
			}
			
			atual = atual.next;
			posicaoAtual++;
		}
		
		throw new RuntimeException("Não foi possível calcular a mediana.");
	}

	int moda() {
		if(isEmpty()) {
			throw new RuntimeException("A fila está vazia.");
		}
		
		if(!(cabeca.value instanceof Integer)) {
			throw new RuntimeException("Este método requer que a fila seja do tipo Integer.");
		}

        HashMap<Integer, Integer> frequenciaValores = new HashMap<>();

        Element<T> i = cabeca;

		int posicaoAtualExterno = 0;

		while(i != null) {
            Element<T> j = cabeca;
            int posicaoAtualInterno = 0;

            if(frequenciaValores.get(i.value) == null) {
                frequenciaValores.put((Integer)i.value, 0);
            }

			while(j != null) {
			    if(posicaoAtualInterno >= posicaoAtualExterno && j.value == i.value) {
                    frequenciaValores.put((Integer)j.value, frequenciaValores.get(j.value) + 1);
                }
				j = j.next;
                posicaoAtualInterno++;
			}

			i = i.next;
            posicaoAtualExterno++;
		}

        return Collections.max(frequenciaValores.entrySet(), comparingInt(HashMap.Entry::getValue)).getKey();
	}
}