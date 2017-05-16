
public class Erros {
	public static void main(String[] args) {
		int i = 4;
		int j = 0;
		int x;
		
		try {
			x = i/j;
		}
		
		catch (ArithmeticException a){
			System.out.println("Divisão por zero.");
		}
		
		catch(Exception e) {
			System.out.println("erro: " + e.getMessage());
		}
		
		finally{
			System.out.println("Bloco finally, sempre executa");
		}

	}

}
