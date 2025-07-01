package clock;

import javaRepositories.Print;

public class Clock {
	private long angle;

	public long calculeAngleByHoursAndMinuts(long hours, long minutes) {
		/* Lógica da resolução
	    Total: 360 - 360/12 = 30 graus
		ponteiro das horas: 30 graus em 60 minutos ou seja 40 minutos são 15 graus
		ponteiro dos minutos: 30 graus em 5 minutos ou seja 6 graus por minuto

        01:00h possui um angulo de 360
        00:30h possui um angulo de 180
        00:15h possui um angulo de 90
        00:00h possui um angulo de 0
		*/	
		return ((minutes + calculateMinutsByHours(hours)) * 6);
	}

	public long calculeAngleByHours(long hours) {
		return (hours * 30);
	}

	public long calculeAngleByMinutes(long minutes) {
		return (long) (minutes * 0.5);
	}

	public long calculeMinutesByAngle(long angle) {
		return angle / 6;
	}

	public long calculeHoursByAngle(long angle) {
		return angle / 30;
	}

	public long calculateHoursByMinuts(long hours) {
		return hours / 60;
	}

	public long calculateMinutsByHours(long minutes) {
		return minutes * 60;
	}

	public void returnAngleByHoursAndMinuts(long hours, long minutes) {
		Print.print("The angle for the selected hour is: " + calculeAngleByHoursAndMinuts(hours, minutes) + " degrees");
	}

	public void returnAngleByHours(long hours) {
		Print.print("The angle for the selected hour is: " + calculeAngleByHours(hours) + " degrees");
	}

	public void returnAngleByMinuts(long minutes) {
		Print.print("The angle for the selected minutes is: " + calculeAngleByMinutes(minutes) + " degrees");
	}

	public void returnMinutesByAngle(long angle) {
		Print.print("The minutes for the angle is: " + calculeMinutesByAngle(angle) + " degrees");
	}

	public void returnHoursByAngle(long angle) {
		Print.print("The hours for the angle is: " + calculeHoursByAngle(angle) + " degrees");
	}
}
