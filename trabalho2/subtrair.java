public class subtrair {
	public float subtrair(float numeroA, float numeroB) {
		somar Soma = new somar();
		float resultado = 0;
		boolean negA = false;
		boolean negB = false;
		
		if(numeroA < 0) {
			numeroA = -numeroA;
			negA = true;
		}

		if(numeroB < 0) {
			numeroB = -numeroB;
			negB = true;
		}
		
		if(negA == true && negB == true) {
			return Soma.somar(numeroA, -numeroB);
		}
		
		if(negA == false && negB == false) {
			return Soma.somar(numeroA, -numeroB);
		}
		
		if(negA == true && negB == false) {
			return Soma.somar(numeroA, numeroB);
		}
		
		if(negA == false && negB == true) {
			return Soma.somar(numeroA, numeroB);
		}
	
		return Soma.somar(numeroA, -numeroB);
	}
}
