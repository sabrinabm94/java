package semaphore;

import javaRepositories.Print;

public class Main {
	public static void main (String[] args) {
		Semaphore semaphore = new Semaphore();

		Print.print(semaphore.catchCurrentPhase());
		semaphore.changeNextPhase();

		Print.print(semaphore.catchCurrentPhase());
		semaphore.changeNextPhase();

		Print.print(semaphore.catchCurrentPhase());
		semaphore.changeNextPhase();

		Print.print(semaphore.catchCurrentPhase());
		semaphore.changeNextPhase();

		Print.print(semaphore.catchCurrentPhase());
		semaphore.changeNextPhase();
	}
}