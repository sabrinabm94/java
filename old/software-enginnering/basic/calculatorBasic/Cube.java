package calculatorBasic;

public class Cube {
	float result = 0;
	public float cubed(float numberA, float numberB){
		Multiply Multiply = new Multiply();
		result = numberA;
		
		if(numberB == 0) {
			return 1;
		}
		
		if(numberA == 0){
			return 0;
		}
		
		for(int i = 1; i < numberB; i++) {
			result = Multiply.multiplication(numberA, result);
		}
		
		return result;
	}
}
