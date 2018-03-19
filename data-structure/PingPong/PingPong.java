public class PingPong extends Thread {
	private String myWord;
	
	public PingPong(String myWord) {
		this.myWord = myWord;
	}
	
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.print(myWord + " ");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String [] args) {
		Thread t1 = new PingPong("ping");
		Thread t2 = new PingPong("pong");
		t1.start();
		t2.start();
		System.out.print("Main function finalized! \n");
	}
}