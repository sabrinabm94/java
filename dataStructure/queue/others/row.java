package queue.others;

class row<T> {
	row<T> next;
	T value;
	
	row(T value, row<T> next) {
		this.value = value;
		this.next = next;
	}

	@Override
	public String toString() {
		return value.toString();
	}
}

//filas
//armazenar conjuntos de dados, visitar e recuperar dados
//simples e similar a pilha, acesso/remoção sempre ao inicio na mesma order da adição e novas adição ao fim (FIFO - First in, First Out)
//tipos de filas: espera (queue), duplamente terminada (deque/double-ended-queue) e prioridade.

//fila estática: utiliza vetor com sete de capacidade (concatenar)
//filas dinâmicas: capacidade desconhecida, utiliza objs encadeados (percorrer)
//deque: permite adicionar ou remover elementos na cabeça ou cauda

//listas encadeadas: identificam o prox e ant elemento com acesso sequecial
//lista duplamente encadeada: identificam o prox e ant, percorre a estrutura pela cabeça ou cauda utilizando deque