package pilha;
public class Pilha {
	public static void main(String[] args) {
		PilhaEstatica p = new PilhaEstatica(5);
		for(int i = 0; i <= 6; i++) {
			p.push(i); //adicionando elementos na pilha
		}
		p.pop(); //remove um elemento da pilha
		p.clear(); //remove elementos da pilha enquanto ela não estiver vazia
	}
}
