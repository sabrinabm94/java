package buffer;

public class Produtor extends Thread {
	private Buffer buffer;
	public Produtor(Buffer buffer) {
		this.buffer = buffer;
	}
	public void run() {
		while(true) {
			buffer.put(Math.random()); 
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
