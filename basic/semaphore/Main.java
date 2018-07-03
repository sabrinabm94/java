public class Main {
	public static void main (String[] args) {
		Semaphore s = new Semaphore();
		System.out.println(s.catchCurrentPhase());
		s.changeNextPhase();
		System.out.println(s.catchCurrentPhase());
		s.changeNextPhase();
		System.out.println(s.catchCurrentPhase());
		s.changeNextPhase();
		System.out.println(s.catchCurrentPhase());
		s.changeNextPhase();
		System.out.println(s.catchCurrentPhase());
		s.changeNextPhase();
		
	}
}