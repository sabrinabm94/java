public class potencia {
	float resultado = 0;
	public float potencia(float numeroA, float numeroB){
		multiplicar Multiplicar = new multiplicar();
		resultado = numeroA;
		
		if(numeroB == 0) {
			return 1;
		}
		
		if(numeroA == 0){
			return 0;
		}
		
		for(int i = 1; i < numeroB; i++) {
			resultado = Multiplicar.multiplicar(numeroA, resultado);
		}
		
		return resultado;
	}

}
