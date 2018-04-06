package pilha;

public class PilhaEstatica {
	private int top;
	Object pilha[];
	
	public PilhaEstatica(int capacidade) {
		pilha = new Object[capacidade];
		top = 0;		
	}
	
	public void push(Object o) {
		if(isFull() == false) {
			pilha[top] = o;
			top = top + 1;
		} else {
			System.out.println("Não tem espaço para novos elementos, a pilha alcançou sua capacidade!");
		}
	}
	
	public Object pop() {
		pilha[capacidade].pop();	
	}
	
	public void clear() {
		while(isFull() == true){
			pilha[capacidade].pop();
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
