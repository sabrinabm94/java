public class Subtract {
	public float subtraction(float numberA, float numberB) {
		summation Sum = new summation();
		float result = 0;
		boolean negA = false;
		boolean negB = false;
		
		if(numberA < 0) {
			numberA = -numberA;
			negA = true;
		}

		if(numberB < 0) {
			numberB = -numberB;
			negB = true;
		}
		
		if(negA == true && negB == true) {
			return Sum.summation(numberA, -numberB);
		}
		
		if(negA == false && negB == false) {
			return Sum.summation(numberA, -numberB);
		}
		
		if(negA == true && negB == false) {
			return Sum.summation(numberA, numberB);
		}
		
		if(negA == false && negB == true) {
			return Sum.summation(numberA, numberB);
		}

		return Sum.summation(numberA, -numberB);
	}
}
