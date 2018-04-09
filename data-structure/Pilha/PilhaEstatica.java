package pilha;
public class PilhaEstatica {
	private int top;
	private Object pilha[];
	public PilhaEstatica(int capacidade) {
		pilha = new Object[capacidade];
		top = 0;		
	}
	public void push(Object o) {
		if(isFull() == false) {
			System.out.println("Adicionando elemento na pilha...");
			pilha[top] = o;
			top = top + 1;
		} else {
			System.out.println("Não tem espaço para novos elementos, a pilha alcançou sua capacidade!");
		}
	}
	public Object pop() {
		if(isEmpty() == false) {
			System.out.println("Retirando elemento da pilha...");
			top = top - 1;
			if(top == 0) {
				System.out.println("A pilha está vazia!");
			}
			return pilha[top];
		} else {
			return null;
		}
	}
	public void clear() {
		while(isEmpty() == false){
			pop();
		}
	}
	public boolean isFull() {
		if(top == pilha.length){
			return true;
		} else {
			return false;
		}   
		
	}
	public boolean isEmpty() {
		if(top == 0){
			return true;
		} else {
			return false;
		}
	}
}
