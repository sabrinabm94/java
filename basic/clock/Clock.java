package clock;
public class Clock {
	private long angle;
	public long calculeAngle(long hours, long minutes) { //método para calcular os graus
		/* Lógica de resolução
	    Total: 360 - 360/12 = 30 graus
		ponteiro das horas: 30 graus em 60 minutos ou seja 40 minutos são 15 graus
		ponteiro dos minutos: 30 graus em 5 minutos ou seja 6 graus por minuto
        01:00h possui um ângulo de 360
        00:30h possui um ângulo de 180 
        00:15h possui um ângulo de 90 (no e-mail do desafio estava como 45, seria alguma peculiaridade do desafio ou somente erro de digitação? considerei como a segunda opção.
        00:00h possui um ângulo de 0
		*/	
		return (6*minutes)+((hours*60)*6);//aplicando formula para descobrir ângulo e convertendo horas em minutos
	}
	public long calculeMinuts(long angle) {
		return angle/6; //aplicando formula para descobrir os minutos 
	}
	public void returnAngle(long hours, long minutes) { 
		System.out.println("O ângulo da hora informada é: " + calculeAngle(hours, minutes) + " graus");
	}
	public void returnMinuts(long angle) { //método para retornar a informação ao usuário
		System.out.println("Os minutos percorridos pelo ângulo é: " + calculeMinuts(angle) + " graus");
	}
}
