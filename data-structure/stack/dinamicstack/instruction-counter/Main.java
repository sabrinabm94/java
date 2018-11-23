package dinamicstack;
public class Main {
	public static void main(String[] args) {
		DinamicStack dinamicStack = new DinamicStack();
		for(int i = 1; i <= 100; i++) {
			dinamicStack.push(i); 
			dinamicStack.runThrough(0); 
			
			System.out.println(dinamicStack.contadorAdicionar + ";" + dinamicStack.contadorLocalizar);
		}
	}
}
