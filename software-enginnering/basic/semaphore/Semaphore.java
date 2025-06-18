package semaphore;

public class Semaphore {
	private String currentPhase = "Green";
	
	public String catchCurrentPhase() {
		return currentPhase;
	}
	
	public void changeNextPhase() {
		if(currentPhase.equals("Green")) {
			currentPhase = "Yellow";
		}
		else if (currentPhase.equals("Yellow")) {
			currentPhase = "Red";
		}
		else if (currentPhase.equals("Red")) {
			currentPhase = "Green";
		}
	}
}