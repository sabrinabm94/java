package calculatorBasic;

import javaRepositories.Print;

public class Divide {
	public float division(float numberA, float numberB){
		Subtract Subtract = new Subtract();
		float answer = 0;
		float i = 0;
		float resto;
		boolean negA = false;
		boolean negB = false;
		
		if(numberA < 0) {
			answer = -answer;
			numberA = -numberA;
			negA = true;
		}
		
		if (numberB < 0) {
			numberB = -numberB;
			negB = true;
		}

		if (numberB == 0) {
			Print.print("Number B is invalid... ");
			answer = Float.NaN;
		}
		
		else {
			if(numberB == 1){
				answer = numberA;
			}
			
			else {
				if(numberA >= numberB) {
					float result = numberA;
					
					for(i = 0; result >= numberB; i++) {
						result = Subtract.subtraction(result, numberB);
						resto = numberA - numberB;
					}
					
					answer = i;
				}
			}
		}
		
		if(negA == true && negB == true) {
			return answer;
		}
		
		else {
			if(negA == true || negB == true) {
				return -answer;
			}
		}
		
		return answer;
	}
}
