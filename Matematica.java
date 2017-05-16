
public class Matematica {
	public static void main(String[] args) {
		double a = 8.7;
		double b = 7.3;
		double c = -3.4;
		
		System.out.println("Math.ceil() arredondamento para cima");
		System.out.println("A = " + a + ", Math.ceil(a) = " + Math.ceil(a));
		System.out.println("B = " + b + ", Math.ceil(b) = " + Math.ceil(b));
		System.out.println("C = " + c + ", Math.ceil(c) = " + Math.ceil(c));
		
		System.out.println("Math.floor() arredondamento para baixo");
		System.out.println("A = " + a + ", Math.floor(a) = " + Math.floor(a));
		System.out.println("B = " + b + ", Math.floor(b) = " + Math.floor(b));
		System.out.println("C = " + c + ", Math.floor(c) = " + Math.floor(c));
		
		System.out.println("Math.max() retorna maior valor");
		System.out.println("Math.max("+ a +", "+ b +")= " + Math.max(a,b));
		
		System.out.println("Math.min() retorna menor valor");
		System.out.println("Math.min("+ a +", "+ b +")= " + Math.min(a,b));
		
		System.out.println("Math.sqrt() Calcula a raiz quadrada");
		System.out.println("Math.sqrt(9)= " + Math.sqrt(9));
		
		System.out.println("Math.pow(base,potencia) Calcula potência");
		System.out.println("Math.pow(2,3)= " + Math.pow(2,3));
		
		System.out.println("Math.PI() Calcula o PI");
		System.out.println("Math.PI = " + Math.PI);
		
		System.out.println("Numero de Euler Math.E)= " + Math.E);
		
		System.out.println("Números randômicos");
		for(int i = 0; i < 10; i++){
			System.out.print(Math.random()+ " ");
		}
		
		System.out.println("\n Números aleatórios entre 0 e 100");
		for(int i = 0; i < 10; i++){
			System.out.println(Math.random()+ " ");
			int r = (int) (Math.random()) + 100;
			System.out.print(r + " ");
		}
	}

}
