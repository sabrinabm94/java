package calculator;

public class Multiply {
	public float multiplication(float numberA, float numberB) {
		float result = 0;
		boolean negA = false;
		boolean negB = false;

		Sum Sum = new Sum();
		
		if(numberA < 0) {
			numberA = -numberA;
			negA = true;
		}

		if(numberB < 0) {
			numberB = -numberB;
			negB = true;
		}
		
		for(int i = 0; i < numberB; i++) {
			result = result + Sum.summation(numberA, 0);
		}

		if(negA == true && negB == false) {
			return -result;
		}
		
		else {
			if(negA == false && negB == true) {
				return -result;
			}
		}
		
		return result;
	}
}
