package mathOperations;

public class MathOperations {
	public static void main(String[] args) {
		double a = 8.7;
		double b = 7.3;
		double c = -3.4;
		
		Print.print("\nMath.ceil() Rounding up");
		Print.print("A = " + a + ", Math.ceil(a) = " + Math.ceil(a));
		Print.print("B = " + b + ", Math.ceil(b) = " + Math.ceil(b));
		Print.print("C = " + c + ", Math.ceil(c) = " + Math.ceil(c));

		Print.print("\nMath.floor() Rounding down");
		Print.print("A = " + a + ", Math.floor(a) = " + Math.floor(a));
		Print.print("B = " + b + ", Math.floor(b) = " + Math.floor(b));
		Print.print("C = " + c + ", Math.floor(c) = " + Math.floor(c));

		Print.print("\nMath.max() Returns greater value");
		Print.print("Math.max("+ a +", "+ b +")= " + Math.max(a,b));

		Print.print("\nMath.min() Returns lower value");
		Print.print("Math.min("+ a +", "+ b +")= " + Math.min(a,b));

		Print.print("\nMath.sqrt() Calculate the square root");
		Print.print("Math.sqrt(9)= " + Math.sqrt(9));

		Print.print("\nMath.pow(base, cube) Calculate cube");
		Print.print("Math.pow(2,3)= " + Math.pow(2,3));

		Print.print("\nMath.PI() Calculate PI");
		Print.print("Math.PI = " + Math.PI);

		Print.print("\nNumber of Euler Math.E)= " + Math.E);

		Print.print("\nRandom numbers");
		for(int i = 0; i < 10; i++){
			Print.print(Math.random()+ " ");
		}

		Print.print("\nRandom numbers between 0 and 100");
		for(int i = 0; i < 10; i++){
			Print.print(Math.random()+ " ");
			int r = (int) (Math.random()) + 100;
			Print.print(r + " ");
		}
	}
}
