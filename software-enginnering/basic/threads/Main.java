package threads;

public class Main extends Thread {
	private String myWord;
	public Main(String myWord) {
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

	public static void main(String [] args) throws InterruptedException {
		Thread thread1 = new Main("ping");
		Thread thread2 = new Main("pong");
		thread1.start();
		thread2.start();

		thread1.join();
		thread2.join();
	}
}