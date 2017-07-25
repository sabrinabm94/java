public class multiplicar {
	public float multiplicar(float numeroA, float numeroB) {
		float resultado = 0;
		boolean negA = false;
		boolean negB = false;

		somar Soma = new somar();
		
		if(numeroA < 0) {
			numeroA = -numeroA;
			negA = true;
		}

		if(numeroB < 0) {
			numeroB = -numeroB;
			negB = true;
		}
		
		for(int i = 0; i < numeroB; i++) {
			resultado = resultado + Soma.somar(numeroA, 0);
		}

		if(negA == true && negB == false) {
			return -resultado;
		}
		
		else {
			if(negA == false && negB == true) {
				return -resultado;
			}
		}
		
		return resultado;
	}
}


/*
 *  verifica se a negativo
 *   aNeg = true
 *   a = -a
 *  verifica se b negativo
 *    bNeg = true
 *    b = -b
 *    
 *    for da multiplicacao
 * 
 *   
 *   verifica se aNeg ou bNeg
 *     resultado = -resultado
 *   
 *   return resultado
 *   
 *   se os sinais forem iguais  sinais iguais é positivo
 *   sinais diferentes negativo
 * 
 */

