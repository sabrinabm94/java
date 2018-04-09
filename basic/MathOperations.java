
public class MathOperations {
	public static void main(String[] args) {
		double a = 8.7;
		double b = 7.3;
		double c = -3.4;
		
		System.out.println("Math.ceil() Rounding up");
		System.out.println("A = " + a + ", Math.ceil(a) = " + Math.ceil(a));
		System.out.println("B = " + b + ", Math.ceil(b) = " + Math.ceil(b));
		System.out.println("C = " + c + ", Math.ceil(c) = " + Math.ceil(c));
		
		System.out.println("Math.floor() Rounding down");
		System.out.println("A = " + a + ", Math.floor(a) = " + Math.floor(a));
		System.out.println("B = " + b + ", Math.floor(b) = " + Math.floor(b));
		System.out.println("C = " + c + ", Math.floor(c) = " + Math.floor(c));
		
		System.out.println("Math.max() Returns greater value");
		System.out.println("Math.max("+ a +", "+ b +")= " + Math.max(a,b));
		
		System.out.println("Math.min() Returns lower value");
		System.out.println("Math.min("+ a +", "+ b +")= " + Math.min(a,b));
		
		System.out.println("Math.sqrt() Calculate the square root");
		System.out.println("Math.sqrt(9)= " + Math.sqrt(9));
		
		System.out.println("Math.pow(base, cube) Calculate cube");
		System.out.println("Math.pow(2,3)= " + Math.pow(2,3));
		
		System.out.println("Math.PI() Calculate PI");
		System.out.println("Math.PI = " + Math.PI);
		
		System.out.println("Number of Euler Math.E)= " + Math.E);
		
		System.out.println("Random numbers");
		for(int i = 0; i < 10; i++){
			System.out.print(Math.random()+ " ");
		}
		
		System.out.println("\n Random numbers between 0 and 100");
		for(int i = 0; i < 10; i++){
			System.out.println(Math.random()+ " ");
			int r = (int) (Math.random()) + 100;
			System.out.print(r + " ");
		}
	}

}
