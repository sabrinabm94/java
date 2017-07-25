public class dividir {
	public float dividir(float numeroA, float numeroB){
		subtrair Subtracao = new subtrair();
		float resposta = 0;
		float i = 0;
		float resto;
		boolean negA = false;
		boolean negB = false;
		
		if(numeroA < 0) {
			resposta = -resposta;
			numeroA = -numeroA;
			negA = true;
		}
		
		if (numeroB < 0) {
			numeroB = -numeroB;
			negB = true;
		}

		if (numeroB == 0) {
			System.out.print("O número B é inválido... ");
			resposta = Float.NaN;
		}
		
		else {
			if(numeroB == 1){
				resposta = numeroA;
	 		}
			
			else {
				if(numeroA >= numeroB) {
					float resultado = numeroA;
					
					for(i = 0; resultado >= numeroB; i++) {
						resultado = Subtracao.subtrair(resultado, numeroB);
						resto = numeroA - numeroB;
					}
					
					 resposta = i;
				}
		
			}
			
		}
		
		if(negA == true && negB == true) {
			return resposta;
		}
		
		else {
			if(negA == true || negB == true) {
				return -resposta;
			}
		}
		
		return resposta;
	}
}
